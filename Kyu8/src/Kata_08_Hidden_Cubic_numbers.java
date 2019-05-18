import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Kata_08_Hidden_Cubic_numbers {
    public static void main(String[] args) {
        String s = "0 9026315 -827&()";
        String s2 = "aqdf& 407 0 1 xyz 153 777.777";
        String s3 = "QK29 45[&erui";

        System.out.println(isSumOfCubes(s));
        System.out.println(isSumOfCubes(s2));
        System.out.println(isSumOfCubes(s3));
    }

    public static String isSumOfCubes(String s) {
        StringBuilder result = new StringBuilder();
        String[] inputArr = s.split("\\s+");

        final int[] sum = {0};
        for (String token : inputArr) {
            List<Integer> cubicNumber = isCubicNumber(token);
            if (cubicNumber.size() > 0) {
                sum[0] += cubicNumber
                        .stream()
                        .mapToInt(x -> x)
                        .sum();

                cubicNumber.forEach(number -> result.append(number).append(" "));
            }
        }

        if (result.length() == 0) {
            return "Unlucky";
        } else {
            return result.append(sum[0]).append(" Lucky").toString();
        }
    }

    private static List<Integer> isCubicNumber(String token) {
        List<Integer> resultList = new ArrayList<>();

        Pattern pattern = Pattern.compile("^\\d+$");
        Matcher matcher = pattern.matcher(token);

        if (matcher.find()) {
            char[] chars = token.toCharArray();

            int counter = 0;
            int sum = 0;
            String currentNum = "";

            for (int i = 0; i < chars.length; i++) {
                currentNum += chars[i] + "";
                int digit = chars[i] - '0';
                sum += Math.pow(digit, 3);
                counter++;

                if (counter == 3 || i == chars.length - 1) {
                    counter = 0;
                    int number = Integer.parseInt(currentNum);
                    currentNum = "";
                    if (sum == number) {
                        resultList.add(number);
                    }
                    sum = 0;
                }
            }
        }

        return resultList;
    }
}

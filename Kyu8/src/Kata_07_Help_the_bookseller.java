import java.util.Arrays;

public class Kata_07_Help_the_bookseller {

    public static void main(String[] args) {
        String art[] = new String[]{"ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600"};
        String cd[] = new String[]{"A", "B"};

        String result = stockSummary(art, cd);
        System.out.println(result);
    }

    public static String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        StringBuilder result = new StringBuilder();

        if (lstOf1stLetter.length == 0 || lstOfArt.length == 0) {
            return "";
        }

        for (String letter : lstOf1stLetter) {
            int count = Arrays.stream(lstOfArt)
                    .filter(art -> art.startsWith(letter))
                    .mapToInt(art -> Integer.parseInt(art.split(" ")[1])).sum();
            result.append(String.format("(%s : %d) - ", letter, count));
        }

        String resultStr = result.toString();

        return resultStr.substring(0, resultStr.length() - 3);
    }
}

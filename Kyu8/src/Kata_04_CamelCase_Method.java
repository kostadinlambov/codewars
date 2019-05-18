import java.util.Arrays;

public class Kata_04_CamelCase_Method {

    public static void main(String[] args) {
        System.out.println(camelCase("hello case"));
        System.out.println(camelCase("camel case word"));
        System.out.println(camelCase(""));
    }

    public static String camelCase(String str) {
        String[] split = str.trim().split("\\s+");
        StringBuilder result = new StringBuilder();
        for (String s : split) {
            if(str.length()> 0)
            result.append(s.substring(0, 1).toUpperCase()).append(s.substring(1));
        }
        return  result.toString();

//        if(str.length() > 0){
//            Arrays.stream(str.split("\\s+")).forEach(string ->   sb.append(string.substring(0, 1).toUpperCase() + string.substring(1))
//
//            )
//        }
//
//        return sb.toString();
    }
}

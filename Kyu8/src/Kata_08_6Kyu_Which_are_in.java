import java.util.*;

public class Kata_08_6Kyu_Which_are_in {

    public static void main(String[] args) {
        String[] a = new String[]{"arp", "live", "strong"};
        String[] b = new String[]{"lively", "alive", "harp", "sharp", "armstrong"};
        String[] r = new String[]{"arp", "live", "strong"};

        String[] strings = inArray(a, b);
        System.out.println(Arrays.toString(strings));
    }

    public static String[] inArray(String[] array1, String[] array2) {
        Set<String> resultSet = new TreeSet<>();

        Arrays.stream(array2).forEach(string -> {
            Arrays.stream(array1).forEach(secondString -> {
                if(string.contains(secondString)){
                    resultSet.add(secondString);
                }
            });

        });

        return resultSet.toArray(new String[0]);
    }
}

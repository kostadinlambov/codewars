import java.util.ArrayList;
import java.util.List;

public class Kata_01_Human_readable_duration_format {
    public static void main(String[] args) {
//        assertEquals("1 second", TimeFormatter.formatDuration(1));
//        assertEquals("1 minute and 2 seconds", TimeFormatter.formatDuration(62));
//        assertEquals("2 minutes", TimeFormatter.formatDuration(120));
//        assertEquals("1 hour", TimeFormatter.formatDuration(3600));
//        assertEquals("1 hour, 1 minute and 2 seconds", TimeFormatter.formatDuration(3662));

        System.out.println(formatDuration(1));
        System.out.println(formatDuration(62));
        System.out.println(formatDuration(120));
        System.out.println(formatDuration(3600));
        System.out.println(formatDuration(3662));
    }

    public static String formatDuration(int seconds) {
        if (seconds == 0) {
            return "now";
        }

        int[] denominators = new int[]{31536000, 86400, 3600, 60, 1};
        String[] keys = new String[]{"year", "day", "hour", "minute", "second"};

        List<String> resultList = new ArrayList<>();

        StringBuilder sbResult = new StringBuilder();
        for (int i = 0; i < keys.length; i++) {
            int currentValue = seconds / denominators[i];
            seconds %= denominators[i];

            if (currentValue != 0) {
                if (currentValue == 1) {
                    resultList.add(String.format("%d %s, ", currentValue, keys[i]));
                } else {
                    resultList.add(String.format("%d %ss, ", currentValue, keys[i]));
                }
            }
        }

        if (resultList.size() > 1) {
            for (int i = 0; i < resultList.size(); i++) {
                if (i == resultList.size() - 1) {
                    sbResult.reverse().delete(0, 2).reverse().append(" and ");
                    sbResult.append(resultList.get(i));
                } else {
                    sbResult.append(resultList.get(i));
                }
            }
        } else {
            sbResult.append(resultList.get(0));
        }

        return sbResult.toString().trim().substring(0, sbResult.length() - 2);
    }
}

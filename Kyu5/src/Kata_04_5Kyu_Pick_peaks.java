import java.util.*;

public class Kata_04_5Kyu_Pick_peaks {
    public static void main(String[] args) {
        int[] input = new int[]{3, 2, 3, 6, 4, 1, 2, 3, 2, 1, 2, 3};
        Map<String, List<Integer>> peaks = getPeaks(input);
        printResult(peaks);

        int[] input2 = new int[]{1, 2, 2, 2, 1};
        Map<String, List<Integer>> peaks2 = getPeaks(input2);
        printResult(peaks2);

        int[] input3 = new int[]{1, 2, 2, 2, 3};
        Map<String, List<Integer>> peaks3 = getPeaks(input3);
        printResult(peaks3);

        int[] input4 = new int[]{3, -4, 13, 5, -1, 9, 18, 13, 13, 11, 5, -1, -1, 14, -1, 12, 12, 15, -2, -1, -4, 19, 3};
        Map<String, List<Integer>> peaks4 = getPeaks(input4);
        printResult(peaks4);
    }

    private static Map<String, List<Integer>> getPeaks(int[] arr) {
        Map<String, List<Integer>> result = new LinkedHashMap<>();
        result.put("pos", new ArrayList<>());
        result.put("peaks", new ArrayList<>());

        if (arr.length > 2) {
            for (int i = 1; i < arr.length - 1; i++) {
                int currentValue = arr[i];
                int lastValue = arr[i - 1];
                int nextValue = arr[i + 1];

                if (currentValue > lastValue && nextValue <= currentValue) {
                    for (int j = i+1; j < arr.length; j++) {
                        if(arr[j] < arr[j-1]){
                            result.get("pos").add(i);
                            result.get("peaks").add(currentValue);
                            i = j - 1;
                            break;
                        }else if( j == arr.length-1){
                            return result;
                        }else if( arr[j] > arr[j-1]){
                            break;
                        }
                    }
                }
            }
        }

        return result;
    }

    private static void printResult(Map<String, List<Integer>> peaks) {
        for (Map.Entry<String, List<Integer>> entry : peaks.entrySet()) {
            System.out.printf("%s - %s\n", entry.getKey(), entry.getValue().toString());
        }
    }

    public static Map<String,List<Integer>> getPeaks2(int[] arr) {
        Map<String,List<Integer>> ans = new HashMap<>() {{
            put("pos",   new ArrayList<>() );
            put("peaks", new ArrayList<>() );
        }};
        int posMax = 0;
        boolean matchAsc = false;

        for (int i = 1 ; i < arr.length ; i++) {
            if (arr[i-1] < arr[i]) {
                matchAsc = true;
                posMax = i;
            }
            if (matchAsc && arr[i-1] > arr[i]) {
                matchAsc = false;
                ans.get("pos").add(posMax);
                ans.get("peaks").add(arr[posMax]);
            }
        }
        return ans;
    }
}


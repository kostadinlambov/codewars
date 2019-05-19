import java.util.HashMap;
import java.util.Map;

public class Kata_05_5Kyu_Greed_is_Good {
    public static void main(String[] args) {
        //"Score for [5,1,3,4,1] must be 250:"
        System.out.println(greedy(new int[]{5, 1, 3, 4, 1}));

        //"Score for [5,1,3,4,1] must be 1100:"
        System.out.println(greedy(new int[]{1, 1, 1, 3, 1}));

        //"Score for [5,1,3,4,1] must be 450:"
        System.out.println(greedy(new int[]{2, 4, 4, 5, 4}));
    }

    public static int greedy(int[] dice) {
        Map<Integer, Integer> numbers = new HashMap<>();

        for (int currentValue : dice) {
            if (!numbers.containsKey(currentValue)) {
                numbers.put(currentValue, 0);
            }

            numbers.put(currentValue, numbers.get(currentValue) + 1);
        }

        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : numbers.entrySet()) {
            sum += getCurrentSum(entry.getKey(), entry.getValue());
        }

        return sum;
    }

    private static int getCurrentSum(Integer key, Integer value) {
        switch (key) {
            case 1:
                return (value / 3) * 1000 + (value % 3) * 100;
            case 2:
                return (value / 3) * 200;
            case 3:
                return (value / 3) * 300;
            case 4:
                return (value / 3) * 400;
            case 5:
                return (value / 3) * 500 + (value % 3) * 50;
            case 6:
                return (value / 3) * 600;
            default:
                return 0;
        }
    }
}

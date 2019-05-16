import java.util.Arrays;

public class Kata_03_Sum_of_positive {
    public static void main(String[] args) {
//        You get an array of numbers, return the sum of all of the positives ones.
//
//         Example [1,-4,7,12] => 1 + 7 + 12 = 20
//
//        Note: if there is nothing to sum, the sum is default to 0.
        int sum = sum(new int[]{1, -4, 7, 12});

        System.out.println(sum);
    }

    public static int sum(int[] arr){
        return Arrays.stream(arr).filter(x -> x > 0).sum();

    }
}

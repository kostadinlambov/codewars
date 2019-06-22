public class Kata_10_Buddy_Pairs {
    public static void main(String[] args) {
//        testing(1071625, 1103735, "(1081184 1331967)");
////        testing(2382, 3679, "Nothing");
////        testing(381, 4318, "(1050 1925)");

        System.out.println(buddy(1071625, 1103735));
        System.out.println(buddy(2382, 3679));
        System.out.println(buddy(381, 4318));
        System.out.println(buddy(10, 50));
        System.out.println(buddy(2177, 4357));
    }

    public static String buddy(long start, long limit) {
        for (long firstNum = start; firstNum <= limit; firstNum++) {
            long firstSum = calcSum(firstNum);
            long secondSum = calcSum(firstSum);

            long secondNum = secondSum - 1;
            if (secondSum == firstNum && firstSum > firstNum) {
                return String.format("(%d %d)", firstNum, firstSum);
            }
        }

        return "Nothing";
    }

    private static long calcSum(long num) {

        long sum = 1;
        double upperLimit = Math.sqrt(num);
        for (int i = 2; i <= upperLimit; i++) {
            if (num % i == 0) {
                sum += i;
                if (i != upperLimit) {
                    sum += num / i;
                }
            }
        }

        return sum - 1;
    }
}

public class Kata_02_5Kyu_ProdFib {

    public static void main(String[] args) {
        long[] longs = productFib(800);
        System.out.println();
    }

    public static long[] productFib(long prod) {
        long firstFibNum = 0;
        long secondFibNum = 1;

        while (true) {
            long currentFibNumber = firstFibNum + secondFibNum;
            firstFibNum = secondFibNum;
            secondFibNum = currentFibNumber;
            long currentProd = firstFibNum * secondFibNum;

            if (firstFibNum * secondFibNum == prod) {
                return new long[]{firstFibNum, secondFibNum, 1};
            }

            if (firstFibNum * secondFibNum > prod) {
                return new long[]{firstFibNum, secondFibNum, 0};
            }
        }
    }
}

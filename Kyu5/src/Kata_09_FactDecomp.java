import java.util.LinkedHashMap;
import java.util.Map;

public class Kata_09_FactDecomp {

    public static void main(String[] args) {
//        testing(17, "2^15 * 3^6 * 5^3 * 7^2 * 11 * 13 * 17");
//        testing(5, "2^3 * 3 * 5");
//        testing(22, "2^19 * 3^9 * 5^4 * 7^3 * 11^2 * 13 * 17 * 19");
//        testing(14, "2^11 * 3^5 * 5^2 * 7^2 * 11 * 13");
//        testing(25, "2^22 * 3^10 * 5^6 * 7^3 * 11^2 * 13 * 17 * 19 * 23");

//        System.out.println(decomp(17));
//        System.out.println(decomp(14));
        System.out.println(decomp(25));
    }

    public static String decomp(int n) {
        long dezNum = getDezNum(n);

        Map<Long, Long> primes = new LinkedHashMap<>();

        if (!isPrime(dezNum)) {
            long currentNum = dezNum;
            long startNum = 2;
            while (!isPrime(currentNum)) {
                long currentPrimeNum = getNextPrimeNum(startNum, currentNum);
                if (currentNum % currentPrimeNum == 0) {
                    currentNum /= currentPrimeNum;
                    if(!primes.containsKey(currentPrimeNum)){
                        primes.put(currentPrimeNum, 0L);
                    }

                    primes.put(currentPrimeNum, primes.get(currentPrimeNum) + 1);
                }else{
                    startNum = currentPrimeNum + 1;
                }
            }

            if(!primes.containsKey(currentNum)){
                primes.put(currentNum, 0L);
            }

            primes.put(currentNum, primes.get(currentNum) + 1);

        }else{
            primes.put(dezNum, 1L);
        }


        StringBuilder result = new StringBuilder();

        for (Map.Entry<Long, Long> currentPrimeNum : primes.entrySet()) {

            if(currentPrimeNum.getValue() > 1){
                result.append(String.format("%d^%d * ", currentPrimeNum.getKey(), currentPrimeNum.getValue()));
            }else{
                result.append(String.format("%d * ", currentPrimeNum.getKey()));
            }
        }

        return result.toString().substring(0, result.toString().length()- 3);
    }

    private static long getDezNum(int n) {
        long product = 1;
        for (int i = 1; i <= n; i++) {
            product *= i;
        }

        return product;
    }

    private static long getNextPrimeNum(long startNum, long endNum) {
        for (long i = startNum; i <= endNum; i++) {
            if (isPrime(i)) {
                return i;
            }
        }

        return endNum;
    }

    private static boolean isPrime(long n) {
        if (n == 1 || n == 2) {
            return true;
        }

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}

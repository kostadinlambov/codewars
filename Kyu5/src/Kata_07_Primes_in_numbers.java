import java.util.LinkedHashMap;
import java.util.Map;

public class Kata_07_Primes_in_numbers {
    public static void main(String[] args) {
        System.out.println(factors(32837503));
        System.out.println(factors(86240));
    }

    public static String factors(int n) {
        Map<Integer, Integer> primes = new LinkedHashMap<>();

        if (!isPrime(n)) {
            int currentNum = n;
            int startNum = 2;
            while (!isPrime(currentNum)) {
                int currentPrimeNum = getNextPrimeNum(startNum, currentNum);
                if (currentNum % currentPrimeNum == 0) {
                    currentNum /= currentPrimeNum;
                    if(!primes.containsKey(currentPrimeNum)){
                        primes.put(currentPrimeNum, 0);
                    }

                    primes.put(currentPrimeNum, primes.get(currentPrimeNum) + 1);
                }else{
                    startNum = currentPrimeNum + 1;
                }
            }

            if(!primes.containsKey(currentNum)){
                primes.put(currentNum, 0);
            }

            primes.put(currentNum, primes.get(currentNum) + 1);

        }else{
            primes.put(n, 1);
        }


        StringBuilder result = new StringBuilder();

        for (Map.Entry<Integer, Integer> currentPrimeNum : primes.entrySet()) {

            if(currentPrimeNum.getValue() > 1){
                result.append(String.format("(%d**%d)", currentPrimeNum.getKey(), currentPrimeNum.getValue()));
            }else{
                result.append(String.format("(%d)", currentPrimeNum.getKey()));
            }
        }

        return result.toString();
    }

    private static int getNextPrimeNum(int startNum, int endNum) {
        for (int i = startNum; i <= endNum; i++) {
            if (isPrime(i)) {
                return i;
            }
        }

        return endNum;
    }

    private static boolean isPrime(int n) {
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

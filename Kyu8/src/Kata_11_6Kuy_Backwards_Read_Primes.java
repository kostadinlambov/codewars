public class Kata_11_6Kuy_Backwards_Read_Primes {

    public static void main(String[] args) {
//        backwardsPrime(2, 100);
        String result = backwardsPrime(9900, 10000);
        System.out.println(result);

    }

    public static String backwardsPrime(long start, long end) {
        StringBuilder result = new StringBuilder();
        for (long i = start; i <= end; i++) {

            if(isPrime(i)){
                long reversedNumber = reverseNumber(i);
                if(reversedNumber != i && isPrime(reversedNumber)){
                    result.append(i).append(" ");
                }
            }
        }

        return result.toString().trim();
    }

    private static long reverseNumber(long i) {
        long reversedNum = 0;

        while(i != 0){
            int digit = (int) (i % 10);
            reversedNum = reversedNum * 10 + digit ;
            i = i/10;
        }

       return reversedNum;
    }

    private static boolean isPrime(long number){

        if(number > 2 && number % 2 == 0 || number == 1 ){
            return false;
        }

        for (int i = 3; i <= Math.sqrt(number); i+=2) {
            if(number % i == 0){
                return false;
            }
        }

        return true;
    }
}

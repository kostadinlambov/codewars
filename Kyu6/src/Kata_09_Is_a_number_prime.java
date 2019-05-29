public class Kata_09_Is_a_number_prime {
    public static void main(String[] args) {
//        assertFalse("0  is not prime", Prime.isPrime(0));
//        assertFalse("1  is not prime", Prime.isPrime(1));
//        assertTrue ("2  is prime",     Prime.isPrime(2));
//        assertTrue ("73 is prime",     Prime.isPrime(73));
//        assertFalse("75 is not prime", Prime.isPrime(75));
//        assertFalse("-1 is not prime", Prime.isPrime(-1));

        System.out.println(isPrime(0));
        System.out.println(isPrime(1));
        System.out.println(isPrime(2));
        System.out.println(isPrime(73));
        System.out.println(isPrime(75));
        System.out.println(isPrime(-1));
    }

    private static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }else if(num == 2){
            return true;
        }

        if (num % 2 == 0) {
            return false;
        }

        for (int i = 3; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}

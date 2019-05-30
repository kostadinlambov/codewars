public class Kata_10_Bit_Counting {
    public static void main(String[] args) {
//        assertEquals(5, BitCounting.countBits(1234));
//        assertEquals(1, BitCounting.countBits(4));
//        assertEquals(3, BitCounting.countBits(7));
//        assertEquals(2, BitCounting.countBits(9));
//        assertEquals(2, BitCounting.countBits(10));

        System.out.println(countBits(1234));
        System.out.println(countBits(4));
        System.out.println(countBits(7));
        System.out.println(countBits(9));
        System.out.println(countBits(10));
    }

    public static int countBits(int n){
        String binaryNum = Integer.toBinaryString(n);

        int countOfBits = 0;
        for (int i = 0; i < binaryNum.length(); i++) {
            if(binaryNum.charAt(i) == '1'){
                countOfBits++;
            }
        }

        return countOfBits;
    }
}

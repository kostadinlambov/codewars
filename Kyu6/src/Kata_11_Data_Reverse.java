import java.util.Arrays;

public class Kata_11_Data_Reverse {
    public static void main(String[] args) {
//        @Test
//        public void Test1() {
//            int[] data1= {1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0,1,0,1,0,1,0};
//            int[] data2= {1,0,1,0,1,0,1,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1};
//            assertArrayEquals(data2, Kata.DataReverse(data1));
//        }
//
//        @Test
//        public void Test2() {
//            int[] data1= {0,0,1,1,0,1,1,0,0,0,1,0,1,0,0,1};
//            int[] data2= {0,0,1,0,1,0,0,1,0,0,1,1,0,1,1,0};
//            assertArrayEquals(data2, Kata.DataReverse(data1));
//
//        }
        int[] data1 = {1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0};
        int[] data2 = {0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1};
        System.out.println(Arrays.toString(DataReverse(data1)));
        System.out.println(Arrays.toString(DataReverse(data2)));
    }

    private static int[] DataReverse(int[] data) {
        int[] result = new int[data.length];

        int bitsCount = data.length / 8 - 1;
        int index = 0;
        for (int j = 0; j < result.length; j++) {
            result[j] = data[bitsCount * 8 + index];
            if (index == 7) {
                index = -1;
                bitsCount--;
            }
            index++;

        }

        return result;
    }
}

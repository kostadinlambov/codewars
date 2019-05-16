import java.util.ArrayList;
import java.util.List;

public class Kata_09_5Kyu_Is_my_friend_cheating {
    public static void main(String[] args) {

        List<long[]> longs = removeNb(26);
        System.out.println(longs);
    }

    public static List<long[]> removeNb(long n) {
        List<long[]> resultList = new ArrayList<>();

        long sum = ((n +1)*n)/2;

        for (long i = n; i >= n / 2; i--) {
            long number = (sum  - i)/(i + 1);
            long reminder = (sum  - i)%(i + 1);
               if(reminder == 0){
                   long[] resultArr = new long[2];
                   resultArr[0] = number;
                   resultArr[1] = i;
                   resultList.add(resultArr);
               }
        }

        return resultList;
    }
}

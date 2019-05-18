import java.util.ArrayDeque;

public class Kata_03_5Kyu_Double_Cola {

    public static void main(String[] args) {
        String[] names = new String[]{"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};
        int n = 52;

        String name = WhoIsNext(names, n);
        System.out.println(name);
    }

    public static String WhoIsNext(String[] names, int n) {
        ArrayDeque<String> deque = new ArrayDeque<>(n);

//        int countOfLoops = n / names.length;
//        int reminder = n % names.length;
//
//        System.out.println(names[countOfLoops - 1]);
//        System.out.println(names[reminder]);
//        System.out.println();

//        if(reminder)

        for (String name : names) {
            deque.addLast(name);
        }

        for (int i = 0; i < n; i++) {

            String firstInQueue = deque.removeFirst();

            deque.addLast(firstInQueue);
            deque.addLast(firstInQueue);
            if (i == n - 1){
                return firstInQueue;
            }
        }

        return null;
    }
}

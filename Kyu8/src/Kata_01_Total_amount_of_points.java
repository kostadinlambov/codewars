import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Kata_01_Total_amount_of_points {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] games = {"3:1", "2:2", "0:1"};

        System.out.println(games);

        final int[] points = {0};

        Arrays.stream(games).forEach(game -> {
            int firstNumber = Integer.parseInt(game.split(":" )[0]);
            int secondNumber = Integer.parseInt(game.split(":")[1]);

            if(firstNumber > secondNumber){
                points[0] =points[0] + 3;
            }else if(firstNumber == secondNumber){
                points[0] =points[0] + 1;
            }
        });

        System.out.println(points[0]);
    }
}

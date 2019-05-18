public class Kata_05_BouncingBall {

    public static void main(String[] args) {
        int result = bouncingBall(3.0, 0.66, 1.5);
        System.out.println("result1: " + result);
        int result2 = bouncingBall(30.0, 0.66, 1.5);
        System.out.println("result2: " + result2);
    }

    public static int bouncingBall(double h, double bounce, double window) {
        if (h <= 0 || (bounce <= 0 || bounce >= 1) || window >= h) {
            return -1;
        }

        return 1 + 2 * (int) Math.floor(Math.log(window / h) / Math.log(bounce));
    }
}

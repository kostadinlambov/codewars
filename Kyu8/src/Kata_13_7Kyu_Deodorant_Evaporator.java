public class Kata_13_7Kyu_Deodorant_Evaporator {
    public static void main(String[] args) {
        System.out.println(evaporator(10, 10, 10));
    }

    public static int evaporator(double content, double evap_per_day, double threshold) {
        int days = 0;
        double minValue = (content* threshold)/100;
        while(content> minValue){
            content = content - content*evap_per_day/100;
            days++;
        }
        return days;
    }
}

public class Kata_02_Growth_of_a_Population {
    public static void main(String[] args) {
//        "In a small town the population is p0 = 1000 at the beginning of a year. The population regularly increases by 2 percent per year and moreover 50 new inhabitants per year come to live in the town. How many years does the town need to see its population greater or equal to p = 1200 inhabitants?\n" +
//                "\n" +
//                "At the end of the first year there will be: \n" +
//                "1000 + 1000 * 0.02 + 50 => 1070 inhabitants\n" +
//                "\n" +
//                "At the end of the 2nd year there will be: \n" +
//                "1070 + 1070 * 0.02 + 50 => 1141 inhabitants (number of inhabitants is an integer)\n" +
//                "\n" +
//                "At the end of the 3rd year there will be:\n" +
//                "1141 + 1141 * 0.02 + 50 => 1213\n" +
//                "\n" +
//                "It will need 3 entire years.\n" +
//                "More generally given parameters:\n" +
//                "\n" +
//                "p0, percent, aug (inhabitants coming or leaving each year), p (population to surpass)\n" +
//                "\n" +
//                "the function nb_year should return n number of entire years needed to get a population greater or equal to p.\n" +
//                "\n" +
//                "aug is an integer, percent a positive or null number, p0 and p are positive integers (> 0)\n" +
//                "\n" +
//                "Examples:\n" +
//                "nb_year(1500, 5, 100, 5000) -> 15\n" +
//                "nb_year(1500000, 2.5, 10000, 2000000) -> 10\n" +
//                "Note: Don't forget to convert the percent parameter as a percentage in the body of your function:
//                if the parameter percent is 2 you have to convert it to 0.02."

        System.out.println("test");
        int yearsCount = nbYear(1000, 2, 50, 1200);

        System.out.println(yearsCount);

    }

    public static int nbYear(int p0, double percent, int aug, int p){
        double currentCitizens = p0;
        int years = 0;
        double count = 0;
        while(true){
            count = currentCitizens + currentCitizens*(percent/100) + aug;
            years++;
            if(count >= p){
                break;
            }

            currentCitizens = count;
        }

        return years;
    }
}

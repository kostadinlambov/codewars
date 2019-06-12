public class Kata_15_PositionAverage {
    public static void main(String[] args) {
//        assertFuzzy("466960, 069060, 494940, 060069, 060090, 640009, 496464, 606900, 004000, 944096", 26.6666666667);
//        assertFuzzy("444996, 699990, 666690, 096904, 600644, 640646, 606469, 409694, 666094, 606490", 29.2592592593);
//        assertFuzzy("4444444, 4444444, 4444444, 4444444, 4444444, 4444444, 4444444, 4444444", 100);
//        assertFuzzy("0, 0, 0, 0, 0, 0, 0, 0", 100);

        System.out.println(posAverage("466960, 069060, 494940, 060069, 060090, 640009, 496464, 606900, 004000, 944096"));
        System.out.println(posAverage("444996, 699990, 666690, 096904, 600644, 640646, 606469, 409694, 666094, 606490"));
        System.out.println(posAverage("4444444, 4444444, 4444444, 4444444, 4444444, 4444444, 4444444, 4444444"));
        System.out.println(posAverage("0, 0, 0, 0, 0, 0, 0, 0"));
        System.out.println(posAverage("6900690040, 4690606946, 9990494604"));

    }

    public static double posAverage(String s) {
        String[] tokens = s.split(", ");

        int countCommonPositions = 0;

        for (int i = 0; i < tokens.length - 1; i++) {
            for (int j = i+1; j < tokens.length; j++) {
                String firstString = tokens[i];
                String secondString = tokens[j];
                for (int k = 0; k < firstString.length(); k++) {
                    char firstStringChar = firstString.charAt(k);
                    char secondStringChar = secondString.charAt(k);
                    if(firstStringChar == secondStringChar){
                        countCommonPositions++;
                    }
                }
            }
        }

        int countOfStrings = tokens.length;
        int countOfSubstrings = (countOfStrings * (countOfStrings - 1 ))/ 2;
        int countOfCombinations = countOfSubstrings * tokens[0].length();

        return (countCommonPositions /(double) countOfCombinations) * 100;
    }
}

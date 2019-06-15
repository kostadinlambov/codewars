import java.util.HashMap;
import java.util.Map;

public class Kata_16_CountingDuplicates {
    public static void main(String[] args) {

//            assertEquals(0, CountingDuplicates.duplicateCount("abcde"));
//            assertEquals(1, CountingDuplicates.duplicateCount("abcdea"));
//            assertEquals(1, CountingDuplicates.duplicateCount("indivisibility"));

//        @Test
//        public void reallyLongStringContainingDuplicatesReturnsThree() {
//            String testThousandA = new String(new char[1000]).replace('\0', 'a');
//            String testHundredB = new String(new char[100]).replace('\0', 'b');
//            String testTenC = new String(new char[10]).replace('\0', 'c');
//            String test1CapitalA = new String(new char[1]).replace('\0', 'A');
//            String test1d = new String(new char[1]).replace('\0', 'd');
//            String test = test1d + test1CapitalA + testTenC +
//                    testHundredB + testThousandA;
//            assertEquals(3, CountingDuplicates.duplicateCount(test));

        System.out.println(duplicateCount("abcde"));
        System.out.println(duplicateCount("abcdea"));
        System.out.println(duplicateCount("indivisibility"));
        System.out.println(duplicateCount("abcdeabc"));
    }

    public static int duplicateCount(String text) {
        Map<Character, Integer> result = new HashMap<>();

        String textLowercase = text.toLowerCase();

        for(int i = 0; i < text.length(); i++){
            char currentChar = textLowercase.charAt(i);
            if(!result.containsKey(currentChar)){
                result.put(currentChar, 0);
            }

            result.put(currentChar, result.get(currentChar) + 1);
        }

        return (int) result.values().stream().filter(value -> value > 1).count();
    }

}

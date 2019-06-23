public class Kata_19_SpinWords {
    public static void main(String[] args) {
//        assertEquals("emocleW", new SpinWords().spinWords("Welcome"));
//        assertEquals("Hey wollef sroirraw", new SpinWords().spinWords("Hey fellow warriors"));

        System.out.println(spinWords("Welcome"));
        System.out.println(spinWords("Hey fellow warriors"));
    }

    public static String spinWords(String sentence) {
        String[] words = sentence.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String currentWord = words[i];
           if(currentWord.length() > 4){
               StringBuilder tempWord = new StringBuilder(currentWord);
               String reversedWord = tempWord.reverse().toString();
               result.append(reversedWord).append(" ");
           }else {
               result.append(currentWord).append(" ");
           }
        }

        return result.toString().trim();
    }
}

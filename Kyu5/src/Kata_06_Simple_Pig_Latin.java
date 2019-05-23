import java.util.Arrays;

public class Kata_06_Simple_Pig_Latin {
    public static void main(String[] args) {
//        assertEquals("igPay atinlay siay oolcay", PigLatin.pigIt("Pig latin is cool"));
        System.out.println(pigIt("Pig latin is cool"));
//        assertEquals("hisTay siay ymay tringsay", PigLatin.pigIt("This is my string"));
        System.out.println(pigIt("This is my string !"));
    }

    public static String pigIt(String str) {
        StringBuilder result = new StringBuilder();

        Arrays.stream(str.split("\\s+"))
                .forEach(word -> {
                    if(!"!.,?".contains(word)){
                        StringBuilder currentWord = new StringBuilder();
                        currentWord
                                .append(word)
                                .append(word.charAt(0))
                                .delete(0, 1)
                                .append("ay ");

                        result.append(currentWord);
                    }else{
                        result.append(word);
                    }

                });


        return result.toString().trim();
    }
}

import java.util.Arrays;
import java.util.stream.Collectors;

public class Kata_01_7Kyu_Jaden_Casing_Strings {
    //   Jaden Smith, the son of Will Smith, is the star of films such as The Karate Kid (2010) and After Earth (2013).
//   Jaden is also known for some of his philosophy that he delivers via Twitter. When writing on Twitter,
//   he is known for almost always capitalizing every word.
//
//   Your task is to convert strings to how they would be written by Jaden Smith. The strings are actual quotes from Jaden Smith,
//  but they are not capitalized in the same way he originally typed them.
//
//  Example:
//        Not Jaden-Cased: "How can mirrors be real if our eyes aren't real"
//        Jaden-Cased:     "How Can Mirrors Be Real If Our Eyes Aren't Real"
//
// Not Jaden-Cased: "How can mirrors be real if our eyes aren't real"
// Jaden-Cased:     "How Can Mirrors Be Real If Our Eyes Aren't Real"
//  Note that the Java version expects a return value of null for an empty string or null.
    public static void main(String[] args) {
        String phrase = "How can mirrors be real if our eyes aren't real";
        String toJadenCase1 = toJadenCase(phrase);
        System.out.println(toJadenCase1);

        String toJadenCase2 = toJadenCase(null);
        System.out.println("null");

        String toJadenCase3 = toJadenCase("");
        System.out.println("empty string");
    }

    public static String toJadenCase(String phrase) {
        return (phrase == null || "".equals(phrase)) ? null : Arrays.stream(phrase.split(" "))
                .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1))
                .collect(Collectors.joining(" "));
    }
}

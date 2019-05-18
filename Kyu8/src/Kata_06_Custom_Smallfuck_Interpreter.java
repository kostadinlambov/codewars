import java.math.BigInteger;

public class Kata_06_Custom_Smallfuck_Interpreter {
    public static void main(String[] args) {
        // Flips the leftmost cell of the tape
//        assertEquals("10101100", Smallfuck.interpreter("*", "00101100"));
        System.out.println(interpreter("*", "00101100"));
        // Flips the second and third cell of the tape
//        assertEquals("01001100", Smallfuck.interpreter(">*>*", "00101100"));
        System.out.println(interpreter(">*>*", "00101100"));
        // Flips all the bits in the tape
//        assertEquals("11010011", Smallfuck.interpreter("*>*>*>*>*>*>*>*", "00101100"));
        System.out.println(interpreter("*>*>*>*>*>*>*>*", "00101100"));
        // Flips all the bits that are initialized to 0
//        assertEquals("11111111", Smallfuck.interpreter("*>*>>*>>>*>*", "00101100"));
        System.out.println(interpreter("*>*>>*>>>*>*", "00101100"));

        // Goes somewhere to the right of the tape and then flips all bits that are initialized to 1, progressing leftwards through the tape
//        assertEquals("00000000", Smallfuck.interpreter(">>>>>*<*<<*", "00101100"));
        System.out.println(interpreter(">>>>>*<*<<*", "00101100"));
    }

    public static String interpreter(String code, String tape) {
        int index = 0;
        int position = 0;
        while (true) {
            if (position < 0 || position >= tape.length() || index >= code.length()) {
                return tape;
            }
            switch (code.charAt(index)) {
                case '*':
                    BigInteger maskToggleBit = BigInteger.ONE.shiftLeft(tape.length() - position - 1);
                    BigInteger tapeBigInt = new BigInteger(tape, 2);
                    tapeBigInt = tapeBigInt.xor(maskToggleBit);
                    String tapeBinary = tapeBigInt.toString(2);
                    String pattern = "%" + (tape.length()) + "s";
                    tape = String.format(pattern, tapeBinary).replaceAll(" ", "0");
                    break;
                case '>':
                    position++;
                    break;
                case '<':
                    position--;
                    break;
                case '[':
                    if (tape.charAt(position) == 0) {
                        index = code.indexOf(']', index)+ 1;
                    }
                    break;
                case ']':
                    if (tape.charAt(position) != 0) {
                        for (int i = index - 1; i >= 0; i--) {
                            if (code.charAt(i) == '[') {
                                index = i + 1;
                            }
                        }

//                        int fromIndex = 0;
//                        while (true) {
//                            int currentIndex = code.indexOf('[', fromIndex);
//                            if (currentIndex < index && currentIndex != -1) {
//                                index = currentIndex;
//                                fromIndex = currentIndex;
//                            } else {
//                                break;
//                            }
//                        }
                    }
                    break;
                default:
                    break;
            }

            index++;
        }
    }
}

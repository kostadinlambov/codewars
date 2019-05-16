public class Kata_05_6Kuy_Create_Phone_Number {
//    Write a function that accepts an array of 10 integers (between 0 and 9), that returns a string of those numbers in the form of a phone number.
//
//    Example:
//            Kata.createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}) // => returns "(123) 456-7890"
//    The returned format must be correct in order to complete this challenge.
//            Don't forget the space after the closing parentheses!
    public static void main(String[] args) {

        int[] input = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String phoneNumber = createPhoneNumber(input);
        System.out.println(phoneNumber);
    }

    public static String createPhoneNumber(int[] numbers) {
        StringBuilder result = new StringBuilder("(");
        for (int i = 0; i < numbers.length; i++) {
            if(i == 3){
                result.append(") ");
            }
            if(i == 6){
                result.append("-");
            }
            result.append(numbers[i]);
        }

      return result.toString();
    }
}

public class Kata_02_Find_the_unknown_digit {
    public static void main(String[] args) {
//        assertEquals( "Answer for expression '1+1=?' " , 2 , Runes.solveExpression("1+1=?") );
//        assertEquals( "Answer for expression '123*45?=5?088' " , 6 , Runes.solveExpression("123*45?=5?088") );
//        assertEquals( "Answer for expression '-5?*-1=5?' " , 0 , Runes.solveExpression("-5?*-1=5?") );
//        assertEquals( "Answer for expression '19--45=5?' " , -1 , Runes.solveExpression("19--45=5?") );
//        assertEquals( "Answer for expression '??*??=302?' " , 5 , Runes.solveExpression("??*??=302?") );
//        assertEquals( "Answer for expression '?*11=??' " , 2 , Runes.solveExpression("?*11=??") );
//        assertEquals( "Answer for expression '??*1=??' " , 2 , Runes.solveExpression("??*1=??") );
//        assertEquals( "Answer for expression '??+??=??' " , -1 , Runes.solveExpression("??+??=??") );

        System.out.println(solveExpression("1+1=?"));
        System.out.println(solveExpression("123*45?=5?088"));
        System.out.println(solveExpression("-5?*-1=5?"));
        System.out.println(solveExpression("19--45=5?"));
        System.out.println(solveExpression("??*??=302?"));
        System.out.println(solveExpression("?*11=??"));
        System.out.println(solveExpression("??*1=??"));
        System.out.println(solveExpression("??+??=??"));

    }

    public static int solveExpression(final String expression) {
        int missingDigit = -1;

        String[] numbers = expression.split("[=]");
        String leftSide = numbers[0];
        String rightSide = numbers[1];

        int operatorIndex = 0;

        if (leftSide.contains("+") && leftSide.indexOf('+', 1) > -1) {
            operatorIndex = leftSide.indexOf('+', 1);
        } else if (leftSide.contains("*") && leftSide.indexOf('*', 1) > -1) {
            operatorIndex = leftSide.indexOf('*', 1);
        } else if (leftSide.contains("-") && leftSide.indexOf('-', 1) > -1) {
            operatorIndex = leftSide.indexOf('-', 1);
        }

        char operator = leftSide.charAt(operatorIndex);
        String firstOperand = leftSide.substring(0, operatorIndex);
        String secondOperand = leftSide.substring(operatorIndex + 1);

        for (int i = 0; i <= 9; i++) {
            if (firstOperand.contains(i + "") || secondOperand.contains(i + "") || rightSide.contains(i + "")) {
                continue;
            }

            String firstOperandReplaced = firstOperand.replaceAll("\\?", i + "");
            String secondOperandReplaced = secondOperand.replaceAll("\\?", i + "");
            String rightSideReplaced = rightSide.replaceAll("\\?", i + "");

            if ((firstOperandReplaced.charAt(0) == '0' && firstOperandReplaced.length() > 1
                    || secondOperandReplaced.charAt(0) == '0' && secondOperandReplaced.length() > 1)
                    || rightSideReplaced.charAt(0) == '0' && rightSideReplaced.length() > 1) {
                continue;
            }

            int firstOperandNum = Integer.parseInt(firstOperandReplaced);
            int secondOperandNum = Integer.parseInt(secondOperandReplaced);
            int rightSideNum = Integer.parseInt(rightSideReplaced);

            switch (operator) {
                case '+':
                    if (firstOperandNum + secondOperandNum == rightSideNum) {
                        return i;
                    }
                    break;
                case '*':
                    if (firstOperandNum * secondOperandNum == rightSideNum) {
                        return i;
                    }
                    break;
                case '-':
                    if (firstOperandNum - secondOperandNum == rightSideNum) {
                        return i;
                    }
                    break;
            }
        }

        return missingDigit;
    }
}

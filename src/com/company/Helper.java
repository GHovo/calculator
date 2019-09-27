package com.company;

import static com.company.Constants.INPUT_NUMBER_ERROR;
import static com.company.NumberSystem.ARABIC;
import static com.company.NumberSystem.ROMAN;

class Helper {

    static int calculation(String operator, int input1, int input2) {
        int result = 0;

        switch(operator) {
            case "+":
                result = input1 + input2;
                break;
            case "-":
                result = input1 - input2;
                break;
            case "*":
                result = input1 * input2;
                break;
            case "/":
                result = input1 / input2;
                break;
        }
        return result;
    }

    static int toArabic(String value) {
        if (value.equals("I")) return 1;
        if (value.equals("II")) return 2;
        if (value.equals("III")) return 3;
        if (value.equals("IV")) return 4;
        if (value.equals("V")) return 5;
        if (value.equals("VI")) return 6;
        if (value.equals("VII")) return 7;
        if (value.equals("VIII")) return 8;
        if (value.equals("IX")) return 9;
        return Integer.parseInt(value);
    }

    static NumberSystem numberSystemOf(String num) {
        String[] romNumber = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] arabNumber = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        for (int i = 0; i < romNumber.length - 1; i++) {
            if (num.equals(romNumber[i])) {
                return ROMAN;
            } else if (num.equals(arabNumber[i])) {
                return ARABIC;
            }
        }
        throw new IllegalArgumentException(INPUT_NUMBER_ERROR);

    }
    static boolean operatorIsCorrect(String operator) {
        String[] operators = {"+","-","*","/"};
        for (String operator1 : operators) {
            if (operator.equals(operator1)) {
                return true;
            }
        }
        return false;
    }

}

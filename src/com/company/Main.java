package com.company;

import java.util.IllegalFormatException;
import java.util.Scanner;

import static com.company.Constants.*;
import static com.company.Helper.*;

import static com.company.NumberSystem.ARABIC;
import static com.company.NumberSystem.ROMAN;
import static com.company.RomanNumber.toRoman;



public class Main {

   public static void main(String[] args) {
       System.out.println(FORMAT_ARABIC);
       while (isContinue) {
           calculate();
       }
   }

   private static void calculate() throws IllegalFormatException {
       try {
           System.out.println(INPUT);
           Scanner scan = new Scanner(System.in);
           String calculation = scan.nextLine();
           String[] parts = calculation.split(" ");
           if(parts.length != 3){
               throw new IllegalArgumentException(ERROR_WITH_FORMAT);
           }
           String operator = parts[1];

           if (numberSystemOf(parts[0]) == ROMAN && numberSystemOf(parts[2]) == ARABIC || numberSystemOf(parts[0]) == ARABIC && numberSystemOf(parts[2]) == ROMAN) {
               throw new IllegalArgumentException(NUMBER_SYSTEM_ERROR);
           }
           if (!operatorIsCorrect(parts[1])) {
               throw new IllegalArgumentException(OPERATOR_FORMAT_ERROR);
           }
           int number1 = toArabic(parts[0]);
           int number2 = toArabic(parts[2]);
           if (numberSystemOf(parts[0]) == ROMAN && numberSystemOf(parts[2]) == ROMAN) {
               int result = calculation(operator, number1, number2);
               String roma = toRoman(result);
               System.out.print(OUTPUT);
               System.out.println(roma);
           } else {
               int result = calculation(operator, number1, number2);
               System.out.print(OUTPUT);
               System.out.println(result);
           }

       }catch (IllegalArgumentException e){
           System.out.println(e.getMessage());
           isContinue = false;
       }

   }
}
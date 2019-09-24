package com.company;

import java.util.Scanner;

import static com.company.Helper.*;
import static com.company.RomanNumber.toRoman;


public class Main {

   public static void main(String[] args) {

       Scanner scan = new Scanner(System.in) ;
       System.out.println("Enter your two numbers and the operation with spaces between e.g 8 - 9");
       System.out.println("Input: ");
       String calculation=scan.nextLine();
       String [] parts = calculation.split(" ");
       String operator = parts[1];
       if(checkingNumbers(parts[0]).equals("rom") && checkingNumbers(parts[2]).equals("arab") || checkingNumbers(parts[0]).equals("arab") && checkingNumbers(parts[2]).equals("rom")){
           throw new IllegalArgumentException("please write only arabic or rom numbers");
       }
       if(checkingOperator(parts[1]).equals("error")){
           throw new IllegalArgumentException("please write only +,-,/,* operators");
       }
       int number1 = toArabic(parts[0]);
       int number2 = toArabic(parts[2]);
       if(number1 <= 0 || number1 > 10 && number2 <= 0 || number2 > 10 ){
           throw new IllegalArgumentException("please write only from 1 to 10 numbers");
       }
       if(checkingNumbers(parts[0]).equals("rom") && checkingNumbers(parts[2]).equals("rom")){
           int result = calculation(operator, number1, number2);
           String roma = toRoman(result);
           System.out.println("Output: ");
           System.out.print(roma);
       } else {
           int result = calculation(operator, number1, number2);
           System.out.println("Output: ");
           System.out.print(result);
       }

   }
}
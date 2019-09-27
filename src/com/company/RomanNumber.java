package com.company;

import java.util.TreeMap;

class RomanNumber {
    private final static TreeMap<Integer, String> map = new TreeMap<>();

    static {
        map.put(1, "I");
        map.put(2, "II");
        map.put(3, "III");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(6, "VI");
        map.put(7, "VII");
        map.put(8, "VIII");
        map.put(9, "IX");
        map.put(10, "X");

    }
    static String toRoman(int number) {
        int l =  map.floorKey(number);
        System.out.println("i = " + l);
        if ( number == l ) {
            System.out.println("number = " + number + " = " + l + " = l");
            System.out.println("get = " + map.get(number));
            return map.get(number);
        }
        System.out.println("GVIDON =  " + map.get(l) + toRoman(number-l));
        return map.get(l) + toRoman(number-l);
    }

}

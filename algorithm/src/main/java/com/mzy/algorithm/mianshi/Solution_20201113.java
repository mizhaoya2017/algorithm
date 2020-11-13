package com.mzy.algorithm.mianshi;

import java.util.Arrays;
import java.util.List;

/**
 * @author ：mizhaoya
 * @date ：2020/10/22 17:54
 * @description：
 */
public class Solution_20201113 {

    public static int romanToInt(String s) {
        String[] letters = new String[]{"I","IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        Integer[] values = new Integer[]{1,4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        List<String> letterList = Arrays.asList(letters);
        List<Integer> valueList = Arrays.asList(values);
        int i = 0;
        int res = 0;
        while(i < s.length()) {
            if (i < s.length() - 1 && letterList.contains(s.substring(i, i + 2))) {
                int index = letterList.indexOf(s.substring(i, i + 2));
                Integer value = valueList.get(index);
                res += value;
                i = i + 2;
            } else if (letterList.contains(s.substring(i, i + 1))) {
                int index = letterList.indexOf(s.substring(i, i + 1));
                Integer value = valueList.get(index);
                res += value;
                i = i + 1;
            }
        }
        return  res;
    }

    public static int romanToInt2(String s) {
        int res = 0;
        int preNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i ++) {
            int num = getValue(s.charAt(i));
            if (preNum >= num) {
                res += preNum;
            } else {
                res -= preNum;
            }
            preNum = num;
        }
        res += preNum;
        return res;
    }

    private static int getValue(char c) {
        int res = 0;
        switch (c) {
            case 'I':
                res = 1;
                break;
            case 'V':
                res = 5;
                break;
            case 'X':
                res = 10;
                break;
            case 'L':
                res = 50;
                break;
            case 'C':
                res = 100;
                break;
            case 'D':
                res = 500;
                break;
            case 'M':
                res = 1000;
                break;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt2("III"));
        System.out.println(romanToInt2("IV"));
        System.out.println(romanToInt2("IX"));
        System.out.println(romanToInt2("LVIII"));
        System.out.println(romanToInt2("MCMXCIV"));
    }
}

package com.mzy.algorithm.mianshi;

import java.util.HashMap;

/**
 * @author ：mizhaoya
 * @date ：2020/10/22 17:54
 * @description：
 */
public class Solution_20201029 {

    public static int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        while (i < j) {
            int area = (j - i) * Math.min(height[i], height[j]);
            if (area > max) {
                max = area;
            }
            if (height[i] > height[j]) {
                j --;
            } else {
                i ++;
            }
        }
        return max;
    }

    public static String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuffer res = new StringBuffer();
        for (int i = 0;i < values.length && num > 0; i ++) {
            while(num >= values[i]) {
                res.append(symbols[i]);
                num = num - values[i];
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
//        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(intToRoman(3));
        System.out.println(intToRoman(4));
        System.out.println(intToRoman(9));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(1994));
    }
}

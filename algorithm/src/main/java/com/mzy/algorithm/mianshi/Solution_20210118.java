package com.mzy.algorithm.mianshi;

/**
 * @author ：mizhaoya
 * @date ：2021/1/18 14:26
 * @description：
 */
public class Solution_20210118 {

    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String s = countAndSay(n - 1);
        int start = 0;
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) != s.charAt(start)) {
                result.append(i - start).append(s.charAt(start));
                start = i;
            }
        }
        result.append(s.length() - start).append(s.charAt(start));
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
        System.out.println(countAndSay(6));
    }
}
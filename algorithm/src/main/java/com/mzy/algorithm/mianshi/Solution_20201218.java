package com.mzy.algorithm.mianshi;

/**
 * @author ：mizhaoya
 * @date ：2020/12/14 17:51
 * @description：
 */
public class Solution_20201218 {

    public static int strStr(String haystack, String needle) {
        int s = 0;
        int k = 0;
        int e = 0;
        int f = 0;
        while (k < needle.length() && s < haystack.length()) {
            if (haystack.charAt(s) == needle.charAt(k)) {
                if (f == 0) {
                    e = s;
                    f = 1;
                }
                k ++;
                s ++;
            } else {
                s ++;
            }
        }
        if(k == needle.length()) {
            return e;
        } else if (s == haystack.length()) {
            return -1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("aaaaa", "bba"));
        System.out.println(strStr("aaa", "aaaa"));
        System.out.println(strStr("mississippi", "issip"));
    }
}
package com.mzy.algorithm.mianshi;

/**
 * @author ：mizhaoya
 * @date ：2020/12/14 17:51
 * @description：
 */
public class Solution_20201218 {

    public static int strStr(String haystack, String needle) {
        for (int i = 0; i <= haystack.length() - needle.length(); i ++) {
            int j;
            for (j = 0; j < needle.length(); j ++) {
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }

            }
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("aaaaa", "bba"));
        System.out.println(strStr("aaa", "aaaa"));
        System.out.println(strStr("mississippi", "issip"));
        System.out.println(strStr("", ""));
    }
}
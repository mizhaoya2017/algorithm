package com.mzy.algorithm.mianshi;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：mizhaoya
 * @date ：2020/10/15 19:50
 * @description：
 */
public class Solution_20201015 {

    public static String longestPalindrome(String s) {
        int len = s.length();
        int maxLen = 1;
        int begin = 0;
        for (int i = 0; i < len-1; i ++) {
            for (int j = i + 1; j < len; j ++) {
                if (j - i + 1 > maxLen && isPalindrome(s, i, j)) {
                    maxLen = j -i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public static boolean isPalindrome(String s, int i, int j) {
        while (j > i) {
            if (s.charAt(j) == s.charAt(i)) {
                i ++;
                j --;
            } else {
                return false;
            }
        }
        return true;
    }

    public String longestPalindrome2(String s) {
        int maxLen = 1;
        int len = s.length();
        int begin = 0;
        for (int i = 0; i < len -1; i ++) {
            int oddLen = getMaxLen(s, i, i);
            int evenLen = getMaxLen(s, i, i + 1);
            int curMaxLen = Math.max(oddLen, evenLen);
            if (curMaxLen > maxLen) {
                maxLen = curMaxLen;
                begin = i - (maxLen - 1) / 2;
            }
        }
        return s.substring(begin, begin+maxLen);
    }
    
    public int getMaxLen(String s, int i, int j) {
        int len = s.length();
        while (i >= 0 && j < len) {
            if (s.charAt(i) == s.charAt(j)) {
                i --;
                j ++;
            } else {
                break;
            }
        }
        return j-i-1;
    }

    public static void main(String[] args) {
//        String s1 = longestPalindrome2("babad");
//        String s2 = longestPalindrome2("cbbd");
//        System.out.println(s1);
//        System.out.println(s2);
    }
}

package com.mzy.algorithm.mianshi;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author ：mizhaoya
 * @date ：2020/10/21 20:26
 * @description：
 */
public class Solution_20201021 {

    public static boolean isPalindrome(int x) {
        int y = x;
        if (x < 0) return false;
        StringBuffer r = new StringBuffer();
        while(x/10 != 0) {
            r.append(x%10);
            x = x/10;
        }
        r.append(x%10);
        return r.toString().equals(y + "");
    }

    public static boolean isPalindrome2(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int reverseNumber = 0;
        while(x > reverseNumber) {
            reverseNumber = reverseNumber * 10 + x % 10;
            x = x / 10;
        }
        return x == reverseNumber || x == reverseNumber / 10;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome2(121));
        System.out.println(isPalindrome2(-121));
        System.out.println(isPalindrome2(10));
        System.out.println(isPalindrome2(-1));
    }
}

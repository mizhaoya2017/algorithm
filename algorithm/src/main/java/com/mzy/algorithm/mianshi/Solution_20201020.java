package com.mzy.algorithm.mianshi;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * @author ：mizhaoya
 * @date ：2020/10/20 17:19
 * @description：
 */
public class Solution_20201020 {
    public static int myAtoi(String s) {
        char[] x = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        ArrayList y = new ArrayList(10);
        for (int i = 0; i < x.length; i ++) {
            y.add(x[i]);
        }
        int res = 0;
        String trim = s.trim();
        int len = trim.length();
        boolean flag = true;
        if (!"".equals(trim) && trim.charAt(0) == '-') {
            flag = false;
            len -= 1;
            trim = trim.substring(1);
        } else if (!"".equals(trim) && trim.charAt(0) == '+') {
            len -= 1;
            trim = trim.substring(1);
        } else if ("".equals(trim) || !y.contains(trim.charAt(0))) {
            return 0;
        }
        for (int i = 0; i < len; i ++) {
            if (y.contains(trim.charAt(i))) {
                int r = trim.charAt(i) - '0';
                if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && r > 7)) {
                    res = Integer.MAX_VALUE;
                    return flag ? Integer.MAX_VALUE: Integer.MIN_VALUE;
                }
                res = res * 10 + Integer.parseInt(String.valueOf(trim.charAt(i)));
            } else {
                break;
            }
        }
        if (!flag) {
            res = -res;
        }
        return res;
    }

    public static int myAtoi2(String s) {
        int res = 0;
        int flag = 1;
        int i = 0;
        if (s.length()==0) return 0;
        while(s.length() > i && ' '== s.charAt(i)) {i ++;}
        if (s.length() > i && s.charAt(i) == '-') {
            flag = 0;
        }
        if (s.length() > i && (s.charAt(i) == '+'|| s.charAt(i) == '-')) {
            i ++;
        }
        while(i < s.length() && Character.isDigit(s.charAt(i))) {
            int r = s.charAt(i) - '0';
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE/10 && r > 7)) {
                return flag > 0 ?Integer.MAX_VALUE: Integer.MIN_VALUE;
            }
            res = res * 10 + r;
            i ++;
        }
        return flag>0?res:-res;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi2("42"));
        System.out.println(myAtoi2("     -42"));
        System.out.println(myAtoi2("4193 with words"));
        System.out.println(myAtoi2("words and 987"));
        System.out.println(myAtoi2("-91283472332"));
        System.out.println(myAtoi2("+1"));
        System.out.println(myAtoi2("2147483648"));
        System.out.println(myAtoi2("2147483646"));
        System.out.println(myAtoi2(""));
        System.out.println(myAtoi2(" "));


        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("     -42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi("+1"));
        System.out.println(myAtoi("2147483648"));
        System.out.println(myAtoi("2147483646"));
    }
}

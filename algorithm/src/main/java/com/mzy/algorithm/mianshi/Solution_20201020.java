package com.mzy.algorithm.mianshi;

import org.springframework.util.StringUtils;

import java.util.regex.Pattern;

/**
 * @author ：mizhaoya
 * @date ：2020/10/20 17:19
 * @description：
 */
public class Solution_20201020 {
    public static int myAtoi(String s) {
        String trim = s.trim();
        int len = trim.length();
        boolean flag = true;
        if (!StringUtils.isEmpty(trim) && trim.charAt(0) == '-') {
            flag = false;
            len -= 1;
            trim = trim.substring(1);
        }
        for (int i = 0; i < len; i ++) {
            if (Pattern.matches("",trim.charAt(i));
        }
        return 1;
    }

    public static void main(String[] args) {
    }
}

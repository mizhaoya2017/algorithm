package com.mzy.algorithm.mianshi;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：mizhaoya
 * @date ：2020/10/16 20:44
 * @description：
 */
public class Solution_20201016 {

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuffer> middle = new ArrayList<>();
        int len = s.length();
        numRows = Math.min(len, numRows);
        for (int i = 0; i < numRows; i ++) {
            middle.add(new StringBuffer());
        }
        boolean runDown = true;
        int curRow = 0;
        for (int i = 0; i < len; i ++) {
            middle.get(curRow).append(s.charAt(i));
            if (curRow == 0 || curRow == numRows - 1) {
                runDown = !runDown;
            }
            curRow += runDown?-1:1;
        }
        StringBuffer res = new StringBuffer();
        for (StringBuffer sb: middle) {
            res.append(sb);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("LEETCODEISHIRING", 3));
        System.out.println(convert("LEETCODEISHIRING", 4));
        System.out.println(convert("AB", 1));
    }
}

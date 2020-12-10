package com.mzy.algorithm.mianshi;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：mizhaoya
 * @date ：2020/12/9 17:04
 * @description：
 */
public class Solution_20201209 {

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateAll(new char[2 * n], 0, res);
        return res;
    }

    public static void  generateAll(char[] current, int pos, List<String> res) {
        if (current.length == pos) {
            if (isValid(current)) {
                res.add(new String(current));
            }
        } else {
            current[pos] = '(';
            generateAll(current, pos + 1, res);
            current[pos]  = ')';
            generateAll(current, pos + 1, res);
        }
    }
    public static boolean isValid(char[] current) {
        int add = 0;
        for (int i =0; i < current.length; i ++) {
            if (current[i] == '(') {
                add ++;
            } else if (current[i] == ')') {
                add --;
            }
            if (add < 0) {
                return false;
            }
        }
        return add == 0;
    }


    public static List<String> generateParenthesis2(int n) {
        List<String> res = new ArrayList<>();
        generateAll2(n, n, new StringBuffer(), n, res);
        return res;
    }

    public static void generateAll2(int start, int end, StringBuffer cur, int n, List<String> res) {
        if (cur.length() == n * 2) {
            res.add(cur.toString());
            return;
        }
        if (start > 0) {
            generateAll2(start - 1, end, cur.append("("), n, res);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (start < end) {
            generateAll2(start, end - 1, cur.append(")"), n, res);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis2(4));
    }
}
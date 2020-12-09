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

    public static void main(String[] args) {
        System.out.println(generateParenthesis(1));
    }
}
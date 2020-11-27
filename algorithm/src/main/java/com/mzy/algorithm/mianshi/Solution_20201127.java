package com.mzy.algorithm.mianshi;

import java.util.*;

/**
 * @author ：mizhaoya
 * @date ：2020/10/25 11:02
 * @description：
 */
public class Solution_20201127 {

    public static List<String> letterCombinations(String digits) {
        if (digits.length() ==0) return new ArrayList<>();
        Map<String, String> map = new HashMap();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        List<String> res = new ArrayList<>();
        loop(map, digits, 0, new StringBuffer(), res);
        return res;
    }

    private static void loop(Map<String, String> map, String digits, int i, StringBuffer s, List<String> res) {
        if (i > digits.length() - 1) {
            res.add(s.toString());
        } else {
            String digit = digits.substring(i, i + 1);
            String letter = map.get(digit);
            for (int x = 0; x < letter.length(); x ++) {
                StringBuffer append = s.append(letter.substring(x, x + 1));
                loop(map, digits, i + 1, append, res);
                s.deleteCharAt(i);
            }

        }

    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations(""));
    }
}

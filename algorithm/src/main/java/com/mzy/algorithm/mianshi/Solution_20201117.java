package com.mzy.algorithm.mianshi;

/**
 * @author ：mizhaoya
 * @date ：2020/10/22 17:54
 * @description：
 */
public class Solution_20201117 {

    public static String longestCommonPrefix(String[] strs) {
        int i = 0;
        boolean flag = true;
        String res = "";
        if (strs.length == 1) {
            return strs[0];
        } else if (strs.length == 0) {
            return "";
        }
        while(flag) {
            for (int x = 0; x < strs.length - 1; x ++) {
                if ((strs[x].length() <= i) || (strs[x+1].length() <= i) || (strs[x].length() > i && strs[x + 1].length() > i && !strs[x].substring(i, i + 1).equals(strs[x + 1].substring(i, i + 1)))) {
                    flag = false;
                    break;
                }
            }
            i ++;
        }
        i --;
        if (strs.length > 0) {
            res = strs[0].substring(0, i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
        System.out.println(longestCommonPrefix(new String[]{"a"}));
        System.out.println(longestCommonPrefix(new String[]{}));
        System.out.println(longestCommonPrefix(new String[]{"", ""}));
    }
}

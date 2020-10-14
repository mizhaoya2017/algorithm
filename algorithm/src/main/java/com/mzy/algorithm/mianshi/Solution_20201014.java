package com.mzy.algorithm.mianshi;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ：mizhaoya
 * @date ：2020/10/13 16:52
 * @description：
 */
public class Solution_20201014 {

    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        int n = 1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i ++) {
            if (i == 0) {
                map.put(s.charAt(0), 0);
            }
            int j = n;
            while (j < s.length() && !map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), j);
                j ++;
            }
            int m = j - i;
            if (res < m) {
                res = m;
            }
            n = j;
            map.remove(s.charAt(i));
        }
        return res;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int start=0,end=0;end < s.length(); end ++) {
            if (map.containsKey(s.charAt(end))) {
               start = Math.max(map.get(s.charAt(end)), start);
            }
            map.put(s.charAt(end), end + 1);
            ans = Math.max(ans, end - start + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int res1 = lengthOfLongestSubstring2("abcabcbb");
        int res2 = lengthOfLongestSubstring2("bbbbb");
        int res3 = lengthOfLongestSubstring2("pwwkew");
        System.out.println(res1 + "_"+ res2 + "_" + res3);
    }
}

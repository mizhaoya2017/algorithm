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

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i ++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j ++) {
                if (j > i + 1 && nums[j] == nums[j -1]) {
                    continue;
                }
                int s = j + 1;
                int e = nums.length - 1;
                while(s < e) {
                    if (nums[i] + nums[j] + nums[s] + nums[e] == target) {
                        List<Integer> sum = new ArrayList<>();
                        sum.add(nums[i]);
                        sum.add(nums[j]);
                        sum.add(nums[s]);
                        sum.add(nums[e]);
                        res.add(sum);
                        s ++;
                        e --;
                        while (s > 0 && s < nums.length && nums[s] == nums[s - 1]) {
                            s ++;
                        }
                        while (e >= 0 && e < nums.length - 1 && nums[e] == nums[e + 1]) {
                            e --;
                        }
                    } else if (nums[i] + nums[j] + nums[s] + nums[e] < target) {
                        s ++;
                        while (s > 0 && s < nums.length && nums[s] == nums[s - 1]) {
                            s ++;
                        }
                    } else {
                        e --;
                        while (e >= 0 && e < nums.length -1 && nums[e] == nums[e + 1]) {
                            e --;
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));//[[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]
        System.out.println(fourSum(new int[]{0,0,0,0}, 0));//[0,0,0,0]
        System.out.println(fourSum(new int[]{-2,-1,-1,1,1,2,2}, 0));//[[-2, -1, 1, 2], [-1, -1, 1, 1]]


//        System.out.println(letterCombinations("23"));
//        System.out.println(letterCombinations(""));
    }
}

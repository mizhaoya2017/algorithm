package com.mzy.algorithm.mianshi;

/**
 * @author ：mizhaoya
 * @date ：2020/12/14 17:51
 * @description：
 */
public class Solution_20201214 {

    public static int removeDuplicates(int[] nums) {
        int s = 0;
        int e = 1;
        if (nums.length == 0 || nums.length == 1) {
            return 1;
        }
        while(e < nums.length && s < e) {
            if (nums[s] == nums[e]) {
                e ++;
            } else if (nums[s] != nums[e]) {
                nums[s + 1] = nums[e];
                s ++;
                e ++;
            }

        }
        return s + 1;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,1,2}));
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }
}
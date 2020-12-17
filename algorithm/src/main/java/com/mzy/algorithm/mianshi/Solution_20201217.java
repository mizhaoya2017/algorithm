package com.mzy.algorithm.mianshi;

/**
 * @author ：mizhaoya
 * @date ：2020/12/14 17:51
 * @description：
 */
public class Solution_20201217 {
    public static int removeElement(int[] nums, int val) {
        int s = -1;
        int e = 0;
        while(s<e && e<nums.length) {
            if (nums[e]!=val) {
                nums[s+1] = nums[e];
                s ++;
                e ++;
            } else {
                e ++;
            }
        }
        return s + 1;
    }

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{3,2,2,3}, 2));
        System.out.println(removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
    }
}
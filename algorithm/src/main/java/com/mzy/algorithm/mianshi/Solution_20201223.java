package com.mzy.algorithm.mianshi;

/**
 * @author ：mizhaoya
 * @date ：2020/12/14 17:51
 * @description：
 */
public class Solution_20201223 {

    public static int[] nextPermutation(int[] nums) {
        if (isDesc(nums)) {
            for (int i = 0; i < nums.length/2; i ++) {
                int a = nums[i];
                nums[i] = nums[nums.length - 1 - i];
                nums[nums.length - 1 - i] = a;
            }
        } else {
            for (int i = nums.length-1; i > 0; i --) {
                if (nums[i] > nums[i - 1]) {
                    int a = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = a;
                    break;
                }
            }
        }
        return nums;
    }

    public static boolean isDesc(int[] nums) {
        for (int i = 0; i < nums.length - 1; i ++) {
            if (nums[i] < nums[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(nextPermutation(new int[]{1,2,3}));
        System.out.println(nextPermutation(new int[]{3,2,1}));
        System.out.println(nextPermutation(new int[]{1,1,5}));
        System.out.println(nextPermutation(new int[]{1}));

    }
}
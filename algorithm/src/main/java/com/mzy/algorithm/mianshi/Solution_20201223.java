package com.mzy.algorithm.mianshi;

/**
 * @author ：mizhaoya
 * @date ：2020/12/14 17:51
 * @description：
 */
public class Solution_20201223 {

    public static int[] nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i --;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j > 0 && nums[i] >= nums[j]) {
                j --;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
        return nums;
    }

    public static void swap(int[] nums, int i, int j) {
        int a = nums[i];
        nums[i] = nums[j];
        nums[j] = a;
    }

    public static void reverse(int[] nums, int i) {
        int left = i; int right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left ++;
            right --;
        }
    }

    public static void main(String[] args) {
        System.out.println(nextPermutation(new int[]{1,2,3}));
        System.out.println(nextPermutation(new int[]{3,2,1}));
        System.out.println(nextPermutation(new int[]{1,1,5}));
        System.out.println(nextPermutation(new int[]{1}));

    }
}
package com.mzy.algorithm.mianshi;

/**
 * @author ：mizhaoya
 * @date ：2021/1/8 14:26
 * @description：
 */
public class Solution_20210113 {

    public static int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int s = -1;
        int e = -1;
        while (left<=right) {
            if (nums[left] == target) {
                s = left;
            } else {
                left ++;
            }
            if (nums[right] == target) {
                e = right;
            } else {
                right --;
            }
            if (s == left && e == right) {
                break;
            }
        }

        return new int[]{s, e};
    }

    public static void main(String[] args) {
        System.out.println(searchRange(new int[]{5,7,7,8,8,10}, 8));
        System.out.println(searchRange(new int[]{5,7,7,8,8,10}, 6));
        System.out.println(searchRange(new int[]{}, 0));
        System.out.println(searchRange(new int[]{1}, 1));
    }
}
package com.mzy.algorithm.mianshi;

/**
 * @author ：mizhaoya
 * @date ：2021/1/8 14:26
 * @description：
 */
public class Solution_20210108 {

    public static int search(int[] nums, int target) {
        return searchInner(nums, target, 0, nums.length-1);
    }

    public static int searchInner(int[] nums, int target, int left, int right) {
        if (right < left) {
            return -1;
        }
        int mid = (right + left) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[left] == target) {
            return left;
        }
        if (nums[right] == target) {
            return right;
        }
        if (nums[left] < nums[mid]) {
            if (target > nums[left] && target < nums[mid]) {
                return searchInner(nums, target, left+1, mid-1);
            } else {
                return searchInner(nums, target, mid+1, right -1);
            }
        } else {
            if (target > nums[mid] && target < nums[right]) {
                return searchInner(nums, target, mid+1, right-1);
            } else {
                return searchInner(nums, target, left +1, mid -1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 3));
        System.out.println(search(new int[]{1}, 0));
    }
}
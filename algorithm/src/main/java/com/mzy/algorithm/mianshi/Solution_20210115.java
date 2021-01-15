package com.mzy.algorithm.mianshi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：mizhaoya
 * @date ：2021/1/15 14:26
 * @description：
 */
public class Solution_20210115 {

    public static int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int[] numsCopy = new int[nums.length+2];
        for (int i = 0; i < nums.length;i ++) {
            numsCopy[i + 1] = nums[i];
        }
        int left = 0;
        int right = nums.length + 1;
        while (left < right) {
            if (numsCopy[left + 1] < target) {
                left++;
            } else if (numsCopy[left + 1] == target) {
                return left;
            }
            if (numsCopy[right - 1] > target) {
                right --;
            } else if (numsCopy[right - 1] == target) {
                return right  - 2;
            }
            if (left == right - 1) {
                return left;
            }
        }
        return 0;
    }

    public static boolean isValidSudoku(char[][] board) {
        int n = board.length;
        Map<Integer, Integer>[] rows = new HashMap[n];
        Map<Integer, Integer>[] collowns = new HashMap[n];
        Map<Integer, Integer>[] boxes = new HashMap[n];
        for (int i = 0; i < board.length; i ++) {
            rows[i] = new HashMap<Integer, Integer>();
            collowns[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board.length; j++) {
                int box = (i /3)*3 + j / 3;
                if (board[i][j] != '.') {
                    int b = (int)board[i][j];
                    rows[j].put(b, rows[j].getOrDefault(b, 0) + 1);
                    collowns[i].put(b, collowns[i].getOrDefault(b, 0)+1);
                    boxes[box].put(b, boxes[box].getOrDefault(b, 0)+1);
                    if (rows[j].get(b) > 1 || collowns[i].get(b) > 1 || boxes[box].get(b) > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(searchInsert(new int[]{1,3,5,6}, 5));
//        System.out.println(searchInsert(new int[]{1,3,5,6}, 2));
//        System.out.println(searchInsert(new int[]{1,3,5,6}, 7));
//        System.out.println(searchInsert(new int[]{1,3,5,6}, 0));
        System.out.println(isValidSudoku(new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}}));
        System.out.println(isValidSudoku(new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}}));
    }
}
package com.mzy.algorithm.mianshi;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：mizhaoya
 * @date ：2020/10/22 17:54
 * @description：
 */
public class Solution_20201022 {

    public static int maxArea(int[] height) {
        int x = 0;
        for (int i = 0; i < height.length; i ++) {
            for (int j = i; j < height.length; j ++) {
                int min = Math.min(height[i], height[j]);
                int every = min * (j - i);
                if (x < every) {
                    x = every;
                }
            }
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}

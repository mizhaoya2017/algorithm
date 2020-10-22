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
        Map<Integer, Integer> map = new HashMap<>();
        int x = 0;
        for (int i = 0; i < height.length; i ++) {
            if (isMax(height[i], map, x)) {
            }
        }
        return 1;
    }

    public static boolean isMax(int c, Map<Integer, Integer> map, int x) {

        return false;
    }

    public static void main(String[] args) {

    }
}

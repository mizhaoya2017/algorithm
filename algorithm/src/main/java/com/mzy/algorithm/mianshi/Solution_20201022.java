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
            if (isMax(height[i], i, map, x)) {
                x = getMax(height[i], i, map, x) 
            }
        }
        return 1;
    }

    public static boolean isMax(int c, int i, Map<Integer, Integer> map, int x) {
        for (Integer key: map.keySet()) {
            Integer value = map.get(key);
            if (Math.max(c, key) * (value - i) > x) {
                return true;
            }
        }
        return false;
    }

    public static int getMax(int c, int i, Map<Integer, Integer> map, int x) {
        for (Integer key: map.keySet()) {
            Integer value = map.get(key);
            if (Math.max(c, key) * (value - i) > x) {
                return value;
            }
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}

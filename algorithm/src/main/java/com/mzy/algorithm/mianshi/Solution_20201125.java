package com.mzy.algorithm.mianshi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：mizhaoya
 * @date ：2020/10/25 11:02
 * @description：
 */
public class Solution_20201125 {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 100000000;
        for (int i = 0; i< nums.length-2; i ++) {
            int start = i + 1;
            int end = nums.length - 1;
            if (i > 0 && nums[i] ==nums[i - 1]) {
                continue;
            }
            while(start < end) {
                int abs = nums[i] + nums[start] + nums[end];
                if (abs == target) {
                    return target;
                }
                if (Math.abs(abs - target) < Math.abs(res - target)) {
                    res = abs;
                }
                if (abs > target) {
                    end --;
                    while(start < end && nums[end +1] == nums[end]) {
                        end --;
                    }
                }
                if (abs < target) {
                    start ++;
                    while(start < end && nums[start -1] == nums[start]) {
                        start ++;
                    }
                }

            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1,2,1,-4}, 1));
        System.out.println(threeSumClosest(new int[]{-111,-111,3,6,7,16,17,18,19}, 13));

    }
}

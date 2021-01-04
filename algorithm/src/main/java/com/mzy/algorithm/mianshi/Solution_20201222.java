package com.mzy.algorithm.mianshi;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：mizhaoya
 * @date ：2020/12/14 17:51
 * @description：
 */
public class Solution_20201222 {

    public static int divide(int dividend, int divisor) {
        int INT_MAX = 0x7FFFFFFF;
        int INT_MIN = 1 << 31;
        int _dividend = dividend < 0? dividend: -dividend;
        int _divisor = divisor < 0 ? divisor: -divisor;
        int symbol = dividend ^ divisor >> 31;
        List<Integer> times = getTimes(_dividend, _divisor, new ArrayList<>());
        int output = 0;
        for (int t: times) {
            if (t == 31) {
                if (symbol == 0) {
                    return INT_MAX;
                } else {
                    return INT_MIN;
                }
            }
            output += 1 << t;
        }
        return symbol==0?output:-output;

    }

    public static List<Integer> getTimes(int dividend, int divisor, List<Integer> times) {
        if (dividend > divisor) {
            return times;
        }
        int maxTime = 32;
        int minTime = 0;
        while(maxTime != minTime + 1) {
            int mid = (minTime + maxTime) >> 1;
            if (divisor < -1 << (31 - mid)) {
                maxTime = mid;
                continue;
            }
            if (divisor << mid < dividend) {
                maxTime = mid;
            } else {
                minTime = mid;
            }
        }
        times.add(minTime);
        return getTimes(dividend - (divisor << minTime), divisor, times);
    }

    public static void main(String[] args) {
        System.out.print(divide(10,3));
        System.out.print(divide(7,-3));
    }
}
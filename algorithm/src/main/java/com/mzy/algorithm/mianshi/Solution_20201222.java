package com.mzy.algorithm.mianshi;

/**
 * @author ：mizhaoya
 * @date ：2020/12/14 17:51
 * @description：
 */
public class Solution_20201222 {

    public static int divide(int dividend, int divisor) {
        int i = 0;
        int res = 0;

        if(divisor > 0) {
            while(res <= dividend) {
                res += divisor;
                i ++;
            }
            return i - 1;
        } else {
            while(-res <= dividend) {
                res += divisor;
                i ++;
            }
            return -i + 1;
        }

    }

    public static void main(String[] args) {
        System.out.println(divide(10,3));
        System.out.println(divide(7,-3));
    }
}
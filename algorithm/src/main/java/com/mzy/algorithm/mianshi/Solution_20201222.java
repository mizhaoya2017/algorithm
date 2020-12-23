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

        if(divisor > 0 && dividend > 0) {
            while(res <= dividend) {
                res += divisor;
                i ++;
            }
            return i - 1;
        } else if (divisor > 0 && dividend <= 0) {
            while (res <= -dividend){
                res += divisor;
                i ++;
            }
            return -(i - 1);

        } else if (divisor < 0 && dividend > 0) {
            while (res <= dividend) {
                res += -divisor;
                i ++;
            }
            return -(i - 1);

        } else if (divisor < 0 && dividend <= 0){
            while(res <= -dividend) {
                res += -divisor;
                i ++;
            }
            return i-1;
        }
        return -1;
    }

    public static int divide2(int dividend, int divisor) {
        int INT_MIN = -2147483648;
        int INT_MAX = 2147483647;
        int result = 0;
        int flag = 1;
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            return dividend<= INT_MIN?dividend-1:-dividend;
        }
        if ((dividend<0 && divisor > 0) || (dividend>0 && divisor < 0)) {
            flag = 0;
        }
        dividend = dividend<0?-dividend:dividend;
        if (dividend<=INT_MIN) {
            dividend = INT_MIN - 1;
        }
        divisor = divisor<0?-divisor:divisor;
        if (divisor<=INT_MIN) {
            divisor = INT_MIN - 1;
        }
        while(dividend >= divisor) {
            int cur = divisor;
            int res = 1;
            while(cur + cur < dividend) {
                cur += cur;
                res += res;
            }
            dividend -= cur;
            result += res;
        }
        result = flag==1?result:-result;
        if (result< INT_MIN) {
            return INT_MIN;
        }else if (result> INT_MAX) {
            return INT_MAX;
        } else {
            return result;
        }
    }

    public static void main(String[] args) {
        System.out.println(divide2(10,3));
        System.out.println(divide2(7,-3));
        System.out.println(divide2(-2147483648,-1));


    }
}
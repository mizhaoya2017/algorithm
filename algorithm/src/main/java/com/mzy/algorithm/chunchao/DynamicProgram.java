package com.mzy.algorithm.chunchao;

/**
 * @author ：mizhaoya
 * @date ：2020/9/17 18:20
 * @description：
 */
public class DynamicProgram {
    public int getSteps(int n) {
        int a = 1;
        int b = 2;
        int tmp = 0;
        for (int i = 3; i <= n; i ++) {
            tmp = a + b;
            a = b;
            b = tmp;
        }
        return tmp;
    }
}

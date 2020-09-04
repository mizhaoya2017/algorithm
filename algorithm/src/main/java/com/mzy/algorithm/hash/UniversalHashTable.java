package com.mzy.algorithm.hash;

/**
 * @author ：mizhaoya
 * @date ：2020/8/28 17:17
 * @description：
 */
public class UniversalHashTable {
    public static final int DIGS = 31;
    public static final int mersennep = (1 << DIGS) - 1;
    public int universalHash(int x, int a, int b, int p, int M) {
        int hashVal = x * a + b;
        hashVal = (hashVal >> DIGS) + hashVal & mersennep;
        if (hashVal > mersennep) {
            hashVal -= mersennep;
        }
        return hashVal % M;
    }
}

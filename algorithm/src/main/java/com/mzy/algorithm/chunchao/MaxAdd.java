package com.mzy.algorithm.chunchao;

/**
 * @author ：mizhaoya
 * @date ：2020/9/17 16:53
 * @description：
 */
public class MaxAdd {
    public static String getMaxAdd(Integer[] x) {
        for (int a = 0; a < x.length; a ++) {
            for (int b = a+1; b < x.length; b ++) {
                if (compare(x[a], x[b]) < 0) {
                    int tmp = x[a];
                    x[a] = x[b];
                    x[b] = tmp;
                }
            }
        }
        StringBuffer res = new StringBuffer();
        for (int a = 0; a < x.length; a ++) {
            res.append(x[a]);
        }
        return res.toString();
    }

    private static int compare(Integer i, Integer j) {
        String format = String.format("%d%d", i, j);
        String format2 = String.format("%d%d", j, i);
        return format.compareTo(format2);
    }

    public static void main(String[] args) {
        System.out.println(getMaxAdd(new Integer[]{3,30,34,5,9}));
    }
}

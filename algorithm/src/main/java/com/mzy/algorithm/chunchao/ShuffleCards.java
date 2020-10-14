package com.mzy.algorithm.chunchao;

/**
 * @author ：mizhaoya
 * @date ：2020/9/17 17:41
 * @description：
 */
public class ShuffleCards {
    public static void shuffleCards(Integer[] x) {
        for (int i = x.length -1; i >= 0; i --) {
            int a = (int)(Math.random() * i);
            int tmp = x[i];
            x[i] = x[a];
            x[a] = tmp;
        }
    }
    public static void main(String[] args) {
        Integer[] mm = {1, 2, 3, 4, 5, 6, 7};
        shuffleCards(mm);
        for (int i = 0; i < mm.length; i ++) {
            System.out.println(mm[i]);
        }
    }
}

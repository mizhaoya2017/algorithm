package com.mzy.algorithm.sort;

public class ShellSort {
    public static void main(String[] args) {
        int[] ints = shellSort(new int[]{8, 9, 1, 7, 2, 3, 5, 4, 6, 0});
        for (int i = 0; i < ints.length; i ++) {
            System.out.println(ints[i]);
        }

    }
    public static int[] shellSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        int temp;
        int gap = array.length / 2;
        while(gap > 0) {
            for (int i = gap; i < array.length; i ++) {
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex = preIndex - gap;
                }
                array[preIndex + gap] = temp;
            }
            gap = gap/2;
        }
        return array;
    }
}

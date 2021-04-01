package com.mzy.algorithm.sort;

import java.util.Arrays;

public class Sort {
    public static int[] bubleSort(int[] array) {
        for (int i = 0; i < array.length; i ++) {
            for (int j = i + 1; j < array.length; j ++) {
                if (array[i] > array[j]) {
                    int tmp = array[j];
                    array[j] = array[i];
                    array[i] = tmp;
                }
            }
        }
        return array;
    }

    public static int[] selectSort(int[] array) {
        for (int i = 0; i < array.length; i ++) {
            int min = i;
            for (int j = i + 1; j < array.length; j ++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            int current = array[i];
            array[i] = array[min];
            array[min] = current;
        }
        return array;
    }

    public static int[] insertSort(int[] array) {
        for (int i = 0; i < array.length; i ++) {
            int current = array[i];
            int preIndex = i - 1;
            while (preIndex >= 0 && array[preIndex] > current) {
                array[preIndex + 1] = array[preIndex];
                preIndex --;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }

    public static int[] shellSort(int[] array) {
        int gap = array.length / 2;
        while (gap > 0) {
            for (int i = gap; i < array.length; i ++) {
                int current = array[gap];
                int preIndex = gap - 1;
                while (preIndex >= 0 && array[preIndex] > current) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = current;
            }
        }
        return array;
    }

    public static int[] mergeSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index ++) {
            if (i >= left.length) {
                result[index] = right[j ++];
            } else if (j >= right.length) {
                result[index] = left[i ++];
            } else if (left[i] > right[j]) {
                result[index] = left[i ++];
            } else {
                result[index] = right[j ++];
            }
        }
        return result;
    }
}

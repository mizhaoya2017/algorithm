package com.mzy.algorithm.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：mizhaoya
 * @date ：2020/9/9 16:48
 * @description：
 */
public class TestSort {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<Integer>();
    }

    public Integer getKMax(int k, List<Integer> arr) {
        for (int i = 0; i < arr.size(); i ++) {
            for (int j = i+1; j < arr.size(); j ++) {
                if (arr.get(i) < arr.get(j)) {
                    int tmp = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, tmp);
                }
            }
        }
        return arr.get(k-1);
    }

    public Integer getKMax2(int k, List<Integer> arr) {
        for (int i = 0; i < k; i ++) {
            for (int j = i + 1; j < k; j ++) {
                if (arr.get(i) < arr.get(j)) {
                    int tmp = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, tmp);
                }
            }
        }
        for (int x = k; x < arr.size(); x ++) {
            if (arr.get(x) > arr.get(k-1)) {
                arr.set(k-1, arr.get(x));
                for (int i = 0; i < k; i ++) {
                    for (int j = i + 1; j < k; j ++) {
                        if (arr.get(i) < arr.get(j)) {
                            int tmp = arr.get(i);
                            arr.set(i, arr.get(j));
                            arr.set(j, tmp);
                        }
                    }
                }
            }
        }
        return arr.get(k-1);
    }

    public Integer getKMax3(int k, List<Integer> arr) {
        //1、堆排序
        for (int i = arr.size()/2; i > 0; i ++) {
            percolateDown(i, arr);
        }
        //2、删除4个
        for (int x = 0; x < 4; x ++) {
            delete(arr);
        }
        //3、获取顶部元素
        return arr.get(1);
    }

    public void delete(List<Integer> arr) {
        int currentSize = arr.size();
        arr.set(1,arr.get(currentSize--));
        percolateDown(1, arr);
    }

    public void percolateDown(int x, List<Integer> arr) {
        int tmp = arr.get(x);
        int child;
        for (;x < arr.size(); x = child) {
            child = x * 2;
            if (x * 2 != arr.size() && arr.get(child) < arr.get(child + 1)) {
                child ++;
            }
            if (arr.get(child) > arr.get(x)) {
                arr.set(x, arr.get(child));
            } else {
                break;
            }
        }
    }

    public Integer getKMax4(int k, List<Integer> arr) {
        //1、构造前k个堆
        List<Integer> arr1 = new ArrayList<>();
        for (int i = 1; i <= k; i ++) {
            arr1.set(i, arr.get(i));
        }
        for (int i = arr1.size()/2; i > 0; i ++) {
            percolateDown(i, arr1);
        }
        //2、如果比k大插入剩余
        Integer tmp = arr1.get(arr1.size());
        for (int i = k+1; i < arr.size(); i ++) {
            if (tmp < arr.get(i)) {
                arr1.remove(k);
                insert(arr1, arr.get(i));
            }
        }
        //4、获取第k个
        return arr1.get(k);
    }

    public void insert(List<Integer> arr, int x) {
        int currentSize = arr.size();
        int i = ++currentSize;
        for (; arr.get(i) > arr.get(i/2); i =i/2) {
            arr.set(i, arr.get(i/2));
        }
        arr.set(i, x);
    }
}

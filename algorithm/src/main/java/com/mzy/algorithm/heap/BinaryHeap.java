package com.mzy.algorithm.heap;

import org.hibernate.mapping.Any;

/**
 * @author ：mizhaoya
 * @date ：2020/9/4 16:28
 * @description：
 */
public class BinaryHeap<AnyType extends Comparable<? super AnyType>> {
    public BinaryHeap() {

    }
    public BinaryHeap(int capacity) {

    }
    public BinaryHeap(AnyType[] items) {

    }
    public void insert(AnyType x) {
        if (currentSize == array.length -1) {
            enlargeArray(array.length * 2 +1);
        }
        int i = ++currentSize;
        for (array[0] = x;array[i/2].compareTo(array[i])>0 ; i = i/2) {
            array[i] = array[i/2];
        }
        array[i] = x;
    }
    public AnyType findMin() {
        return array[1];
    }
    public AnyType deleteMin() {
        if (isEmpty()) {
            return null;
        }
        AnyType anyType = findMin();
        array[1] = array[currentSize--];
        percolateDown(1);
        return anyType;
    }
    public boolean isEmpty() {
        return false;
    }
    public void makeEmpty() {

    }
    private static final int DEFAULT_CAPACITY = 10;
    private int currentSize;
    private AnyType[] array;
    private void percolateDown(int hole) {
        AnyType tmp = array[hole];
        int child;
        for (; hole*2<=currentSize;hole = child) {
            child = hole * 2;
            if (child != currentSize && array[child].compareTo(array[child+1])>0) {
                child ++;
            }
            if (array[child].compareTo(tmp)<0) {
                array[hole] = array[child];
            } else {
                break;
            }
        }
        array[hole] = tmp;
    }
    private void buildHeap() {

    }
    private void enlargeArray(int newSize) {

    }
}

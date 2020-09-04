package com.mzy.algorithm.hash;

import java.util.LinkedList;

/**
 * @author ：mizhaoya
 * @date ：2020/7/21 15:46
 * @description：
 */
public class SeparateChainingHashTable<AnyType> {
    public SeparateChainingHashTable() {

    }
    public SeparateChainingHashTable(int size) {
        this.theLists = new LinkedList[nextPrime(size)];
        for (int i = 0; i < theLists.length; i ++) {
            theLists[i] = new LinkedList<AnyType>();
        }
    }
    private static final int DEFALUT_SIZE = 101;
    private LinkedList<AnyType>[] theLists;
    private int currentSize;

    public int nextPrime(int size) {
        return size+1;
    }

    public void makeEmpty() {
        for(int i = 0; i < theLists.length; i ++) {
            theLists[i].clear();
        }
        currentSize = 0;
    }

    public void insert(AnyType a) {
        LinkedList<AnyType> theList = theLists[myHash(a)];
        if (!theList.contains(a)) {
            theList.add(a);
        }
        if (++currentSize > theLists.length) {
            rehash();
        }
    }

    public void rehash() {
        LinkedList<AnyType>[] oldLists = theLists;

        theLists = new LinkedList[nextPrime(2 * oldLists.length)];
        for (int i = 0; i < theLists.length; i ++) {
            theLists[i] = new LinkedList<>();
        }
        currentSize = 0;
        for(int j = 0; j < oldLists.length; j ++) {
            for (AnyType a: oldLists[j]) {
                insert(a);
            }
        }

    }

    public int myHash(AnyType a) {
        int hash = a.hashCode();
        hash %= theLists.length;
        if (hash < 0) {
            hash += theLists.length;
        }
        return hash;
    }

    public void remove(AnyType a) {
        LinkedList<AnyType> theList = theLists[myHash(a)];
        if (theList.contains(a)) {
            theList.remove(a);
            currentSize --;
        }
    }
}

class Employee {
    @Override
    public boolean equals(Object rhs) {
        return rhs instanceof Employee && name.equals(((Employee) rhs).name);
    }
    @Override
    public int hashCode() {
        return name.hashCode();
    }
    private String name;
    private double salary;
    private int seniority;
 }

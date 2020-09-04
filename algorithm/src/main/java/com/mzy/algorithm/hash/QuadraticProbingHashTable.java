package com.mzy.algorithm.hash;

/**
 * @author ：mizhaoya
 * @date ：2020/7/21 17:12
 * @description：
 */
public class QuadraticProbingHashTable<AnyType> {
    public QuadraticProbingHashTable(int size) {
        theLists = new HashEntry[nextPrime(size)];
        for(int i = 0; i < theLists.length; i ++) {
            theLists[i] = null;
        }
        currentSize = 0;
    }
    private static final int DEFAULT_SIZE = 101;
    private HashEntry<AnyType>[] theLists;
    private int currentSize;

    public int nextPrime(int size) {
        return 1;
    }

    public QuadraticProbingHashTable() {
        this(DEFAULT_SIZE);
    }

    public void insert(AnyType a) {
        int pos = findPos(a);
        if (isActive(pos)) {
            return;
        }
        theLists[pos] = new HashEntry<>(a, true);
        if (++currentSize > theLists.length/2) {
            rehash();
        }
    }

    public void remove(AnyType a) {
        int pos = findPos(a);
        if (isActive(pos)) {
            theLists[pos].isActive = false;
        }
    }

    public  void rehash() {
        HashEntry<AnyType>[] oldLists = theLists;
        allocateArray(nextPrime(2 * DEFAULT_SIZE));

        for (int i = 0; i < oldLists.length; i ++) {
            insert(oldLists[i].element);
        }
    }

    public void allocateArray(int size) {
        theLists = new HashEntry[nextPrime(size)];
        for(int i = 0; i < theLists.length; i ++) {
            theLists[i] = null;
        }
        currentSize = 0;
    }

    public boolean isActive(int pos) {
        return theLists[pos] !=null && theLists[pos].isActive;
    }

    public int findPos(AnyType a) {
        int pos = myHash(a);
        int offset = 1;
        while(theLists[pos]!=null && !theLists[pos].element.equals(a)) {
            pos += offset;
            offset += 2;
            if (pos > theLists.length) {
                pos -= theLists.length;
            }
        }
        return pos;
    }

    public int myHash(AnyType a) {
       return 1;
    }






    public class HashEntry<AnyType>{
        private AnyType element;
        private boolean isActive;
        public HashEntry(AnyType e, boolean i) {
            element = e;
            isActive = i;
        }
        public HashEntry(AnyType e) {
            this(e, true);
        }
    }
}

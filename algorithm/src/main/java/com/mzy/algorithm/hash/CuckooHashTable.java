package com.mzy.algorithm.hash;

/**
 * @author ：mizhaoya
 * @date ：2020/8/5 16:30
 * @description：
 */
public class CuckooHashTable<AnyType> {

    private static final double MAX_LOAD = 0.4;
    private static final int ALLOW_REHASHES = 1;
    private static final int DEAULT_TABLE_SIZE = 101;

    private HashFamily<? super AnyType> hashFunctions;
    private int numHashFunctions;
    private AnyType[] array;
    private int currentSize;

    public CuckooHashTable(HashFamily<? super AnyType> hf) {
        this(hf, DEAULT_TABLE_SIZE);
    }

    public CuckooHashTable(HashFamily<? super AnyType> hf, int size) {
        allocateArray(nextPrime(size));
        doClear();
        hashFunctions = hf;
        numHashFunctions = hf.getNumberOfFunctions();
    }

    private void allocateArray(int arraySize) {
        array = (AnyType[]) new Object[arraySize];
    }

    private int nextPrime(int size) {
        return -1;
    }

    private int myHash(AnyType x, int which){
        int hash = hashFunctions.hash(x, which);
        hash %= array.length;
        if (hash < 0) {
            hash += array.length;
        }
        return hash;
    }

    private int findPos(AnyType x) {
        for (int i = 0; i < numHashFunctions; i ++) {
            int hash = hashFunctions.hash(x, i);
            if (array[hash] != null && array[hash].equals(x)) {
                return hash;
            }
        }
        return -1;
    }

    public boolean remove(AnyType x) {
        int pos = findPos(x);
        if (pos != -1) {
            array[pos] = null;
            currentSize --;
        }
        return pos != -1;
    }

    public boolean contains(AnyType x) {
        return findPos(x) != -1;
    }

    public boolean insert(AnyType x) {
        if (contains(x)) {
            return false;
        }
        if (currentSize > array.length * MAX_LOAD) {
            expand();
        }
        return insertHelper1(x);
    }

    private java.util.Random r = new java.util.Random();
    private int rehashes = 0;
    private boolean insertHelper1(AnyType x) {
        int COUNT_LIMIT = 100;

        while(true) {
            int lastPos = -1;
            int pos = 0;
            for (int count = 0; count < COUNT_LIMIT; count ++) {
                for (int i = 0; i < numHashFunctions; i ++) {
                    pos = hashFunctions.hash(x, i);
                    if (array[pos] == null) {
                        array[pos] = x;
                        currentSize ++;
                        return true;
                    }
                }
                int i = 0;
                do {
                    pos = hashFunctions.hash(x, r.nextInt(numHashFunctions));
                } while(pos == lastPos && i <= 5);
                AnyType tmp = array[lastPos = pos];
                array[pos] = x;
                x = tmp;
            }
            if (++ rehashes > ALLOW_REHASHES) {
                expand();
                rehashes = 0;
            }else {
                rehash();
            }
        }
    }

    private void expand() {
        rehash((int)(array.length/MAX_LOAD));
    }

    private void rehash() {
        hashFunctions.generateNewFunctions();
        rehash(array.length);
    }

    private void rehash(int newLength) {
        AnyType[] oldArray = array;
        allocateArray(nextPrime(newLength));
        currentSize =0;
        for (AnyType str: oldArray) {
            if (str != null) {
                insert(str);
            }
        }
    }

    private void doClear() {
        currentSize = 0;
        for (int i = 0; i < array.length; i ++) {
            array[i] = null;
        }
    }
}

class StringHashFamilly implements HashFamily<String>{
    private int[] MULTIPLIERS;
    private java.util.Random r = new java.util.Random();

    @Override
    public int hash(String x, int which) {
        int multiplier = MULTIPLIERS[which];
        int val = 0;
        for (int i = 0; i < x.length(); i ++) {
            val = multiplier * val + x.charAt(i);
        }
        return val;
    }

    @Override
    public int getNumberOfFunctions() {
        return MULTIPLIERS.length;
    }

    @Override
    public void generateNewFunctions() {
        for(int i = 0; i < MULTIPLIERS.length; i ++) {
            MULTIPLIERS[i] = r.nextInt();
        }
    }
}

interface HashFamily<AnyType> {
    int hash(AnyType x, int which);
    int getNumberOfFunctions();
    void generateNewFunctions();
}

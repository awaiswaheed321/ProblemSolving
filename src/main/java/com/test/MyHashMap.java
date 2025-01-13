package com.test;

class MyHashMap {

    Integer[] array;

    public MyHashMap() {
        array = new Integer[1000];
    }

    public void put(int key, int value) {
        if(key >= array.length) {
            Integer[] newArray = new Integer[key+1];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        array[hash(key)] = value;
    }

    public int get(int key) {
        if(key < 0 || key >= array.length) {
            return -1;
        }
        Integer value = array[hash(key)];
        return value == null ? -1 : value;
    }

    public void remove(int key) {
        array[hash(key)] = null;
    }

    private int hash(int key) {
        return key % array.length;
    }
}

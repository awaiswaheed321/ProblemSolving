package com.test;

import java.util.Random;

class Solution {
    int[] original;
    Random random;

    public Solution(int[] nums) {
        original = nums;
        random = new Random();
    }

    public int[] reset() {
        return original;
    }

    public int[] shuffle() {
        int[] res = original.clone();
        for (int i = 0; i < res.length; i++) {
            int index1 = random.nextInt(res.length);
            int index2 = random.nextInt(res.length);
            int temp = res[index1];
            res[index1] = res[index2];
            res[index2] = temp;
        }
        return res;
    }
}
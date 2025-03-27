package com.test;

import java.util.List;

public class HackerRank {
    public static void main(String[] args) {

    }

    static String catAndMouse(int x, int y, int z) {
        int xz = Math.abs(x-z);
        int yz = Math.abs(y-z);

        if(xz < yz) {
            return "Cat A";
        } else if(yz < xz) {
            return "Cat B";
        } else {
            return "Mouse C";
        }
    }

    public static String angryProfessor(int k, List<Integer> a) {
        int count = 0;

        for (int arvT : a) {
            if (arvT <= 0) count++;
        }

        return count < k ? "YES" : "NO";
    }

    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        int max = -1;
        for(int i= keyboards.length -1; i>=0; i--) {
            for(int j= drives.length -1; j>=0; j--) {
                int sum = keyboards[i] + drives[j];
                if(sum > max && sum <=b) {
                    max = sum;
                }
            }
        }
        return max;
    }



}

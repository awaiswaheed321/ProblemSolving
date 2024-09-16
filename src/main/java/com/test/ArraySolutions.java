package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraySolutions {
    public static void main(String[] args) {
        testMissingNumber();
    }

    public static List<Integer> duplicates(int[] arr) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {}
        return list;
    }

    public static void testMissingNumber() {
        System.out.println(missingNumber(4, new int[]{1, 2, 3}));
//        System.out.println(missingNumber(new int[]{1, 1, 1, 2, 1, 1, 1}, 7));
    }

    private static int missingNumber(int n, int arr[]) {
        Arrays.sort(arr);
        int missing = -1;
        for(int i = 0; i <= n; i++) {
            if(i == n - 1) {
                missing = i;
                break;
            }
            if(arr[i] != i+1) {
                missing = i+1;
                break;
            }
        }
        return missing;
    }

    public static void testSearch() {
        System.out.println(search(new int[]{1, 2, 3}, 3));
        System.out.println(search(new int[]{1, 1, 1, 2, 1, 1, 1}, 7));
    }

    private static int search(int arr[], int x) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public static void testPeakElement() {
        System.out.println(peakElement(new int[]{1, 2, 3}, 3));
        System.out.println(peakElement(new int[]{1, 1, 1, 2, 1, 1, 1}, 7));
    }

    private static int peakElement(int[] arr, int n) {
        int index = -1;
        if (n == 1) {
            return 0;
        }
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (arr[i] >= arr[i + 1]) {
                    index = i;
                    break;
                }
            } else if (i == n - 1) {
                if (arr[i] >= arr[i - 1]) {
                    index = i;
                    break;
                }
            } else {
                if (arr[i] >= arr[i - 1] && arr[i] >= arr[i + 1]) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }
}

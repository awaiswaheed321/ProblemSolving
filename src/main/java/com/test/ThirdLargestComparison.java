package com.test;

import java.util.*;

public class ThirdLargestComparison {

    // Algorithm 1: Three Loops Approach
    public static int thirdMaxThreeLoops(int[] arr) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }

        int preMax = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num < max && num > preMax) {
                preMax = num;
            }
        }

        int prePreMax = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num < preMax && num > prePreMax) {
                prePreMax = num;
            }
        }
        return prePreMax;
    }

    // Algorithm 2: One Loop with Three Variables
    public static int thirdMaxOneLoop(int[] arr) {
        int max = Integer.MIN_VALUE, preMax = Integer.MIN_VALUE, prePreMax = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > max) {
                prePreMax = preMax;
                preMax = max;
                max = num;
            } else if (num > preMax && num < max) {
                prePreMax = preMax;
                preMax = num;
            } else if (num > prePreMax && num < preMax) {
                prePreMax = num;
            }
        }
        return prePreMax;
    }

    // Algorithm 3: Ordered Map Approach
    public static int thirdMaxOrderedMap(int[] arr) {
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        for (int num : arr) {
            set.add(num);
        }

        Iterator<Integer> iterator = set.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            int value = iterator.next();
            count++;
            if (count == 3) {
                return value;
            }
        }
        return set.first();
    }

    public static void main(String[] args) {
        int[] inputSizes = {100, 1000, 5000, 10000, 20000, 50000};
        Random random = new Random();

        System.out.printf("%-15s%-15s%-15s%-15s\n", "Input Size", "Three Loops", "One Loop", "Ordered Map");

        for (int size : inputSizes) {
            int[] arr = random.ints(size, 0, 100000).toArray();

            // Measure time for Algorithm 1
            long start = System.nanoTime();
            thirdMaxThreeLoops(arr);
            long timeThreeLoops = System.nanoTime() - start;

            // Measure time for Algorithm 2
            start = System.nanoTime();
            thirdMaxOneLoop(arr);
            long timeOneLoop = System.nanoTime() - start;

            // Measure time for Algorithm 3
            start = System.nanoTime();
            thirdMaxOrderedMap(arr);
            long timeOrderedMap = System.nanoTime() - start;

            // Print results
            System.out.printf("%-15d%-15.5f%-15.5f%-15.5f\n", size,
                    timeThreeLoops / 1e6, timeOneLoop / 1e6, timeOrderedMap / 1e6);
        }
    }
}

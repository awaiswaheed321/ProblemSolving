package com.test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class FindSumPairs {
    int[] l2;
    Map<Integer, Integer> map2;
    Map<Integer, Integer> map1;

    public FindSumPairs(int[] nums1, int[] nums2) {
        map1 = new TreeMap<>();
        for(int n: nums1) {
            map1.put(n, map1.getOrDefault(n, 0) + 1);
        }
        l2 = nums2;
        map2 = new HashMap<>();
        for(int n: l2) {
            map2.put(n, map2.getOrDefault(n, 0) + 1);
        }
    }

    public void add(int index, int val) {
        int oldValue = l2[index];
        map2.put(oldValue, map2.get(oldValue) - 1);
        if(map2.get(oldValue) == 0) {
            map2.remove(oldValue);
        }
        int newValue = oldValue + val;
        l2[index] = newValue;
        map2.put(newValue, map2.getOrDefault(newValue, 0) + 1);
    }

    public int count(int tot) {
        int count = 0;
        for(Map.Entry<Integer, Integer> entry: map1.entrySet()) {
            if(entry.getKey() > tot) break;
            if(map2.containsKey(tot - entry.getKey())) {
                count += entry.getValue() * map2.get(tot - entry.getKey());
            }
        }
        return count;
    }
}

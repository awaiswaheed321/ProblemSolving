package com.test;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class LeetCodeQuestions {
    public static void main(String[] args) {
//        System.out.println(isValid("222.111.111.111"));
//        System.out.println(isValid("5555..555"));
//        System.out.println(longestCommonSubstr("ABCDGH", "ACDGHR"));
//        System.out.println(nonRepeatingChar("aabb"));
//        System.out.println(smallestWindow("zoom", "zooe"));
//        System.out.println(getSecondLargest(new int[] {12, 35, 1, 10, 34, 1}));
//        System.out.println(getSecondLargest(new int[] {10, 5,10}));
//        System.out.println(getSecondLargest(new int[] {10,10}));

        System.out.println(equilibriumPoint(new long[]{1, 0}));
        System.out.println(equilibriumPoint(new long[]{1, 3, 5, 2, 2}));
        System.out.println(equilibriumPoint(new long[]{1, 2,3}));
        System.out.println();
    }


    static Integer maximumSwap(int num) {
        char[] s = Integer.toString(num).toCharArray();
        int maxIndex = 0;
        for (int i = 1; i < s.length; i++) {
            if (s[i] > s[maxIndex]) {
                maxIndex = i;
            }
        }
        char temp = s[maxIndex];
        s[maxIndex] = s[0];
        s[0] = temp;
        return Integer.valueOf(new String(s));
    }

    static boolean ispar(String x) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < x.length(); i++) {
            char c = x.charAt(i);
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else if (stack.peek() == '{' && c == '}') {
                    stack.pop();
                } else if (stack.peek() == '(' && c == ')') {
                    stack.pop();
                } else if (stack.peek() == '[' && c == ']') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    static ArrayList<Integer> leaders(int n, int[] arr) {
        ArrayList<Integer> response = new ArrayList<>();
        if (arr.length == 0) {
            return response;
        }
        response.add(arr[n - 1]);
        if (arr.length == 1) {
            return response;
        }
        int maxOnRight = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= maxOnRight) {
                response.add(0, arr[i]);
                maxOnRight = arr[i];
            }
        }
        return response;
    }

    public static long multiplyTwoLists(Node first, Node second) {
        String f1 = "";
        String s1 = "";
        while (first != null) {
            s1 += first.data;
            first = first.next;
        }
        while (second != null) {
            f1 += second.data;
            second = second.next;
        }
        return (Long.parseLong(s1) * Long.parseLong(f1)) % 1000000007;
    }

    public static boolean isValid(String s) {
        String[] arr = s.split("\\.");
        if (arr.length != 4) {
            return false;
        }
        for (String string : arr) {
            if (string.startsWith("0") && string.length() > 1) {
                return false;
            }
            try {
                int num = Integer.parseInt(string);
                if (num < 0 || num > 255) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    public static int longestCommonSubstr(String str1, String str2) {
        String shortS, longS;
        if (str1.length() > str2.length()) {
            shortS = str2;
            longS = str1;
        } else {
            shortS = str1;
            longS = str2;
        }
        int size = shortS.length();
        while (size > 0) {
            for (int i = 0, j = size; j <= shortS.length(); j++, i++) {
                String sub = shortS.substring(i, j);
                if (longS.contains(sub)) {
                    return size;
                }
            }
            size--;
        }
        return 0;
    }

    static char nonRepeatingChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            String modified = s.substring(0, i) + s.substring(i + 1);
            if (!modified.contains(String.valueOf(c))) {
                return c;
            }
        }
        return '$';
    }

    public static String smallestWindow(String s1, String s2) {
        if (s2.length() > s1.length()) {
            return "-1";
        }
        int size = s2.length();
        while (size <= s1.length()) {
            for (int i = 0, j = size; j <= s1.length(); j++, i++) {
                String sub = s1.substring(i, j);
                boolean check = true;
                for (char c : s2.toCharArray()) {
                    if (!sub.contains(String.valueOf(c))) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    return sub;
                }
            }
            size++;
        }
        return "-1";
    }

    public List<Integer> findDuplicates(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        map.forEach((k, v) -> {
            if (v > 1) {
                res.add(k);
            }
        });
        return res;
    }

    public void sort012(int[] arr) {
        Arrays.sort(arr);
    }

    public static int getSecondLargest(int[] arr) {
        int largest, secondLargest;
        if (arr[0] > arr[1]) {
            largest = arr[0];
            secondLargest = arr[1];
        } else {
            largest = arr[1];
            secondLargest = arr[0];
        }
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] < largest && arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
        }

        if (secondLargest == largest) {
            return -1;
        }
        return secondLargest;
    }

    public static int equilibriumPoint(long arr[]) {
        if (arr.length == 1) {
            return 1;
        }
        long sum = Arrays.stream(arr).sum();
        long leftSum = 0;
        long rightSum = sum;

        for (int i = 0; i < arr.length; i++) {
            if (i != 0) {
                leftSum += arr[i - 1];
            }
            rightSum -= arr[i];
            if (leftSum == rightSum) {
                return i + 1;
            }
        }
        return -1;
    }

}

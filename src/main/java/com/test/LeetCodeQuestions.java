package com.test;

import java.util.*;

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

//        System.out.println(equilibriumPoint(new long[]{1, 0}));
//        System.out.println(equilibriumPoint(new long[]{1, 3, 5, 2, 2}));
//        System.out.println(equilibriumPoint(new long[]{1, 2, 3}));
//        System.out.println();

//        System.out.println(Arrays.toString(getMaxXor(new int[]{0,1,2,2,5,7}, 3)));
//        System.out.println(rotateString("abcde", "bcdea"));
//        System.out.println(checkIfExist(new int[]{-2, 0, 10, -19, 4, 6, -8}));
//        int[] arr = new int[] {-1,-100,3,99};
//        rotate2(arr, 2);
//        System.out.println(Arrays.toString(arr));
//        System.out.println(calculate("-(2 + 3)"));
//        System.out.println(addSpaces("icodeinpython", new int[]{1, 5, 7, 9}));
//        System.out.println(addSpaces("LeetcodeHelpsMeLearn", new int[]{8,13,15}));
        System.out.println(maxWidthRamp(new int[]{9,8,1,0,1,9,4,0,4,1}));
    }

    public static int maxWidthRamp(int[] nums) {
        int len = nums.length;
        int maxRamp = 0;

        Stack<Integer> stack = new Stack<>();
        for(int i =0; i<len; i++) {
            if(stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }

        for(int j=len-1; j>=0; j--) {
            while(!stack.isEmpty() && nums[stack.peek()] <= nums[j]) {
                int  i = stack.pop();
                maxRamp = Math.max(maxRamp, j-i);
            }
        }

        return maxRamp;
    }

    public static String addSpaces(String s, int[] spaces) {
        StringBuilder result = new StringBuilder();
        int index = 0;
        for (int i : spaces) {
            result.append(s, index, i);
            result.append(" ");
            index = i;
        }
        result.append(s.substring(index));
        return result.toString();
    }

    public static int calculate(String s) {
        s = s.replaceAll("\\s+", "");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ' || c == '(' || c == ')') {
                continue;
            }
            if (Character.isDigit(c)) {
                stack.push(String.valueOf(c));
            } else if (c == '+') {
                String prev = stack.pop();
                Character n = ' ';
                while (!Character.isDigit(n)) {
                    n = s.charAt(++i);
                }
                String next = String.valueOf(n);
                stack.push(String.valueOf(Integer.parseInt(prev) + Integer.parseInt(next)));
            } else if (c == '-') {
                Character n = ' ';
                while (!Character.isDigit(n)) {
                    n = s.charAt(++i);
                }
                String next = String.valueOf(n);
                if (stack.isEmpty()) {
                    stack.push(String.valueOf(-Integer.parseInt(next)));
                } else {
                    String prev = stack.pop();
                    stack.push(String.valueOf(Integer.parseInt(prev) - Integer.parseInt(next)));
                }
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int hold = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                int temp = nums[j];
                nums[j] = hold;
                hold = temp;
            }
        }
    }

    public static void rotate2(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        boolean result = true;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : ransomNote.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0) {
                result = false;
                break;
            }
            map.put(c, map.get(c) - 1);
        }
        return result;
    }

    public static boolean checkIfExist(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (j != i && arr[i] == 2 * arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(0);
            s = s.substring(1) + c;
            if (s.equals(goal)) return true;
        }
        return false;
    }

    public static boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (i == words.length - 1) {
                if (word.charAt(word.length() - 1) != words[0].charAt(0)) return false;
            } else {
                if (word.charAt(word.length() - 1) != words[i + 1].charAt(0)) {
                    return false;
                }
            }
        }
        return true;
    }


    public static String makeFancyString(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i < s.length() - 2) {
                if (!(c == s.charAt(i + 1) && c == s.charAt(i + 2))) {
                    res += c;
                }
            } else {
                res += c;
            }
        }
        return res;
    }

    static int[] getMaxXor(int[] input, int maxBit) {
        double maxK = Math.pow(2, maxBit);
        int[] res = new int[input.length];
        for (int i = input.length - 1; i >= 0; i--) {
            int xor = input[0];
            for (int j = 1; j <= i; j++) {
                xor ^= input[j];
            }
            int max = Integer.MIN_VALUE;
            int maxIndex = 0;
            for (int k = 0; k < maxK; k++) {
                int maxXor = xor ^ k;
                if (maxXor > max) {
                    max = maxXor;
                    maxIndex = k;
                }
            }
            res[input.length - i - 1] = maxIndex;
        }
        return res;
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

package com.test;

import java.math.BigInteger;
import java.security.KeyStore;
import java.util.*;
import java.util.stream.Collectors;

public class HackerRank {
    public static void main(String[] args) {
//        List<List<String>> listOfLists = new ArrayList<>();
//
//        listOfLists.add(Arrays.asList("apple", "banana", "cherry"));
//        listOfLists.add(Arrays.asList("dog", "elephant"));
//        listOfLists.add(Arrays.asList("fish", "goat", "Iguana", "alqw", "iltw"));
//
//        System.out.println(test1(listOfLists));
//        System.out.println(test2(listOfLists));
//        System.out.println(isSubsequence("axc", "ahgdc"));
//        System.out.println(isAnagram2("aba", "aa"));
//        System.out.println(isAnagram2("aba", "aab"));

//        System.out.println(wordPattern("abba", "dog cat cat dog"));
//        System.out.println(wordPattern("abba", "dog cat cat fish"));
//        System.out.println(wordPattern("abba", "dog dog dog fish"));

        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        String res = "";
        int min = Integer.MAX_VALUE;
        for(String s: strs) {
            min = Math.min(min, s.length());
        }
        for(int i = 0; i < min; i++) {
            char c = strs[0].charAt(i);
            boolean check = true;
            for(int j=1 ; j<strs.length; j++) {
                if(strs[j].charAt(i) != c) {
                    check = false;
                    break;
                }
            }
            if(check) {
                res += c;
            } else {
                break;
            }
        }
        return res;
    }

    public static boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        String[] arr = s.strip().split("\\s+");
        if(pattern.length() != arr.length) return false;
        for(int i=0; i< arr.length; i++) {
            char c = pattern.charAt(i);
            if(!map.containsKey(c)) {
                if(map.containsValue(arr[i])) return false;
                map.put(c, arr[i]);
            } else {
                if(!Objects.equals(map.get(c), arr[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isAnagram2(String s, String t) {
        int[] chars = new int[26];
        for(char c: s.toCharArray()) {
            chars[c - 'a']++;
        }
        for(char c: t.toCharArray()) {
            chars[c-'a']--;
        }
        for(int n: chars) {
            if(n != 0) return false;
        }
        return true;
    }

    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(char c: t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) - 1);
            if(map.get(c) == 0) {
                map.remove(c);
            }
        }

        return map.isEmpty();
    }

    public static boolean isSubsequence(String s, String t) {
        String s1 = t;
        for(char c: s.toCharArray()) {
            int index = t.indexOf(c);
            if(index == -1) return false;
            s1 = s1.substring(index + 1);
        }
        return true;
    }

    public static List<String> test1(List<List<String>> l1) {
        return l1.stream().flatMap(Collection::stream).sorted(String::compareToIgnoreCase).collect(Collectors.toList());
    }

    public static List<String> test2(List<List<String>> l1) {
        return l1.stream().flatMap((List::stream)).filter(x -> x.startsWith("a")).collect(Collectors.toList());
    }


    public static boolean canConstruct2(String ransomNote, String magazine) {
        int[] abc = new int[26];
        for(char c : magazine.toCharArray()) {
            abc[c - 'a']++;
        }
        for(char c : ransomNote.toCharArray()) {
            abc[c - 'a']--;
            if (abc[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> rMap = new HashMap<>();
        HashMap<Character, Integer> mMap = new HashMap<>();
        for(char c : magazine.toCharArray()) {
            mMap.put(c,mMap.getOrDefault(c, 0) + 1);
        }
        for(char c : ransomNote.toCharArray()) {
            rMap.put(c,rMap.getOrDefault(c,0) + 1);
        }
        for(Map.Entry<Character, Integer> entry : rMap.entrySet()) {
            if(!mMap.containsKey(entry.getKey())
            || mMap.get(entry.getKey()) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String s) {
        String str = s.trim().replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0, right = str.length() - 1;
        while(left < right) {
            if(str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }
        return true;
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

    public static int designerPdfViewer(List<Integer> h, String word) {
        int maxHeight = 0;
        for(char c: word.toCharArray()) {
            int value = h.get((int) c - 97);
            maxHeight = Math.max(maxHeight, value);
        }
        return maxHeight * word.length();
    }

    public static int saveThePrisoner(int n, int m, int s) {
        return ((s - 1 + m - 1) % n)+1;

    }

    public static int findDigits(int n) {
        int count = 0;
        int num = n;
        while(num > 0) {
            int d = num % 10;
            num /= 10;
            if(d == 0) continue;
            if(n%d == 0) count++;
        }
        return count;
    }

    public static List<Integer> circularArrayRotation(List<Integer> a, int k, List<Integer> queries) {
        int k1 = k % a.size();
        for(int i = 0, j = a.size() - k1 - 1; j > i ; i++, j--) {
            int swap = a.get(i);
            a.set(i, a.get(j));
            a.set(j, swap);
        }

        for(int i = a.size() - k1, j = a.size() - 1; j > i; i++, j--) {
            int swap = a.get(i);
            a.set(i, a.get(j));
            a.set(j, swap);
        }

        for(int i = 0, j= a.size() - 1;j > i; i++, j--) {
            int swap = a.get(i);
            a.set(i, a.get(j));
            a.set(j, swap);
        }

        List<Integer> res = new ArrayList<>();
        for(int i: queries) {
            res.add((a.get(i)));
        }
        return res;
    }

    public static long repeatedString(String s, long n) {
        long div = n/s.length();
        long rem = n % s.length();
        long singleCount = 0;
        long remainingCount = 0;
        for(int i=0; i< s.length(); i++) {
            char c = s.charAt(i);
            if(c == 'a') {
                singleCount++;
                if(i < rem) {
                    remainingCount++;
                }
            }
        }
        return (singleCount * div ) + remainingCount;
    }

    // public static int jumpingOnClouds(List<Integer> c) {
    // // Write your code here
    //     int i1 = 0;
    //     int i2 = c.get(1) == 0 ? 1 : -1;
    //     for(int i= 2; i<c.size(); i++) {
    //         if(c.get(i) == 1) {
    //             i1 = i2;
    //             i2 = -1;
    //         } else {
    //             if(i1 != -1 && i2 != -1) {
    //             int next = Math.min(i1, i2) + 1;
    //             i1 = i2;
    //             i2 = next;
    //         } else if(i1 == -1) {
    //             i1 = i2;
    //             i2 += 1;
    //         } else if( i2 == -1) {
    //             int next = i1 + 1;
    //             i1 = i2;
    //             i2 = next;
    //         }
    //         }
    //     }
    //     return i2;
    // }

    public static int jumpingOnClouds(List<Integer> c) {
        int jumps = 0;
        int i = 0;

        while (i < c.size() - 1) {
            // If possible, prefer double jumps over single jumps
            i += (i + 2 < c.size() && c.get(i + 2) == 0) ? 2 : 1;
            jumps++;
        }

        return jumps;
    }

    public static void extraLongFactorials(int n) {
        // Write your code here
        BigInteger fact = BigInteger.valueOf(n--);
        while(n > 0) {
            fact = fact.multiply(BigInteger.valueOf(n--));
        }
        System.out.println(fact);
    }

    public static int viralAdvertising(int n) {
        // Write your code here
        int shared = 5;
        int liked = 2;
        int total = 2;
        int i=1;
        while(i<n) {
            i++;
            shared = liked * 3;
            int floor = shared / 2;
            liked = floor;
            total += floor;
        }
        return total;
    }

    public static int alternate(String s) {
        Set<Character> uniqueChars = new HashSet<>();
        for (char c : s.toCharArray()) {
            uniqueChars.add(c);
        }

        Character[] chars = uniqueChars.toArray(new Character[0]);
        int maxLength = 0;

        // Try all pairs of unique characters
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                char char1 = chars[i];
                char char2 = chars[j];

                StringBuilder filtered = new StringBuilder();
                for (char c : s.toCharArray()) {
                    if (c == char1 || c == char2) {
                        filtered.append(c);
                    }
                }

                if (isAlternating(filtered.toString())) {
                    maxLength = Math.max(maxLength, filtered.length());
                }
            }
        }

        return maxLength;
    }

    private static boolean isAlternating(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static String caesarCipher(String s, int k) {
        StringBuilder str = new StringBuilder();
        for(char c: s.toCharArray()) {
            if((c >= 97 && c <= 122)) {
                str.append((char) ((c - 97 + k) % 26 + 97));
            } else if((c >= 65 && c<=90 )) {
                str.append((char) ((c - 65 + k) % 26 + 65));
            }else {
                str.append(c);
            }
        }
        return str.toString();
    }

    public static int camelcase(String s) {
        int count = 1;
        for(char c: s.toCharArray()) {
            if(c >=65 && c<=90) {
                count++;
            }
        }
        return count;
    }

    public static int marsExploration(String s) {
        int count = 0;
        for(int i=0; i<s.length(); i++) {
            if(i % 3 == 1) {
                if(s.charAt(i) != 'O')
                    count++;
            } else {
                if(s.charAt(i) != 'S')
                    count++;
            }
        }
        return count;
    }

    public static String pangrams(String s) {
        boolean[] arr = new boolean[26];
        for(char c: s.toCharArray()) {
            if(c >= 65 && c<=90) {
                arr[c - 65] = true;
            } else if (c >= 97 && c<=122) {
                arr[c - 97] = true;
            }
        }

        for(boolean b: arr) {
            if(!b) return "not pangram";
        }

        return "pangram";
    }

    public int removeElement(int[] nums, int val) {
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    public int removeDuplicates(int[] nums) {
        int len= nums.length;
        int i=0;

        for(int k= 0; k< len; k++) {
            if(nums[i] != nums[k]) {
                nums[++i] = nums[k];
            }
        }
        return i+1;
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int maxNum = 0, count = 0;
        for(int n: map.keySet()) {
            int c = map.get(n);
            if(c > count) {
                count = c;
                maxNum = n;
            }
        }

        return maxNum;
    }

    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    public int lengthOfLongestSubstring(String s) {
        int i=0, j=0, max = 0;
        HashSet<Character> set = new HashSet<>();
        while(j < s.length()){
            if(set.contains(s.charAt(j))) {
                set.remove(s.charAt(i));
                i++;
            } else {
                set.add(s.charAt(j));
                j++;
                max = Math.max(max, set.size());
            }
        }
        return max;
    }

    public void rotate(int[] nums, int k) {
        int j = nums.length - (k%nums.length);
        swapNums(nums, 0, j);
        swapNums(nums, j, nums.length);
        swapNums(nums, 0, nums.length);

    }

    public void swapNums(int[] nums, int i, int j) {
        for(int x=i, y = j-1; x < y; x++, y--) {
            int swap = nums[x];
            nums[x] = nums[y];
            nums[y] = swap;
        }
    }
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[] mins = new int[len];
        mins[0] = prices[0];
        for(int i = 1; i<len; i++) {
            mins[i] = Math.min(prices[i-1], mins[i-1]);
        }
        int max = 0;
        for(int i=1;i<len;i++){
            if(prices[i] > mins[i]) {
                max = Math.max(max, prices[i] - mins[i]);
            }
        }

        return max;
    }

    public boolean canJump(int[] nums) {
        int finalPos = nums.length - 1;
        for(int i = nums.length - 2; i >= 0; i--) {
            if(nums[i] + i >= finalPos) {
                finalPos = i;
            }
        }
        return finalPos == 0;
    }

    public int maxProfit2(int[] prices) {
        int[] profits = new int[prices.length];
        for(int i =1; i< prices.length; i++) {
            if(prices[i] > prices[i-1]) {
                profits[i] = prices[i] - prices[i-1];
            }
        }
        int sum = 0;
        for(int n: profits) {
            sum+= n;
        }
        return sum;
    }

    public int hIndex(int[] citations) {
        int count = 0;
        Arrays.sort(citations);
        for(int i = citations.length - 1; i >=0 ; i--) {
            if(citations[i] > count) {
                count++;
            }
        }
        return count;
    }

    public int lengthOfLastWord(String s) {
        String[] arr = s.split(" ");
        return arr[arr.length - 1].length();
    }

    public void printDuplicates(String str) {
        String[] arr = str.split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        for(String s: arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            if(entry.getValue() > 1) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }

    public String reverseWords(String s) {
        String[] arr = s.trim().split("\\s+");
        for(int i=0, j = arr.length - 1; j > i; i++, j--) {
            String temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return String.join(" ", arr);
    }
}

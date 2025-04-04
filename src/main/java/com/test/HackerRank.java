package com.test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
}

package com.test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LeetCodeQuestions {
    public static void main(String[] args) {
//        System.out.println(maximumSwap(2736));
//        System.out.println(ispar("{([])"));
//        leaders(5, new int[]{10, 4, 2, 4, 1}).forEach(System.out::println);

        // Linked List 1: Length 3
        Node head1 = new Node(1);
        head1.next = new Node(0);
        head1.next.next = new Node(0);

        // Linked List 2: Length 4
        Node head2 = new Node(1);
        head2.next = new Node(0);
//        head2.next.next = new Node(6);
//        head2.next.next.next = new Node(7);

        System.out.println(multiplyTwoLists(head1, head2));
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
}

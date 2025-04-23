package com.test;

import java.util.List;
import java.util.Map;
import java.util.Stack;

public class AnotherOne {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/home//foo/"));
        System.out.println(simplifyPath("/home/user/Documents/../Pictures"));
        System.out.println(simplifyPath("/../"));
        System.out.println(simplifyPath("/.../a/../b/c/../d/./"));
        System.out.println(simplifyPath("/home/"));
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode(0);
        ListNode curr = res;
        while(list1 != null || list2 != null) {
            int x = list1 == null ? Integer.MAX_VALUE : list1.val;
            int y = list2 == null ? Integer.MAX_VALUE : list2.val;
            curr.next = new ListNode(Math.min(x, y));
            curr = curr.next;
            if(x < y) {
                list1 = list1.next;
            } else {
                if(list2 != null )
                    list2 = list2.next;
            }
        }
        return res.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode current = res;
        int carry  = 0;
        while(l1 != null || l2 != null || carry != 0) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0: l2.val;
            int sum = x + y + carry;
            carry = sum/10;
            current.next = new ListNode(sum%10);
            current = current.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        return res.next;
    }

    public static String simplifyPath(String path) {
        String[] arr = path.split("/+");
        Stack<String> stack = new Stack<>();
        for(String s: arr) {
            if(s.equals("..")) {
                if(!stack.isEmpty()) stack.pop();
            } else if(!s.equals(".") && !s.isEmpty()) {
                stack.push(s);
            }
        }

        StringBuilder res = new StringBuilder();
        for (String dir : stack) {
            res.append("/");
            res.append(dir);
        }
        return res.isEmpty() ? "/" : res.toString();
    }
}

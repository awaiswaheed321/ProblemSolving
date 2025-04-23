package com.test;

import java.util.Stack;

public class AnotherOne {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/home//foo/"));
        System.out.println(simplifyPath("/home/user/Documents/../Pictures"));
        System.out.println(simplifyPath("/../"));
        System.out.println(simplifyPath("/.../a/../b/c/../d/./"));
        System.out.println(simplifyPath("/home/"));
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

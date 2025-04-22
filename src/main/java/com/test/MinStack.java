package com.test;

import java.util.Stack;

class MinStack {
    Stack<Node> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {

        if(stack.isEmpty()) stack.push(new Node(val, val));
        else {
            int currMin = Math.min(val, stack.peek().min);
            stack.push(new Node(val, currMin));
        }

    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().min;
    }


    static class Node {
        int val;
        int min;

        public Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }
}

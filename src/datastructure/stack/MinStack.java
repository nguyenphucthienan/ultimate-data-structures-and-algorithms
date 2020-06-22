package datastructure.stack;

import java.util.Stack;

public class MinStack {

    private final Stack<Integer> stack = new Stack<>();
    private final Stack<Integer> minStack = new Stack<>();

    public void push(int item) {
        stack.push(item);

        if (minStack.isEmpty()) {
            minStack.push(item);
        } else if (item < minStack.peek()) {
            minStack.push(item);
        }
    }

    public int pop() {
        if (stack.isEmpty()) {
            throw new IllegalStateException();
        }

        int top = stack.pop();

        if (minStack.peek().equals(top)) {
            minStack.pop();
        }

        return top;
    }

    public int min() {
        return minStack.peek();
    }
}

package com.marcussinclair;

import java.util.Arrays;

public class Stack {
    // Stack
    private int[] stack = new int[5];
    private int size = 0;

    public void push(int input) {
        if (size == stack.length) {
            throw new StackOverflowError();
        }
        stack[size] = input;
        size++;
    }
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return stack[--size];
    }
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return stack[size-1];
    }
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public String toString() {
        var result = Arrays.copyOfRange(stack, 0, size);
        return Arrays.toString(result);
    }
}

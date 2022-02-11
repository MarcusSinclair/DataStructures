package com.marcussinclair;

public class QueueWithTwoStacks {
    Stack stack = new Stack();
    Stack stackReversed = new Stack();

    public void enqueue(int item) {
        stack.push(item);
    }
    public int dequeue() {
        while (!stack.isEmpty()) {
            stackReversed.push(stack.pop());
        }
        var popped = stackReversed.pop();
        while (!stackReversed.isEmpty()) {
            stack.push(stackReversed.pop());
        }
        return popped;
    }
    @Override
    public String toString() {
        return stack.toString();
    }
}

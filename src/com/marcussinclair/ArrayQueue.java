package com.marcussinclair;

import java.util.Arrays;

public class ArrayQueue {
    private int [] queue = new int[5];
    private int head = 0;
    private int tail = 0;
    private int count = 0;

    public void enqueue(int item) {
        if (isFull()) {
            throw new IllegalStateException();
        }
        queue[tail++] = item;
        tail = tail % queue.length;
        count++;
    }
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        var headValue = queue[head];
        queue[head++] = 0;
        head = head % queue.length;
        count--;
        return headValue;

    }
    @Override
    public String toString() {
        return Arrays.toString(queue);
    }
    public int peek() {
        return queue[head];
    }
    public boolean isEmpty() {
        return count == 0;
    }
    public boolean isFull() {
        return count == queue.length;
    }
}

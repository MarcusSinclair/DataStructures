package com.marcussinclair;

import java.util.LinkedList;

public class LinkedListQueue {
    LinkedList<Integer> queue = new LinkedList<>();

    // enqueue
    // dequeue
    // peek
    // size
    // isEmpty

    public void enqueue(int item) {
        queue.push(item);
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}

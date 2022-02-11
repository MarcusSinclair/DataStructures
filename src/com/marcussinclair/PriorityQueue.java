package com.marcussinclair;

import java.util.Arrays;

public class PriorityQueue {

    int[] queue = new int[5];
    int size = 0;

    public void insert(int item) {
        if (isFull()) {
            throw new IllegalStateException();
        }
        int i = shiftItemsToInsert(item);
        queue[i] = item;
        size++;
    }
    public int shiftItemsToInsert(int item) {
        int i;
        for (i = size - 1; i >= 0; i--) {
            if (queue[i] > item) {
                queue[i + 1] = queue[i];
            }
            else {
                break;
            }
        }
        return i + 1;
    }
    public int remove() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return queue[--size];
    }

    public boolean isEmpty() {
        return size == 0;
     }

     public boolean isFull() {
        return size == queue.length;
     }

    @Override
    public String toString() {
        return Arrays.toString(queue);
    }
}

package com.marcussinclair;

public class Heap {
    // Heap
    // int[]
    // insert(int)
    // remove

    private int[] items = new int[10];
    private int size;

    public void insert(int value) {
        if ( isFull() )
            throw new IllegalStateException();
        items[size] = value;
        size++;

        bubbleUp();
    }
    public void remove() {
        if (size == 0)
            return;

        var lastIndex = size - 1;
        items[0] = items[lastIndex];
        size--;

        if (size == 1) return;

        bubbleDown();
    }

    private void bubbleDown() {
        var currentIndex = 0;
        var greatestChildIndex = greatestChildOf(currentIndex);

        while (greatestChildIndex < size && items[greatestChildIndex] > items[currentIndex]) {
            swapValuesOf(greatestChildIndex, currentIndex);
            currentIndex = greatestChildIndex;
            greatestChildIndex = greatestChildOf(currentIndex);
        }
    }

    private int greatestChildOf(int index) {
        var leftChildIndex = index * 2 + 1;
        var rightChildIndex = index * 2 + 2;
        if (rightChildIndex > size - 1)
            return leftChildIndex;
        return items[leftChildIndex] > items[rightChildIndex] ? leftChildIndex : rightChildIndex;
    }

    private boolean isFull() {
        return size >= items.length;
    }
    private void bubbleUp() {
        var currentIndex = size - 1;
        while (currentIndex > 0 && items[currentIndex] > items[parentOf(currentIndex)]) {
            swapValuesOf(currentIndex, parentOf(currentIndex));
            currentIndex = parentOf(currentIndex);
        }
    }
    private int parentOf(int index) {
        return (index - 1) / 2;
    }
    private void swapValuesOf(int firstIndex, int secondIndex) {
        var secondValue = items[secondIndex];
        items[secondIndex] = items[firstIndex];
        items[firstIndex] = secondValue;
    }
}

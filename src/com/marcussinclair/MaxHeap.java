package com.marcussinclair;

public class MaxHeap {

    public static void heapify(int[] array) {
        var lastParentIndex = array.length / 2 - 1;
        for (int i = 0; i < lastParentIndex ; i++) {
            int leftIndex = i * 2 + 1;
            int rightIndex = i * 2 + 2;
            int largerIndex;

            if ( leftIndex >= array.length ) {
                continue;
            }
            if ( rightIndex >= array.length) {
                largerIndex = leftIndex;
            }
            else {
                largerIndex = array[leftIndex] > array[rightIndex] ? leftIndex : rightIndex;
            }
            if (array[i] < array[largerIndex]) {
                swap(array, i, largerIndex);
            }
        }
    }

    private static void swap(int[] array, int firstIndex, int secondIndex) {
        int tempValue = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = tempValue;
    }

    public static int getKthLargest(int[] array, int k) {
        if(k < 1 || k > array.length)
            throw new IllegalArgumentException();
        var heap = new Heap();
        for (int i = 0; i < array.length; i++) {
            heap.insert(array[i]);
        }
        for (int i = 0; i < k - 1; i++) {
            heap.remove();
        }
        return heap.max();
    }
}

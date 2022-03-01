package com.marcussinclair;

import java.util.Arrays;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        int[] numbers = {5, 3, 8, 4, 1, 2};
        MaxHeap.heapify(numbers);

        System.out.println(Arrays.toString(numbers));
        System.out.println(MaxHeap.getKthLargest(numbers, 7));

    }
}

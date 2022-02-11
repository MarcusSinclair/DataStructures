package com.marcussinclair;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        var tree = new BinaryTree();
        int[] values = {10, 5, 15, 6, 1, 8, 12, 18, 17};
        for (int value : values) {
            tree.insert(value);
        }

        System.out.println(tree.height());
    }

    public static void reverse(Queue<Integer> queue) {
        // [1, 2, 3]
        // [3, 2, 1]
        // add, remove, isEmpty
        Stack stack = new Stack();
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }
}

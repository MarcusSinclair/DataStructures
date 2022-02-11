package com.marcussinclair;

import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }
    private Node first;
    private Node last;
    private int size = 0;

    public void addLast(int value) {
        var node = new Node(value);

        if (isEmpty()) {
            first = last = node;
        }
        else {
            last.next = node;
            last = node;
        }
        size++;
    } // O(1)
    public void addFirst(int value) {
        var node = new Node(value);
        if (isEmpty()) {
            first = last = node;
        }
        else {
            node.next = first;
            first = node;
        }
        size++;
    } // O(1)
    private boolean isEmpty() {
        return first == null;
    } // O(1)
    public int indexOf(int value) {
        int index = 0;
        Node current = first;
        while (current != null) {
            if (current.value == value) return index;
            else current = current.next;
            index++;
        }
        return -1;
    } // O(n)
    public boolean contains(int value) {
        return indexOf(value) != -1;
    } // O(1) + O(n)
    public void removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (first == last) {
            first = last = null;
        }
        else {
            Node second = first.next;
            first.next = null;
            first = second;
        }
        size--;
    } // O(1)
    public void removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (first == last) {
            first = last = null;
        }
        else {
            Node previous = getPrevious(last);
            previous.next = null;
            last = previous;
        }
        size--;
    } // O(1) + O(n)
    private Node getPrevious(Node node) {
        Node current = first;
        while (current != null ) {
            if (current.next == node) return current;
            current = current.next;
        }
        return null;
    } // O(n)
    public int size() {
        return size;
    } // O(n)
    public int[] toArray() {
        int[] array = new int[size];
        int index = 0;
        Node current = first;
        while (current != null) {
            array[index] = current.value;
            current = current.next;
            index++;
        }
        return array;
    } // O(n)
    public void reverse() {
        if (isEmpty()) {
            return;
        }
        Node previous = null;
        Node current = first;
        Node next = current.next;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        last = first;
        first = previous;
    } // O(n)
    public int getKthFromTheEnd(int k) {
        // Find the Kth node from the end of a linked list in one pass
        // [10 -> 20 -> 30 -> 40 -> 50]
        //   *           *
        // K = 1 (50) (distance = 0)
        // K = 2 (40) (distance = 1)
        // K = 3 (30) (distance = 2)
        if ( k < 1 || k > size) {
            throw new IllegalArgumentException();
        }

        Node pointer1 = first;
        Node pointer2 = first;
        int count = 0;

        while(pointer2 != null) {
            if (count >= k) {
                pointer1 = pointer1.next;
            }
            pointer2 = pointer2.next;
            count++;
        }
        return pointer1.value;
    } // O(n)
    public void printMiddle() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        Node pointer1 = first;
        Node pointer2 = first;

        while(pointer2.next != null && pointer2.next.next != null) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next.next;

        }
        if (pointer2 == last) {
            System.out.println(pointer1.value);
        }
        else {
            System.out.println(pointer1.value + ", " + pointer1.next.value);
        }
    } // O(n)
    public boolean hasLoop() {
        Node slow = first;
        Node fast = first;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
    public static LinkedList createWithLoop() {
        var list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        // Get a reference to 30
        var node = list.last;

        list.addLast(40);
        list.addLast(50);

        // Create the loop
        list.last.next = node;

        return list;
    }
}

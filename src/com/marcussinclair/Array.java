package com.marcussinclair;

import org.w3c.dom.ls.LSOutput;

public class Array {
    private int[] items;
    private int count;

    public Array(int length) {
        this.items = new int[length];
    }
    private void resizeIfRequired() {
        if(count >= items.length) {
            int[] newItems = new int[count * 2];
            for (int i = 0; i < count; i++) {
                newItems[i] = items[i];
            }
            items = newItems;
        }
    } // O(n), går det att få ner till O(1)?
    public void insert(int item) {
        resizeIfRequired();
        items[count] = item;
        count++;
    } // O(1),
    public void removeAt(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException();
        }

        for (int i = index; i < count; i++) {
            items[i] = items[i + 1];
        }
        count--;
    } // O(n)
    public int indexOf(int value) {
        for (int i = 0; i < count; i++) {
            if (items[i] == value) {
                return i;
            }
        }
        return -1;
    } // O(n)
    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    } // O(n)
    public int max() { // O(n)
        int max = 0;
        for (int i = 0; i < count; i++) {
            if (items[i] > max) {
                max = items[i];
            }
        }
        return max;
    } // O(n)
    public Array intersect(Array other) {
        Array intersect = new Array(count);
        for (int thisValue : items) {
            if( other.indexOf(thisValue) != -1 ) {
                intersect.insert(thisValue);
            }
        }
        return intersect;
    } // O(n) * O(n) = O(n^2), kan man undvika dubletter?
    public void reverse() {
        int[] reversedArray = new int[count];
        int forwardIndex = 0;
        for (int i = count -1; i >= 0; i--) {
            reversedArray[forwardIndex] = items[i];
            forwardIndex++;
        }
        items = reversedArray;
    } // O(n)
    public void insertAt(int item, int index) {
        resizeIfRequired();
        if (index > count || index < 0) {
            throw new IllegalArgumentException();
        }
        for (int i = count; i > index; i--) {
            items[i] = items[i-1];
        }
        items[index] = item;
        count++;
    } // O(n)
}

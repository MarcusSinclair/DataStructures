package com.marcussinclair;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node=" + value;
        }
    }

    private Node root;

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }
        var current = root;

        var node = new Node(value);
        while (true) {
            if (value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = node;
                    return;
                }
                current = current.leftChild;
            }
            else {
                if (current.rightChild == null) {
                    current.rightChild = node;
                    return;
                }
                current = current.rightChild;
            }
        }

    }
    public boolean find(int value) {
        var current = root;
        while (current != null) {
            if (value < current.value)
                current = current.leftChild;
            else if (value > current.value)
                current = current.rightChild;
            else
                return true;
        }
        return false;
    }

    public void traversePreorder() {
        traversePreorder(root);
    }
    public void traversePreorder(Node current) {
        if (current == null) {
            return;
        }
        System.out.println(current.value);
        traversePreorder(current.leftChild);
        traversePreorder(current.rightChild);
    }

    public void traverseInorder() {
        traverseInorder(root);
    }
    public void traverseInorder(Node current) {
        if (current == null)
            return;

        traverseInorder(current.leftChild);
        System.out.println(current.value);
        traverseInorder(current.rightChild);
    }

    public void traversePostorder() {
        traversePostorder(root);
    }
    public void traversePostorder(Node current) {
        if (current == null) {
            return;
        }
        traversePostorder(current.leftChild);
        traversePostorder(current.rightChild);
        System.out.println(current.value);
    }

    public int height() {
        return height(root);
    }
    private int height(Node current) {
        if (current == null)
            return -1;

        if (isLeaf(current))
            return 0;

        return 1 + Math.max(
                height(current.leftChild),
                height(current.rightChild));
    }

    public int minBinary() {
        if (root == null)
            throw new IllegalStateException();

        var current = root;
        var last = current;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last.value;
    } // For Binary Search Trees
    public int min() {
        return min(root);
    }
    public int min(Node current) {
        if (current == null ) {
            return Integer.MAX_VALUE;
        }
        if (isLeaf(current))
            return current.value;
        var left = min(current.leftChild);
        var right = min(current.rightChild);

        return Math.min( Math.min(left, right), current.value );
    }

    private boolean isLeaf(Node node) {
        return node.leftChild == null && node.rightChild == null;
    }

    public boolean equals(BinaryTree other) {
        return equals(root, other.root);
    }
    private boolean equals(Node first, Node second) {
        if (first == null && second == null)
            return true;

        if (first != null && second != null) {
            return first.value == second.value
                    && equals(first.leftChild, second.leftChild)
                    && equals(first.rightChild, second.rightChild);
        }

        return false;
    }

    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinarySearchTree(Node current, int min, int max) {
        if (current == null) {
            return true;
        }
        if (current.value < min || current.value > max) {
            return false;
        }
//        System.out.println("min: " + min + " max: " + max + " current: " +current.value);
            return
                isBinarySearchTree(current.leftChild, min, current.value - 1)
                && isBinarySearchTree(current.rightChild, current.value + 1, max);
    }

    public ArrayList<Integer> getNodesAtDistance(int distance) {
        var list = new ArrayList<Integer>();
        getNodesAtDistance(root, distance, list);
        return list;
    }
    private void getNodesAtDistance(Node current, int distance, ArrayList<Integer> list) {
        if (current == null) {
            return;
        }
        if (distance == 0) {
            list.add(current.value);
            return;
        }
        getNodesAtDistance(current.leftChild, distance - 1, list);
        getNodesAtDistance(current.rightChild, distance - 1, list);

    }

    public void traverseLevelOrder() {
        for (int i = 0; i <= height(); i++) {
            for ( var value : getNodesAtDistance(i)) {
                System.out.println(value);
            }
        }
    }

    public int size() {
        return size(root);
    }
    private int size(Node current) {
        if (current == null) {
            return 0;
        }
        return 1 + size(current.leftChild) + size(current.rightChild);
    }

    public int max() {
        return max(root);
    }
    private int max(Node current) {
        if (current == null)
            return Integer.MIN_VALUE;
        if (isLeaf(current)) {
            return current.value;
        }
        var left = max(current.leftChild);
        var right = max(current.rightChild);
        return Math.max(Math.max(left, right), current.value);
    }

    public boolean contains(int item) {
        return contains(root, item);
    }
    private boolean contains(Node current, int item) {
        if (current == null) {
            return false;
        }
        if (current.value == item) {
            return true;
        }
        return contains(current.leftChild, item) || contains(current.rightChild, item);
    }

    public boolean areSibling(int first, int second) {
        return areSibling(root, first, second);
    }
    private boolean areSibling(Node current, int first, int second) {
        if (root == null)
            return false;
        if ( current.leftChild == null || current.rightChild == null)
            return false;
        var leftSibling = current.leftChild.value;
        var rightSibling = current.rightChild.value;
        if (
                leftSibling == first && rightSibling == second ||
                leftSibling == first && rightSibling == second) {
            return true;
        }
        return areSibling(current.leftChild, first, second) || areSibling(current.rightChild, first, second);
    }
    public List<Integer> getAncestors(int value) {
        var list = new ArrayList<Integer>();
        getAncestors(root, value, list);
        return list;
    }
    private boolean getAncestors(Node current, int value, List<Integer> list) {
        if (current == null)
            return false;
        if (current.value == value)
            return true;

        if (getAncestors(current.leftChild, value, list) || getAncestors(current.rightChild, value, list)) {
            list.add(current.value);
            return true;
        }
        return false;
    }

}

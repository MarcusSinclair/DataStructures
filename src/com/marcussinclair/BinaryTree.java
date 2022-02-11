package com.marcussinclair;

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

        if (current.leftChild == null && current.rightChild == null)
            return 0;

        return 1 + Math.max(
                height(current.leftChild),
                height(current.rightChild));
    }
}

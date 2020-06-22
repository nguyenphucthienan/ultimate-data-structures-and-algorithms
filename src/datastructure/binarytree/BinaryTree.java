package datastructure.binarytree;

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
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }

    private Node root;

    public void insert(int value) {
        Node node = new Node(value);

        if (root == null) {
            root = node;
            return;
        }

        Node current = root;
        while (true) {
            if (value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            } else {
                if (current.rightChild == null) {
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }
        }
    }

    public boolean find(int value) {
        Node current = root;

        while (current != null) {
            if (value < current.value) {
                current = current.leftChild;
            } else if (value > current.value) {
                current = current.rightChild;
            } else {
                return true;
            }
        }

        return false;
    }

    private Node get(int value) {
        Node current = root;

        while (current != null) {
            if (value < current.value) {
                current = current.leftChild;
            } else if (value > current.value) {
                current = current.rightChild;
            } else {
                return current;
            }
        }

        return null;
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private void traversePreOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.value + " ");
        traversePreOrder(node.leftChild);
        traversePreOrder(node.rightChild);
    }

    private void traverseInOrder(Node node) {
        if (node == null) {
            return;
        }

        traversePreOrder(node.leftChild);
        System.out.print(node.value + " ");
        traversePreOrder(node.rightChild);
    }

    private void traversePostOrder(Node node) {
        if (node == null) {
            return;
        }

        traversePreOrder(node.leftChild);
        traversePreOrder(node.rightChild);
        System.out.print(node.value + " ");
    }

    public void traverseLevelOrder() {
        for (int i = 0; i <= height(root); i++) {
            List<Integer> values = getNodesAtDistance(i);
            for (int value : values) {
                System.out.print(value + " ");
            }
        }
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) {
            return -1;
        }

        if (isLeaf(node)) {
            return 0;
        }

        return 1 + Math.max(height(node.leftChild), height(node.rightChild));
    }

    // Binary Search Tree: O(log n)
    public int minOfBST() {
        if (root == null) {
            throw new IllegalStateException();
        }

        Node current = root;
        Node last = current;

        while (current != null) {
            last = current;
            current = current.leftChild;
        }

        return last.value;
    }

    // Binary Tree: O(n)
    public int min() {
        return min(root);
    }

    private int min(Node node) {
        if (node == null) {
            throw new IllegalStateException();
        }

        if (isLeaf(node)) {
            return node.value;
        }

        return Math.min(node.value, Math.min(min(node.leftChild), min(node.rightChild)));
    }

    public int max() {
        return max(root);
    }

    private int max(Node node) {
        if (node == null) {
            throw new IllegalStateException();
        }

        if (isLeaf(node)) {
            return node.value;
        }

        return Math.max(node.value, Math.max(max(node.leftChild), max(node.rightChild)));
    }

    private boolean isLeaf(Node node) {
        return node.leftChild == null && node.rightChild == null;
    }

    public boolean equals(BinaryTree binaryTree) {
        if (binaryTree == null) {
            return false;
        }

        return equals(root, binaryTree.root);
    }

    private boolean equals(Node first, Node second) {
        if (first == null && second == null) {
            return true;
        }

        if (first != null && second != null) {
            return first.value == second.value
                    && equals(first.leftChild, second.leftChild)
                    && equals(first.rightChild, second.rightChild);
        }

        return false;
    }

    public boolean contains(int value) {
        return contains(root, value);
    }

    private boolean contains(Node node, int value) {
        if (node == null) {
            return false;
        }

        if (node.value == value) {
            return true;
        }

        return contains(node.leftChild, value) || contains(node.rightChild, value);
    }

    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isBinarySearchTree(Node node, int min, int max) {
        if (node == null) {
            return true;
        }

        if (node.value < min || node.value > max) {
            return false;
        }

        return isBinarySearchTree(node.leftChild, min, node.value - 1)
                && isBinarySearchTree(node.rightChild, node.value + 1, max);
    }

    public List<Integer> getNodesAtDistance(int distance) {
        List<Integer> list = new ArrayList<>();
        getNodesAtDistance(root, distance, list);
        return list;
    }

    private void getNodesAtDistance(Node node, int distance, List<Integer> list) {
        if (node == null) {
            return;
        }

        if (distance == 0) {
            list.add(node.value);
            return;
        }

        getNodesAtDistance(node.leftChild, distance - 1, list);
        getNodesAtDistance(node.rightChild, distance - 1, list);
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }

        return 1 + size(node.leftChild) + size(node.rightChild);
    }

    public int countLeaves() {
        return countLeaves(root);
    }

    private int countLeaves(Node node) {
        if (root == null) {
            return 0;
        }

        if (isLeaf(node)) {
            return 1;
        }

        return countLeaves(node.leftChild) + countLeaves(node.rightChild);
    }

    public boolean areSibling(int firstValue, int secondValue) {
        return areSibling(root, firstValue, secondValue);
    }

    private boolean areSibling(Node node, int firstValue, int secondValue) {
        if (node == null) {
            return false;
        }

        boolean areSibling = false;
        if (node.leftChild != null && node.rightChild != null) {
            areSibling = (node.leftChild.value == firstValue && node.rightChild.value == secondValue)
                    || (node.rightChild.value == firstValue && node.leftChild.value == secondValue);
        }

        return areSibling
                || areSibling(node.leftChild, firstValue, secondValue)
                || areSibling(node.rightChild, firstValue, secondValue);
    }

    public List<Integer> getAncestors(int value) {
        List<Integer> list = new ArrayList<>();
        getAncestors(root, value, list);
        return list;
    }

    private boolean getAncestors(Node node, int value, List<Integer> list) {
        // We should traverse the tree until we find the target value.
        // If find the target value, we return true without adding the current node to the list;
        if (node == null) {
            return false;
        }

        if (node.value == value) {
            return true;
        }

        // If we find the target value in the left or right sub-trees, that means
        // the current node (root) is one of the ancestors. So we add it to the list.
        if (getAncestors(node.leftChild, value, list) || getAncestors(node.rightChild, value, list)) {
            list.add(node.value);
            return true;
        }

        return false;
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }

        int balanceFactor = height(node.leftChild) - height(node.rightChild);
        return Math.abs(balanceFactor) <= 1
                && isBalanced(node.leftChild)
                && isBalanced(node.rightChild);
    }

    public boolean isPerfect() {
        return size() == (Math.pow(2, height() + 1) - 1);
    }
}

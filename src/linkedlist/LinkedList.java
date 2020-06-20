package linkedlist;

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
    private int size;

    public void addFirst(int item) {
        Node node = new Node(item);

        if (isEmpty()) {
            first = last = node;
        } else {
            node.next = first;
            first = node;
        }

        size++;
    }

    public void addLast(int item) {
        Node node = new Node(item);

        if (isEmpty()) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }

        size++;
    }

    public void removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        if (first == last) {
            first = last = null;
        } else {
            Node second = first.next;
            first.next = null;
            first = second;
        }

        size--;
    }

    public void removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        if (first == last) {
            first = last = null;
        } else {
            Node previous = getPrevious(last);
            if (previous != null) {
                last = previous;
                previous.next = null;
            }
        }

        size--;
    }

    public int indexOf(int item) {
        int index = 0;
        Node current = first;

        while (current != null) {
            if (current.value == item) {
                return index;
            }

            index++;
            current = current.next;
        }

        return -1;
    }

    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    public int size() {
        return size;
    }

    public int[] toArray() {
        int[] array = new int[size];
        int index = 0;
        Node current = first;

        while (current != null) {
            array[index++] = current.value;
            current = current.next;
        }

        return array;
    }

    public void reverse() {
        if (isEmpty()) {
            return;
        }

        Node previous = first;
        Node current = previous.next;

        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = previous;
    }

    public int getKthFromTheEnd(int k) {
        if (isEmpty()) {
            throw new IllegalStateException();
        }

        var firstPointer = first;
        var secondPointer = first;

        for (int i = 0; i < k - 1; i++) {
            secondPointer = secondPointer.next;
            if (secondPointer == null) {
                throw new IllegalArgumentException();
            }
        }

        while (secondPointer != last) {
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next;
        }

        return firstPointer.value;
    }

    public int[] getMiddles() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }

        var firstPointer = first;
        var secondPointer = first;

        while (secondPointer != last && secondPointer.next != last) {
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next.next;
        }

        // If the list has an even number of nodes, at the end of the last iteration,
        // the second pointer will reference the tail node; otherwise, it'll be null.
        if (secondPointer == last) {
            return new int[]{firstPointer.value};
        } else {
            return new int[]{firstPointer.value, firstPointer.next.value};
        }
    }

    public boolean hasLoop() {
        var firstPointer = first;
        var secondPointer = first;

        while (secondPointer != null && secondPointer.next != null) {
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next.next;

            if (firstPointer == secondPointer) {
                return true;
            }
        }

        return false;
    }

    private boolean isEmpty() {
        return first == null;
    }

    private Node getPrevious(Node node) {
        Node current = first;

        while (current != null) {
            if (current.next == node) {
                return current;
            }

            current = current.next;
        }

        return null;
    }
}

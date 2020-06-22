package datastructure.heap;

public class Heap {

    private final int[] items;
    private int size;

    public Heap(int capacity) {
        items = new int[capacity];
    }

    public void insert(int value) {
        if (isFull()) {
            throw new IllegalStateException();
        }

        items[size++] = value;
        bubbleUp();
    }

    private void bubbleUp() {
        int index = size - 1;
        while (index > 0 && items[index] > items[getParentIndex(index)]) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    public int remove() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }

        int root = items[0];
        items[0] = items[--size];
        items[size] = 0;

        bubbleDown();
        return root;
    }

    private void bubbleDown() {
        int index = 0;
        while (index <= size && !isValidParent(index)) {
            int largerChildIndex = getLargerChildIndex(index);
            swap(index, largerChildIndex);
            index = largerChildIndex;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == items.length;
    }

    private boolean isValidParent(int index) {
        if (!hasLeftChild(index)) {
            return true;
        }

        if (!hasRightChild(index)) {
            return items[index] >= getLeftChild(index);
        }

        return items[index] >= getLeftChild(index)
                && items[index] >= getRightChild(index);
    }

    private int getLargerChildIndex(int index) {
        if (!hasLeftChild(index)) {
            return index;
        }

        if (!hasRightChild(index)) {
            return getLeftChildIndex(index);
        }

        return getLeftChild(index) > getRightChild(index)
                ? getLeftChildIndex(index)
                : getRightChildIndex(index);
    }

    private int getLeftChild(int index) {
        return items[getLeftChildIndex(index)];
    }

    private int getRightChild(int index) {
        return items[getRightChildIndex(index)];
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) <= size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) <= size;
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private int getLeftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int getRightChildIndex(int index) {
        return index * 2 + 2;
    }

    private void swap(int firstIndex, int secondIndex) {
        int tempValue = items[firstIndex];
        items[firstIndex] = items[secondIndex];
        items[secondIndex] = tempValue;
    }

    public int max() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }

        return items[0];
    }

    public static boolean isMaxHeap(int[] array) {
        return isMaxHeap(array, 0);
    }

    private static boolean isMaxHeap(int[] array, int index) {
        // All leaf nodes are valid
        int lastParentIndex = (array.length - 2) / 2;
        if (index > lastParentIndex) {
            return true;
        }

        int leftChildIndex = index * 2 + 1;
        int rightChildIndex = index * 2 + 2;

        boolean isValidParent = array[index] >= array[leftChildIndex]
                && array[index] >= array[rightChildIndex];

        return isValidParent
                && isMaxHeap(array, leftChildIndex)
                && isMaxHeap(array, rightChildIndex);
    }
}

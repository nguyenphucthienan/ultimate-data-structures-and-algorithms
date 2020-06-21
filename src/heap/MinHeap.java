package heap;

public class MinHeap {

    private class Node {
        private int key;
        private String value;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value='" + value + '\'' +
                    '}';
        }
    }

    private final Node[] items;
    private int size = 0;

    public MinHeap(int capacity) {
        items = new Node[capacity];
    }

    public void insert(int key, String value) {
        if (isFull()) {
            throw new IllegalStateException();
        }

        items[size++] = new Node(key, value);
        bubbleUp();
    }

    private void bubbleUp() {
        int index = size - 1;
        while (index > 0 && items[index].key < items[getParentIndex(index)].key) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    public String remove() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }

        Node minItem = items[0];
        items[0] = items[--size];
        items[size] = null;

        bubbleDown();
        return minItem.value;
    }

    private void bubbleDown() {
        int index = 0;
        while (index <= size && !isValidParent(index)) {
            int smallerChildIndex = getSmallerChildIndex(index);
            swap(index, smallerChildIndex);
            index = smallerChildIndex;
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
            return items[index].key <= getLeftChild(index).key;
        }

        return items[index].key <= getLeftChild(index).key
                && items[index].key <= getRightChild(index).key;
    }

    private int getSmallerChildIndex(int index) {
        if (!hasLeftChild(index)) {
            return index;
        }

        if (!hasRightChild(index)) {
            return getLeftChildIndex(index);
        }

        return getLeftChild(index).key < getRightChild(index).key
                ? getLeftChildIndex(index)
                : getRightChildIndex(index);
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) <= size && getLeftChild(index) != null;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) <= size && getRightChild(index) != null;
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

    private Node getLeftChild(int index) {
        return items[getLeftChildIndex(index)];
    }

    private Node getRightChild(int index) {
        return items[getRightChildIndex(index)];
    }

    private void swap(int firstIndex, int secondIndex) {
        Node temp = items[firstIndex];
        items[firstIndex] = items[secondIndex];
        items[secondIndex] = temp;
    }
}

package queue;

import java.util.Arrays;

public class PriorityQueue {

    private final int[] items;
    private int count;

    public PriorityQueue(int capacity) {
        items = new int[capacity];
    }

    public void add(int item) {
        if (isFull()) {
            throw new IllegalStateException();
        }

        int index = shiftItemsToInsert(item);
        items[index] = item;
        count++;
    }

    private int shiftItemsToInsert(int item) {
        int index;
        for (index = count - 1; index >= 0; index--) {
            if (items[index] > item) {
                items[index + 1] = items[index];
            } else {
                break;
            }
        }

        return index + 1;
    }

    public int remove() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }

        return items[--count];
    }

    public boolean isFull() {
        return count == items.length;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        int[] content = Arrays.copyOfRange(items, 0, count);
        return Arrays.toString(content);
    }
}

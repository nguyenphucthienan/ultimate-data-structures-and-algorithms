package array;

public class Array {

    private int[] items;
    private int count;

    public Array(int length) {
        items = new int[length];
    }

    public void insert(int item) {
        resizeIfRequired();
        items[count++] = item;
    }

    public void insertAt(int item, int index) {
        if (index < 0 || index > count)
            throw new IllegalArgumentException();

        resizeIfRequired();

        for (int i = count - 1; i >= index; i--) {
            items[i + 1] = items[i];
        }

        items[index] = item;
        count++;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException();
        }

        for (int i = index; i < count; i++) {
            items[i] = items[i + 1];
        }

        count--;
    }

    public int indexOf(int number) {
        for (int i = 0; i < count; i++) {
            if (items[i] == number) {
                return i;
            }
        }

        return -1;
    }

    public int max() {
        int max = Integer.MIN_VALUE;

        for (int item : items) {
            if (item > max) {
                max = item;
            }
        }

        return max;
    }

    public void reverse() {
        int[] newItems = new int[count];

        for (int i = 0; i < count; i++) {
            newItems[i] = items[count - i - 1];
        }

        items = newItems;
    }

    public Array intersect(Array other) {
        var intersection = new Array(count);

        for (int item : items) {
            if (other.indexOf(item) >= 0) {
                intersection.insert(item);
            }
        }

        return intersection;
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }

    private void resizeIfRequired() {
        if (items.length == count) {
            int[] newItems = new int[count * 2];

            for (int i = 0; i < count; i++) {
                newItems[i] = items[i];
            }

            items = newItems;
        }
    }
}

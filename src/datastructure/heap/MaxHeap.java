package datastructure.heap;

public class MaxHeap {

    public static void heapify(int[] array) {
        int lastParentIndex = array.length / 2 - 1;
        for (int index = lastParentIndex; index >= 0; index--) {
            heapify(array, index);
        }
    }

    private static void heapify(int[] array, int index) {
        int largerIndex = index;
        int leftChildIndex = index * 2 + 1;
        int rightChildIndex = index * 2 + 2;

        if (leftChildIndex < array.length && array[leftChildIndex] > array[largerIndex]) {
            largerIndex = leftChildIndex;
        }

        if (rightChildIndex < array.length && array[rightChildIndex] > array[largerIndex]) {
            largerIndex = rightChildIndex;
        }

        if (index == largerIndex) {
            return;
        }

        swap(array, index, largerIndex);
        heapify(array, largerIndex);
    }

    private static void swap(int[] array, int firstIndex, int secondIndex) {
        int tempValue = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = tempValue;
    }

    public static int getKthLargest(int[] numbers, int k) {
        if (k < 1 || k > numbers.length) {
            throw new IllegalArgumentException();
        }

        Heap heap = new Heap(numbers.length);
        for (int number : numbers) {
            heap.insert(number);
        }

        for (int i = 0; i < k - 1; i++) {
            heap.remove();
        }

        return heap.max();
    }
}

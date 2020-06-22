package datastructure.heap;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.insert(15);
        heap.insert(10);
        heap.insert(3);
        heap.insert(8);
        heap.insert(12);
        heap.insert(9);
        heap.insert(4);
        heap.insert(1);
        heap.insert(24);
        System.out.println(heap.remove());

        int[] numbers = {15, 10, 3, 8, 12, 9, 4, 1, 24};
        MaxHeap.heapify(numbers);
        System.out.println(Arrays.toString(numbers));
        System.out.println(MaxHeap.getKthLargest(numbers, 3));

        MinHeap minHeap = new MinHeap(10);
        minHeap.insert(15, "A");
        minHeap.insert(10, "B");
        minHeap.insert(3, "C");
        minHeap.insert(8, "D");
        minHeap.insert(12, "E");
        minHeap.insert(9, "F");
        minHeap.insert(4, "G");
        minHeap.insert(1, "H");
        minHeap.insert(24, "I");
        System.out.println(minHeap.remove());
    }
}

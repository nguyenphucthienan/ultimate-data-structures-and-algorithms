package heap;

public class HeapPriorityQueue {

    private final Heap heap;

    public HeapPriorityQueue(int capacity) {
        heap = new Heap(capacity);
    }

    public void enqueue(int item) {
        heap.insert(item);
    }

    public int dequeue() {
        return heap.remove();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }
}

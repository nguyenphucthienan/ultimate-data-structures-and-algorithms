package heap;

public class MinPriorityQueue {

    private final MinHeap heap;

    public MinPriorityQueue(int capacity) {
        heap = new MinHeap(capacity);
    }

    public void enqueue(String value, int priority) {
        heap.insert(priority, value);
    }

    public String dequeue() {
        return heap.remove();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }
}

package datastructure.queue;

import java.util.Queue;
import java.util.Stack;

// Given an integer K and a datastructure.queue of integers,
// write code to reverse the order of the first K elements of the datastructure.queue.
// Input:  Q = [10, 20, 30, 40, 50], K = 3
// Output: Q = [30, 20, 10, 40, 50]

public class QueueReverser {

    public static void reverse(Queue<Integer> queue, int k) {
        if (k < 0 || k > queue.size()) {
            throw new IllegalArgumentException();
        }

        final Stack<Integer> stack = new Stack<>();

        // Dequeue the first K elements from the datastructure.queue and push them onto the datastructure.stack
        for (int i = 0; i < k; i++) {
            stack.push(queue.remove());
        }

        // Enqueue the content of the datastructure.stack at the back of the datastructure.queue
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        // Add the remaining items in the datastructure.queue (items after the first K elements)
        // to the back of the datastructure.queue and remove them from the beginning of the datastructure.queue
        for (int i = k; i < queue.size(); i++) {
            queue.add(queue.remove());
        }
    }
}

package datastructure.queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(5);
        arrayQueue.enqueue(1);
        arrayQueue.enqueue(2);
        arrayQueue.enqueue(3);
        System.out.println(arrayQueue.dequeue());

        LinkedListQueue linkedListQueue = new LinkedListQueue();
        linkedListQueue.enqueue(1);
        linkedListQueue.enqueue(2);
        linkedListQueue.enqueue(3);
        System.out.println(linkedListQueue.dequeue());

        QueueWithTwoStacks queueWithTwoStacks = new QueueWithTwoStacks();
        queueWithTwoStacks.enqueue(1);
        queueWithTwoStacks.enqueue(2);
        queueWithTwoStacks.enqueue(3);
        System.out.println(queueWithTwoStacks.dequeue());

        PriorityQueue priorityQueue = new PriorityQueue(5);
        priorityQueue.add(1);
        priorityQueue.add(3);
        priorityQueue.add(2);
        System.out.println(priorityQueue);

        Queue<Integer> queue = new ArrayDeque<>(Arrays.asList(10, 20, 30, 40, 50));
        System.out.println(queue);
        QueueReverser.reverse(queue, 3);
        System.out.println(queue);
    }
}

package linkedlist;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addFirst(4);

        linkedList.reverse();
        System.out.println(Arrays.toString(linkedList.toArray()));

        System.out.println(linkedList.getKthFromTheEnd(3));
        System.out.println(Arrays.toString(linkedList.getMiddles()));
    }
}

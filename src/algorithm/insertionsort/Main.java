package algorithm.insertionsort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] numbers = {7, 3, 1, 4, 6, 2, 3, 5};

        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(numbers);

        System.out.println(Arrays.toString(numbers));
    }
}

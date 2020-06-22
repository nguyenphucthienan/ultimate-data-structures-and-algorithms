package algorithm.mergesort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] numbers = {7, 3, 1, 4, 6, 2, 3, 5};

        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(numbers);

        System.out.println(Arrays.toString(numbers));
    }
}

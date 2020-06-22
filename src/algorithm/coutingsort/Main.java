package algorithm.coutingsort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] numbers = {7, 3, 1, 4, 6, 2, 3, 5};

        CountingSort countingSort = new CountingSort();
        countingSort.sort(numbers, 7);

        System.out.println(Arrays.toString(numbers));
    }
}

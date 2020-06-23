package algorithm.search.exponential;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] numbers = {7, 3, 1, 4, 6, 2, 5};
        Arrays.sort(numbers);

        ExponentialSearch exponentialSearch = new ExponentialSearch();
        int index = exponentialSearch.search(numbers, 3);

        System.out.println(index);
    }
}

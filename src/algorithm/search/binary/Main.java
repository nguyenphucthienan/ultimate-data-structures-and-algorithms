package algorithm.search.binary;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] numbers = {7, 3, 1, 4, 6, 2, 5};
        Arrays.sort(numbers);

        BinarySearch binarySearch = new BinarySearch();

        int recursiveIndex = binarySearch.searchRecursive(numbers, 3);
        System.out.println(recursiveIndex);

        int iterativeIndex = binarySearch.searchIterative(numbers, 3);
        System.out.println(iterativeIndex);
    }
}

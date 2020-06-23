package algorithm.search.ternary;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] numbers = {7, 3, 1, 4, 6, 2, 5};
        Arrays.sort(numbers);

        TernarySearch ternarySearch = new TernarySearch();

        int recursiveIndex = ternarySearch.searchRecursive(numbers, 3);
        System.out.println(recursiveIndex);

        int iterativeIndex = ternarySearch.searchIterative(numbers, 3);
        System.out.println(iterativeIndex);
    }
}

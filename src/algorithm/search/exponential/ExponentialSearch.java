package algorithm.search.exponential;

import algorithm.search.binary.BinarySearch;

public class ExponentialSearch {

    public int search(int[] array, int target) {
        int bound = 1;

        while (bound < array.length && array[bound] < target) {
            bound *= 2;
        }

        BinarySearch binarySearch = new BinarySearch();

        int left = bound / 2;
        int right = Math.min(bound, array.length);
        return binarySearch.searchRecursive(array, target, left, right);
    }
}

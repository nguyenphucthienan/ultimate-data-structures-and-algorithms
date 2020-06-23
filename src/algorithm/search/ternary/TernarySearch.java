package algorithm.search.ternary;

public class TernarySearch {

    public int searchRecursive(int[] array, int target) {
        return searchRecursive(array, target, 0, array.length - 1);
    }

    private int searchRecursive(int[] array, int target, int left, int right) {
        if (left > right) {
            return -1;
        }

        int partitionSize = (right - left) / 3;
        int middle1 = left + partitionSize;
        int middle2 = right - partitionSize;

        if (array[middle1] == target) {
            return middle1;
        }

        if (array[middle2] == target) {
            return middle2;
        }

        if (target < array[middle1]) {
            return searchRecursive(array, target, left, middle1 - 1);
        }

        if (target > array[middle2]) {
            return searchRecursive(array, target, middle2 + 1, right);
        }

        return searchRecursive(array, target, middle1 + 1, middle2 - 1);
    }

    public int searchIterative(int[] array, int target) {
        int left = 0;
        int right = array.length;
        int partitionSize = (right - left) / 3;

        while (left <= right) {
            int middle1 = left + partitionSize;
            int middle2 = right - partitionSize;

            if (array[middle1] == target) {
                return middle1;
            }

            if (array[middle2] == target) {
                return middle2;
            }

            if (target < array[middle1]) {
                right = middle1 - 1;
                continue;
            }

            if (target < array[middle2]) {
                left = middle2 + 1;
                continue;
            }

            left = middle1 + 1;
            right = middle2 - 1;
        }

        return -1;
    }
}

package algorithm.sort.quick;

public class QuickSort {

    public void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private void sort(int[] array, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }

        int boundary = partition(array, startIndex, endIndex);
        sort(array, startIndex, boundary - 1);
        sort(array, boundary + 1, endIndex);
    }

    private int partition(int[] array, int startIndex, int endIndex) {
        int pivot = array[endIndex];
        int boundary = startIndex - 1;

        for (int i = startIndex; i <= endIndex; i++) {
            if (array[i] <= pivot) {
                boundary++;
                swap(array, i, boundary);
            }
        }

        return boundary; // Index of the pivot after moving
    }

    private void swap(int[] array, int firstIndex, int secondIndex) {
        int tempValue = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = tempValue;
    }
}

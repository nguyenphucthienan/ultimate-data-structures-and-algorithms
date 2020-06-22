package algorithm.bubblesort;

public class BubbleSort {

    public void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean isSorted = true;
            for (int j = 1; j < array.length - i; j++) {
                if (array[j] < array[j - 1]) {
                    isSorted = false;
                    swap(array, j, j - 1);
                }
            }

            if (isSorted) {
                return;
            }
        }
    }

    private void swap(int[] array, int firstIndex, int secondIndex) {
        int tempValue = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = tempValue;
    }
}

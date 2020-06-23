package algorithm.sort.merge;

import java.util.Arrays;

public class MergeSort {

    public void sort(int[] array) {
        if (array.length < 2) {
            return;
        }

        int middle = array.length / 2;
        int[] leftArray = Arrays.copyOfRange(array, 0, middle);
        int[] rightArray = Arrays.copyOfRange(array, middle, array.length);

        sort(leftArray);
        sort(rightArray);

        merge(leftArray, rightArray, array);
    }

    private void merge(int[] leftArray, int[] rightArray, int[] result) {
        int i = 0;
        int j = 0;
        int index = 0;

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                result[index++] = leftArray[i++];
            } else {
                result[index++] = rightArray[j++];
            }
        }

        while (i < leftArray.length) {
            result[index++] = leftArray[i++];
        }

        while (j < rightArray.length) {
            result[index++] = rightArray[j++];
        }
    }
}

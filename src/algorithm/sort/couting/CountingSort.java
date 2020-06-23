package algorithm.sort.couting;

public class CountingSort {

    public void sort(int[] array, int max) {
        int[] counts = new int[max + 1];

        for (int number : array) {
            counts[number]++;
        }

        int index = 0;
        for (int i = 0; i < array.length; i++) {
            for (var j = 0; j < counts[i]; j++) {
                array[index++] = i;
            }
        }
    }
}

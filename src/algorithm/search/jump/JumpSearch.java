package algorithm.search.jump;

public class JumpSearch {

    public int search(int[] array, int target) {
        int blockSize = (int) Math.sqrt(array.length);
        int start = 0;
        int end = start + blockSize;

        while (start < array.length && array[end - 1] < target) {
            start = end;
            end += blockSize;

            if (end > array.length) {
                end = array.length;
            }
        }

        for (int i = start; i < end - 1; i++) {
            if (array[i] == target) {
                return i;
            }
        }

        return -1;
    }
}

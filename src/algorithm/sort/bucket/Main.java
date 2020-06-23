package algorithm.sort.bucket;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] numbers = {7, 3, 1, 4, 6, 2, 3, 5};

        BucketSort bucketSort = new BucketSort();
        bucketSort.sort(numbers, 3);

        System.out.println(Arrays.toString(numbers));
    }
}

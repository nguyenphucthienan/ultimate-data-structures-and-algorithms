package algorithm.search.jump;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] numbers = {7, 3, 1, 4, 6, 2, 5};
        Arrays.sort(numbers);

        JumpSearch jumpSearch = new JumpSearch();
        int index = jumpSearch.search(numbers, 3);

        System.out.println(index);
    }
}

package algorithm.search.linear;

public class Main {

    public static void main(String[] args) {
        int[] numbers = {7, 3, 1, 4, 6, 2, 5};

        LinearSearch linearSearch = new LinearSearch();
        int index = linearSearch.search(numbers, 1);

        System.out.println(index);
    }
}

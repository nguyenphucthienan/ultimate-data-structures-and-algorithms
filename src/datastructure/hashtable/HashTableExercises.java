package datastructure.hashtable;

import java.util.*;

public class HashTableExercises {

    public static void main(String[] args) {
        System.out.println(mostFrequent(new int[]{1, 2, 2, 3, 3, 3, 4}));
        System.out.println(countPairsWithDifference(new int[]{1, 7, 5, 9, 2, 12, 3}, 2));
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    // Find the most repeated element in an datastructure.array of integers.
    // A variation of this exercise is finding the most repeated word in a sentence.
    // Input: [1, 2, 2, 3, 3, 3, 4]
    // Output: 3
    // Time complexity: O(n)
    public static int mostFrequent(int[] numbers) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int number : numbers) {
            int count = map.getOrDefault(number, 0);
            map.put(number, count + 1);
        }

        int max = Integer.MIN_VALUE;
        int result = numbers[0];

        for (var item : map.entrySet()) {
            if (item.getValue() > max) {
                max = item.getValue();
                result = item.getKey();
            }
        }

        return result;
    }

    // Given an datastructure.array of integers, count the number of unique pairs of integers that have difference k.
    // Input: [1, 7, 5, 9, 2, 12, 3], K = 2
    // Output: 4
    // We have four pairs with difference 2: (1, 3), (3, 5), (5, 7), (7, 9).
    // Note that we only want the number of these pairs, not the pairs themselves
    public static int countPairsWithDifference(int[] numbers, int difference) {
        // For a given number (a) and difference (diff), number (b) can be:
        // b = a + diff
        // b = a - diff
        //
        // We can iterate over our datastructure.array of numbers, and for each number,
        // check to see if we have (current + diff) or (current - diff).
        // But looking up items in an datastructure.array is an O(n) operation.
        // With this algorithm, we need two nested loops (one to pick a, and the other to find b).
        // This will be an O(n^2) operation.
        //
        // We can optimize this by using a set. Sets are like hash tables
        // but they only store keys. We can look up a number in constant time.
        // No need to iterate the datastructure.array to find it.
        Set<Integer> set = new HashSet<>();
        for (int number : numbers) {
            set.add(number);
        }

        // Once we're done, we should remove this number from our set
        // so we don't double count it.
        int count = 0;
        for (int number : numbers) {
            if (set.contains(number + difference)) {
                count++;
            }
            if (set.contains(number - difference)) {
                count++;
            }
            set.remove(number);
        }

        return count;
    }

    // Given an datastructure.array of integers, return indices of the two numbers such
    // that they add up to a specific target.
    // Input: [2, 7, 11, 15] - Target = 9
    // Output: [0, 1] (because 2 + 7 = 9)
    // Assume that each input has exactly one solution, and you may not use the same element twice
    public static int[] twoSum(int[] numbers, int target) {
        // This problem is a variation of the previous problem (countPairsWithDifference).
        // If a + b = target, then b = target - a.
        //
        // So we iterate our datastructure.array, and pick (a). Then,
        // we check to see if we have (b) in our datastructure.array.
        // Similar to the last problem, this would be an O(n^2)
        // operation, because we'll need two nested loops for looking up (b).
        //
        // We can optimize this by using a hash table. In this
        // hash table, we store numbers and their indexes.
        //
        // There is no need to store all the numbers in the hash table first.
        // If we find two numbers that add up to the target, we simply return their indexes.
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(numbers[i], i);
        }

        return null;
    }
}

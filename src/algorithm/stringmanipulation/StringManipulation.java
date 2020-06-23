package algorithm.stringmanipulation;

import java.util.*;

public class StringManipulation {

    public static int countVowels(String string) {
        if (string == null) {
            return 0;
        }

        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int count = 0;

        for (char character : string.toLowerCase().toCharArray()) {
            if (vowels.contains(character)) {
                count++;
            }
        }

        return count;
    }

    public static String reverse(String string) {
        if (string == null) {
            return null;
        }

        StringBuilder reversed = new StringBuilder();
        for (int i = string.length() - 1; i >= 0; i--) {
            reversed.append(string.charAt(i));
        }

        return reversed.toString();
    }

    public static String reverseWords(String string) {
        if (string == null) {
            return null;
        }

        String[] words = string.trim().split(" ");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    public static boolean isRotation(String firstString, String secondString) {
        if (firstString == null || secondString == null || firstString.length() != secondString.length()) {
            return false;
        }

        return (firstString + firstString).contains(secondString);
    }

    public static String removeDuplicates(String string) {
        if (string == null) {
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder();
        Set<Character> seen = new HashSet<>();

        for (char character : string.toCharArray()) {
            if (!seen.contains(character)) {
                seen.add(character);
                stringBuilder.append(character);
            }
        }

        return stringBuilder.toString();
    }

    public static char getMaxOccurringCharacter(String string) {
        if (string == null || string.isBlank()) {
            throw new IllegalArgumentException();
        }

        Map<Character, Integer> frequencies = new HashMap<>();
        for (char character : string.toCharArray()) {
            if (frequencies.containsKey(character)) {
                frequencies.replace(character, frequencies.get(character) + 1);
            } else {
                frequencies.put(character, 1);
            }
        }

        Iterator<Character> keyIterator = frequencies.keySet().iterator();
        char maxKey = keyIterator.next();
        while (keyIterator.hasNext()) {
            char key = keyIterator.next();
            if (frequencies.get(key) > frequencies.get(maxKey)) {
                maxKey = key;
            }
        }

        return maxKey;
    }

    public static String capitalize(String sentence) {
        if (sentence == null) {
            return null;
        }

        if (sentence.trim().isEmpty()) {
            return "";
        }

        String[] words = sentence
                .trim()
                .replaceAll(" +", " ")
                .split(" ");

        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
        }

        return String.join(" ", words);
    }

    // O(n log n)
    public static boolean areAnagramsSorting(String firstString, String secondString) {
        if (firstString == null || secondString == null || firstString.length() != secondString.length()) {
            return false;
        }

        char[] firstArray = firstString.toCharArray();
        char[] secondArray = secondString.toCharArray();

        Arrays.sort(firstArray);
        Arrays.sort(secondArray);

        return Arrays.equals(firstArray, secondArray);
    }

    // O(n)
    public static boolean areAnagramsHistogramming(String firstString, String secondString) {
        if (firstString == null || secondString == null || firstString.length() != secondString.length()) {
            return false;
        }

        Map<Character, Integer> frequencies = new HashMap<>();

        for (char character : firstString.toCharArray()) {
            if (frequencies.containsKey(character)) {
                frequencies.replace(character, frequencies.get(character) + 1);
            } else {
                frequencies.put(character, 1);
            }
        }

        for (char character : secondString.toCharArray()) {
            if (frequencies.containsKey(character)) {
                frequencies.replace(character, frequencies.get(character) - 1);
            } else {
                frequencies.put(character, 1);
            }
        }

        for (int value : frequencies.values()) {
            if (value != 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPalindrome(String string) {
        for (int i = 0; i < string.length() / 2; i++) {
            if (string.charAt(i) != string.charAt(string.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }
}

package algorithm.stringmanipulation;

public class Main {

    public static void main(String[] args) {
        String countVowelsString = "Hello World";
        System.out.println(StringManipulation.countVowels(countVowelsString));

        String reverseString = "Hello World";
        System.out.println(StringManipulation.reverse(reverseString));

        String reverseWordsString = "The sky is blue";
        System.out.println(StringManipulation.reverseWords(reverseWordsString));

        System.out.println(StringManipulation.isRotation("ABCD", "BCDA"));

        String removeDuplicatesString = "Hello World";
        System.out.println(StringManipulation.removeDuplicates(removeDuplicatesString));

        String getMaxOccurringCharacterString = "Hello World";
        System.out.println(StringManipulation.getMaxOccurringCharacter(getMaxOccurringCharacterString));

        String capitalizeString = "hElLo wOrlD";
        System.out.println(StringManipulation.capitalize(capitalizeString));

        System.out.println(StringManipulation.areAnagramsSorting("ABCD", "DACB"));
        System.out.println(StringManipulation.areAnagramsHistogramming("ABCD", "DACB"));

        String palindromeString = "ABCDCBA";
        System.out.println(StringManipulation.isPalindrome(palindromeString));
    }
}

package hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharacterFinder {

    public static char findFirstNonRepeatingCharacter(String string) {
        Map<Character, Integer> map = new HashMap<>();

        char[] characters = string.toLowerCase().toCharArray();
        for (char character : characters) {
            int count = map.getOrDefault(character, 0);
            map.put(character, count + 1);
        }

        for (char character : characters) {
            if (map.get(character) == 1) {
                return character;
            }
        }

        return Character.MIN_VALUE;
    }

    public static char findFirstRepeatingCharacter(String string) {
        Set<Character> set = new HashSet<>();

        for (char character : string.toLowerCase().toCharArray()) {
            if (set.contains(character)) {
                return character;
            }

            set.add(character);
        }

        return Character.MIN_VALUE;
    }
}

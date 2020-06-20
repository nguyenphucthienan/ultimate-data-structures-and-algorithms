package hashtable;

public class Main {

    public static void main(String[] args) {
        System.out.println(CharacterFinder.findFirstNonRepeatingCharacter("Hello world"));
        System.out.println(CharacterFinder.findFirstRepeatingCharacter("Hello world"));

        HashTableChaining hashTableChaining = new HashTableChaining();
        hashTableChaining.put(6, "A");  // Index: 1
        hashTableChaining.put(8, "B");  // Index: 3
        hashTableChaining.put(11, "C"); // Index: 1
        hashTableChaining.put(6, "A+"); // Index: 1
        System.out.println(hashTableChaining.get(6));
        System.out.println(hashTableChaining.get(11));

        HashTableLinearProbing hashTableLinearProbing = new HashTableLinearProbing();
        hashTableLinearProbing.put(6, "A");  // Index: 1
        hashTableLinearProbing.put(8, "B");  // Index: 3
        hashTableLinearProbing.put(11, "C"); // Index: 1
        hashTableLinearProbing.put(6, "A+"); // Index: 1
        System.out.println(hashTableLinearProbing.get(6));
        System.out.println(hashTableLinearProbing.get(11));
    }
}

package trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {

    private class Node {
        private char value;
        private boolean isEndOfWord;
        private final Map<Character, Node> children = new HashMap<>();

        public Node(char value) {
            this.value = value;
        }

        public boolean hasChildren() {
            return !children.isEmpty();
        }

        public boolean hasChild(char character) {
            return children.containsKey(character);
        }

        public Node getChild(char character) {
            return children.get(character);
        }

        public void addChild(char character) {
            children.put(character, new Node(character));
        }

        public void removeChild(char character) {
            children.remove(character);
        }

        public Node[] getChildren() {
            return children.values().toArray(new Node[0]);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }

    private final Node root = new Node(' ');

    public void insert(String word) {
        Node current = root;

        for (char character : word.toCharArray()) {
            if (!current.hasChild(character)) {
                current.addChild(character);
            }

            current = current.getChild(character);
        }

        current.isEndOfWord = true;
    }

    public void remove(String word) {
        if (word == null) {
            return;
        }

        remove(root, word, 0);
    }

    private void remove(Node node, String word, int index) {
        if (index == word.length()) {
            node.isEndOfWord = false;
            return;
        }

        char character = word.charAt(index);
        Node child = node.getChild(character);

        if (child == null) {
            return;
        }

        remove(child, word, index + 1);

        if (!child.hasChildren() && !child.isEndOfWord) {
            node.removeChild(character);
        }
    }

    public boolean contains(String word) {
        if (word == null) {
            return false;
        }

        Node current = root;
        for (char character : word.toCharArray()) {
            if (!current.hasChild(character)) {
                return false;
            }

            current = current.getChild(character);
        }

        return current.isEndOfWord;
    }

    public boolean containsRecursive(String word) {
        if (word == null) {
            return false;
        }

        return containsRecursive(root, word, 0);
    }

    private boolean containsRecursive(Node node, String word, int index) {
        if (index == word.length()) {
            return node.isEndOfWord;
        }

        if (node == null) {
            return false;
        }

        char character = word.charAt(index);
        Node child = node.getChild(character);

        if (child == null) {
            return false;
        }

        return containsRecursive(child, word, index + 1);
    }

    public void traverse() {
        traverse(root);
    }

    private void traverse(Node node) {
        for (Node child : node.getChildren()) {
            traverse(child);
        }

        // Post-order: visit the root last
        System.out.println(node.value);
    }

    public List<String> findWords(String prefix) {
        List<String> words = new ArrayList<>();
        Node lastNode = findLastNodeOf(prefix);
        findWords(lastNode, prefix, words);
        return words;
    }

    private void findWords(Node node, String prefix, List<String> words) {
        if (node == null) {
            return;
        }

        if (node.isEndOfWord) {
            words.add(prefix);
        }

        for (Node child : node.getChildren()) {
            findWords(child, prefix + child.value, words);
        }
    }

    private Node findLastNodeOf(String prefix) {
        if (prefix == null) {
            return null;
        }

        Node current = root;

        for (char character : prefix.toCharArray()) {
            Node child = current.getChild(character);
            if (child == null) {
                return null;
            }

            current = child;
        }

        return current;
    }

    public int countWords() {
        return countWords(root);
    }

    private int countWords(Node node) {
        int total = 0;

        if (node.isEndOfWord) {
            total++;
        }

        for (Node child : node.getChildren()) {
            total += countWords(child);
        }

        return total;
    }

    // We add these words to a trie and walk down the trie.
    // If a node has more than one child, that's where these words deviate.
    // Try this with "can", "canada", "care" and "cab".
    // You'll see that these words deviate after "ca".
    //
    // So, we keep walking down the tree as long as
    // the current node has only one child.
    //
    // One edge cases we need to count is when two words are in the same branch
    // and don't deviate. For example "can" and "canada".
    // In this case, we keep walking down to the end
    // because every node (except the last node) has only one child.
    // But the longest common prefix here should be "can", not "canada".
    // So, we should find the shortest word in the list first.
    // The maximum number of characters we can include in the prefix
    // should be equal to the length of the shortest word.
    public static String longestCommonPrefix(String[] words) {
        if (words == null) {
            return "";
        }

        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        int maxCharacters = getShortest(words).length();
        Node current = trie.root;
        StringBuilder prefix = new StringBuilder();

        while (prefix.length() < maxCharacters) {
            Node[] children = current.getChildren();
            if (children.length != 1) {
                break;
            }
            current = children[0];
            prefix.append(current.value);
        }

        return prefix.toString();
    }

    private static String getShortest(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }

        String shortest = words[0];
        for (String word : words) {
            if (word.length() < shortest.length()) {
                shortest = word;
            }
        }

        return shortest;
    }
}

package datastructure.trie;

public class Main {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("car");
        trie.insert("cat");
        trie.insert("card");
        trie.insert("care");
        trie.insert("careful");
        trie.traverse();

        System.out.println(trie.findWords("car"));
        System.out.println(Trie.longestCommonPrefix(new String[]{"cat", "car", "care"}));
    }
}

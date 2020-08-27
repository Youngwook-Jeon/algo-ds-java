package datastructure;

public class Trie {

    static final int ALPHABET_SIZE = 26;

    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                children[i] = null;
            }
        }
    }

    static TrieNode root;

    static void insert(String key) {
        int level;
        int length = key.length();
        int index;

        TrieNode pCrawl = root;

        for (level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();

            pCrawl = pCrawl.children[index];
        }

        pCrawl.isEndOfWord = true;
    }

    static boolean search(String key) {
        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;

        for (level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';

            if (pCrawl.children[index] == null)
                return false;

            pCrawl = pCrawl.children[index];
        }

        return (pCrawl != null && pCrawl.isEndOfWord);
    }

    // Returns true if root has no children, else false
    static boolean isEmpty(TrieNode node) {
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if (node.children[i] != null) return false;
        }

        return true;
    }

    static TrieNode remove(TrieNode node, String key, int depth) {
        if (node == null) return null;

        if (depth == key.length()) {
            if (node.isEndOfWord)
                node.isEndOfWord = false;
            if (isEmpty(node)) node = null;

            return node;
        }

        int index = key.charAt(depth) - 'a';
        node.children[index] = remove(node.children[index], key, depth + 1);

        if (isEmpty(node) && !node.isEndOfWord) node = null;

        return node;
    }

    public static void main(String[] args) {
        String[] keys = {"the", "a", "there", "answer", "bye"};
        root = new TrieNode();

        int i;
        for (i = 0; i < keys.length; i++) {
            insert(keys[i]);
        }
        if (search("answer")) System.out.println("it exists!");
        remove(root, "answer", 0);
        if (!search("answer")) System.out.println("it does not exists, now!");

    }
}

/**
 * @author Zeng
 * @date 2020/7/4 22:57
 */
public class Trie {

    boolean isEnd;
    Trie[] trie;

    /** Initialize your data structure here. */
    public Trie() {
        trie = new Trie[26];
        isEnd = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] arr = word.toCharArray();
        Trie root = this;
        for (char ch : arr) {
            if (root.trie[ch - 'a'] == null) {
                root.trie[ch - 'a'] = new Trie();
            }
            root = root.trie[ch - 'a'];
        }
        root.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] arr = word.toCharArray();
        Trie root = this;
        for (char ch : arr) {
            root = root.trie[ch - 'a'];
            if (root == null) return false;
        }
        return root.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] arr = prefix.toCharArray();
        Trie root = this;
        for (char ch : arr) {
            root = root.trie[ch - 'a'];
            if (root == null) return false;
        }
        return true;
    }

    public boolean isEnd() {
        return this.isEnd;
    }

}

import java.util.HashMap;
import java.util.Map;

public class AddSearchWord_leetcode211 {

    static TrieNode root = new TrieNode();

    public static void main(String[] args) {
        addWord("bad");
        addWord("dad");
        addWord("mad");
        System.out.println(root);
        System.out.println(search("mad"));
        System.out.println(search(".cd"));
    }

    /** Adds a word into the data structure. */
    public static void addWord(String word) {
        insert(word);
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public static boolean search(String word) {
        TrieNode curr = root;
        return dfs(word, 0, curr);
    }

    public static boolean dfs(String word, int index, TrieNode curr) {

        if(index == word.length() && curr.isWord)
            return true;

        if(index == word.length())
            return false;

        char ch = word.charAt(index);
        if(ch != '.') {
            if(!curr.children.containsKey(ch)) {
                return false;
            }
            return dfs(word, index+1, curr.children.get(ch));
        }

        if(ch == '.') {
            for(Character key : curr.children.keySet()) {
                if(dfs(word, index+1, curr.children.get(key))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void insert(String word) {

        TrieNode curr = root;
        for(int i=0;i<word.length();i++) {
            char ch = word.charAt(i);
            if(!curr.children.containsKey(ch)) {
                curr.children.put(ch, new TrieNode());
            }
            curr = curr.children.get(ch);
        }
        curr.isWord = true;
    }

    static class TrieNode {
        boolean isWord;
        Map<Character, TrieNode> children;

        TrieNode() {
            children = new HashMap<>();
            isWord = false;
        }

        @Override
        public String toString() {
            return "TrieNode{" +
                    "isWord=" + isWord +
                    ", children=" + children +
                    '}';
        }
    }
}

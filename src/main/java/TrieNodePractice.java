import java.util.HashMap;
import java.util.Map;

public class TrieNodePractice {

    TrieNode root = new TrieNode();


    public void insert(String word) {

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


    class TrieNode {
        boolean isWord;
        Map<Character, TrieNode> children;

        TrieNode() {
            children = new HashMap<>();
            isWord = false;
        }
    }
}

public class Trie {

    private TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;

        for (int i=0;i<word.length();i++) {
            char ch = word.charAt(i);
            if(!curr.containsKey(ch)) {
                curr.put(ch, new TrieNode());
            }
            curr = curr.get(ch);
        }
        curr.setEnd();
    }

    public TrieNode searchPrefix(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++) {
            char ch = word.charAt(i);
            if(curr.containsKey(ch)) {
                curr = curr.get(ch);
            } else {
                return null;
            }
        }
        return curr;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

}

class TrieNode {
    TrieNode[] links;
    boolean isEnd;
    int R= 26;

    TrieNode() {
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch) {
        return links[ch-'a']!=null;
    }

    public TrieNode get(char ch) {
        return links[ch-'a'];
    }

    public void put(char ch, TrieNode node) {
        links[ch-'a'] = node;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class AutoComplete_leetcode642 {

    Trie trie = new Trie();
    TrieNode start = trie.root;
    String newWord = "";
    public AutoComplete_leetcode642(String[] sentences, int[] times) {

        for(int i=0; i<sentences.length;i++) {
            trie.insert(sentences[i], times[1]);
        }
        System.out.println(trie.root.toString());
    }

    public static void main(String[] args) {
        String[] sentences = {"i love you", "island","ironman", "i love leetcode"};
        int[] times = {5,3,2,2};

        AutoComplete_leetcode642 autoComplete_leetcode642 = new AutoComplete_leetcode642(sentences, times);
        System.out.println(autoComplete_leetcode642.input('i'));
        System.out.println(autoComplete_leetcode642.input(' '));
        System.out.println(autoComplete_leetcode642.input('a'));
        System.out.println(autoComplete_leetcode642.input('#'));

        System.out.println(autoComplete_leetcode642.input('i'));

    }

    public List<String> input(char c) {
        if(c != '#') {
            newWord+=c;
            if(start == null) {
                return new ArrayList<>();
            }
            start = trie.getPrefixChar(start, c);
            if(start == null) {
                return new ArrayList<>();
            }
            Map<String, Integer> countMap = start.prefixWordCount;
            System.out.println("countMap : " + countMap.toString());
            PriorityQueue<String> queue = new PriorityQueue<>((a,b) -> countMap.get(b) - countMap.get(a));

            queue.addAll(countMap.keySet());
            List<String> result = new ArrayList<>();
            while(!queue.isEmpty()) {
                result.add(queue.poll());
            }
            return result;
        }

        trie.insert(newWord,1);
        newWord = "";
        start = trie.root;
        return new ArrayList<>();
    }

    class TrieNode {
        Map<String, Integer> prefixWordCount = new HashMap<>();
        Map<Character, TrieNode> children = new HashMap<>();

        @Override
        public String toString() {
            return "TrieNode{" +
                    "prefixWordCount=" + prefixWordCount +
                    ", children=" + children +
                    '}';
        }
    }

    class Trie {
        TrieNode root = new TrieNode();

        public void insert(String word, int times) {
            TrieNode curr = root;

            for(int i=0; i< word.length();i++) {
                char ch = word.charAt(i);
                if(!curr.children.containsKey(ch)) {
                    curr.children.put(ch, new TrieNode());
                }
                curr.children.get(ch).prefixWordCount.put(word, curr.children.get(ch).prefixWordCount.getOrDefault(word,0)+times);
                curr = curr.children.get(ch);
            }
        }

        public TrieNode getPrefixCount(TrieNode start, String prefix) {
            TrieNode curr = start;

            for(int i=0; i< prefix.length();i++) {
                char ch = prefix.charAt(i);
                curr = curr.children.get(ch);
            }
            return curr;
        }

        public TrieNode getPrefixChar(TrieNode start, char prefixChar) {
            if(!start.children.containsKey(prefixChar)) {
                return null;
            }
            return start.children.get(prefixChar);
        }
    }

}

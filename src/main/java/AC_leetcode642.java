import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class AC_leetcode642 {

    Trie trie = new Trie();
    public AC_leetcode642(String[] sentences, int[] times) {
        for(int i=0; i<sentences.length;i++) {
            trie.insert(sentences[i], times[i]);
        }
        System.out.println(trie);
    }

    public static void main(String[] args) {
        String[] sentences = {"i love you", "island","ironman", "i love leetcode"};
        int[] times = {5,3,2,2};

        AC_leetcode642 autoComplete_leetcode642 = new AC_leetcode642(sentences, times);
        System.out.println(autoComplete_leetcode642.input('i'));
        System.out.println(autoComplete_leetcode642.input(' '));
        System.out.println(autoComplete_leetcode642.input('a'));
        System.out.println(autoComplete_leetcode642.input('#'));

        System.out.println(autoComplete_leetcode642.input('i'));
    }
    String prefix ="";
    public List<String> input(char c) {
        if (c != '#') {
            prefix+=c;
            return trie.getPrefixWords(prefix);
        }
        trie.insert(prefix, 1);;
        prefix = "";
        return new ArrayList<>();
    }

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        Map<String, Integer> wordCount = new HashMap<>();
        public String toString() {
            return "TrieNode{" +
                    "prefixWordCount=" + wordCount +
                    ", children=" + children +
                    '}';
        }
    }

    class Trie {
        TrieNode root = new TrieNode();


        public void insert(String str, int times) {
            TrieNode curr = root;

            for(int i=0; i<str.length();i++) {
                char ch = str.charAt(i);
                if(!curr.children.containsKey(ch)) {
                    TrieNode temp = new TrieNode();
                    curr.children.put(ch, temp);
                }
                curr = curr.children.get(ch);
                curr.wordCount.put(str, curr.wordCount.getOrDefault(str, 0)+times);
            }
        }

        public List<String> getPrefixWords(String str) {
            TrieNode curr = root;

            for(int i=0; i<str.length();i++) {
                char ch = str.charAt(i);
                if(!curr.children.containsKey(ch)) {
                    return new ArrayList<>();
                }
                curr = curr.children.get(ch);
            }
            Map<String, Integer> temp = new HashMap<>(curr.wordCount);
            PriorityQueue<String> priorityQueue = new PriorityQueue<>((a,b) -> {
                if(temp.get(b) != temp.get(a)) {
                    return temp.get(b)-temp.get(a);
                }
                return a.compareTo(b);
            });
            priorityQueue.addAll(temp.keySet());
            List<String> result = new ArrayList<>();
            while (!priorityQueue.isEmpty()) {
                result.add(priorityQueue.poll());
            }
            return result;
        }

        @Override
        public String toString() {
            return "Trie{" +
                    "root=" + root +
                    '}';
        }
    }


}

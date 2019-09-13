import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordAbbre_leetcode527 {

    public static void main(String[] args) {
        WordAbbre_leetcode527 obj = new WordAbbre_leetcode527();
        obj.wordsAbbreviation(Arrays.asList("like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion"));
    }

    public List<String> wordsAbbreviation(List<String> words) {
        Map<String, List<String>> abbrevMap = new HashMap<>();
        Map<String, Integer> indexMap = new HashMap<>();

        for(int i = 0; i< words.size();i++) {
            String abbrev = abbrevString(words.get(i),0);
            List<String> list = abbrevMap.getOrDefault(abbrev, new ArrayList<>());
            list.add(words.get(i));
            abbrevMap.put(abbrev, list);
            indexMap.put(words.get(i), i);
        }

        for(String key : abbrevMap.keySet()) {
            List<String> list = abbrevMap.get(key);
            if(list.size() == 1) {
                System.out.println("abbrev: "+key+"  word: "+list.toString());
                continue;
            }
            if(list.size() > 1) {
                TrieNode root = new TrieNode();

                for (String str : list) {
                    TrieNode curr = root;
                    for(int i = 0;i<str.length();i++) {
                        char c = str.charAt(i);
                        if(curr.children[c-'a'] == null) {
                            curr.children[c-'a'] = new TrieNode();
                        }
                        curr.children[c-'a'].count++;
                        curr = curr.children[c-'a'];
                    }
                }

                //filling LCP
                for (String str : list) {
                    TrieNode curr = root;
                    for(int i = 0;i<str.length();i++) {
                        char c = str.charAt(i);
                        if (curr.children[c-'a'].count == 1) {
                            System.out.println("abbrev: "+abbrevString(str, i)+"  word: "+str);
                            break;
                        }
                        curr = curr.children[c-'a'];
                    }
                }

            }
        }
        return null;
    }

    public String abbrevString(String str, int i) {
        if(str.length() <=2) {
            return str;
        }
        int length =  str.length() - i -2;
        String abbrev = str.substring(0, i+1)+(length)+str.charAt(str.length()-1)+"";
        if(abbrev.length() == str.length()) {
            return str;
        }
        return abbrev;
    }

    class TrieNode {
        TrieNode[] children;
        int count;

        TrieNode() {
            children = new TrieNode[26];
            count = 0;
        }
    }
}

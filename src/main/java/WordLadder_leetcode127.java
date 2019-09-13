import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;

public class WordLadder_leetcode127 {

    static int minSteps = Integer.MAX_VALUE;

    public static void main(String[] args) {
        List<String> wordList = new ArrayList<String>(){{
           add("hot");
            add("dot");
            add("dog");
            add("lot");
            add("log");
            add("cog");
        }};
        System.out.println(ladderLength("hit", "cog", wordList));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        ladderLength(beginWord, endWord, wordList, 1);
        ladderBfs(beginWord, endWord, wordList);
        return minSteps == Integer.MAX_VALUE ? 0 : minSteps;
    }

    public static List<List<String>> ladderBfs(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();

        if(wordList == null || wordList.isEmpty())
            return result;
        Queue<List<String>> queue = new LinkedList<>();
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        queue.offer(list);
        int min = Integer.MAX_VALUE;
        Set<String> visited = new HashSet<>();
        int level = 0;
        visited.add(beginWord);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0;i<size;i++) {
                List<String> temp = queue.poll();
                String curr = temp.get(temp.size()-1);
                if(curr.equals(endWord)) {
                    if(level<=min) {
                        min = level;
                        result.add(new ArrayList<>(temp));
                    }
                    continue;
                }
                for(int j=0;j<curr.length();j++) {
                    StringBuilder sb = new StringBuilder(curr);
                    char c = curr.charAt(j);
                    for(char ch='a'; ch<='z';ch++) {
                        sb.setCharAt(j,ch);
                        if(wordList.contains(sb.toString())) {
                            if(!temp.contains(sb.toString())) {
                                temp.add(sb.toString());
                                queue.offer(new ArrayList<>(temp));
                                temp.remove(temp.size()-1);
                            }
                        }
                        sb.setCharAt(j, c);
                    }
                }
            }
            if(min != Integer.MAX_VALUE) {
                System.out.println(result.toString());
                break;
            }
            level++;
        }
        return result;
    }

    public static void ladderLength(String beginWord, String endWord, List<String> wordList, int count) {

        System.out.println(beginWord+" "+endWord+ " "+wordList.toString()+" "+count);
        if(beginWord.equals(endWord)) {
            System.out.println("final");
            minSteps = Math.min(minSteps, count);
            return;
        }
        for(int i=0;i<beginWord.length();i++) {
            for(char c='a'; c<='z';c++) {
                String str ="";
                if(i==0) {
                    str = c+beginWord.substring(i+1);
                } else {
                    str = beginWord.substring(0,i)+c+beginWord.substring(i+1);
                }
                if(wordList.contains(str)) {
                    wordList.remove(str);
                    ladderLength(str, endWord, wordList, count+1);
                    wordList.add(str);
                }
            }
        }
    }
}

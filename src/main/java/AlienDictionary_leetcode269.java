import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;

public class AlienDictionary_leetcode269 {

    public static void main(String[] args) {
        String[] words = {    "z",
                "x",
                "z"};
//        System.out.println(alienOrder(words));
        StringBuilder str = new StringBuilder();
        int a = 6;
        int b = 10;
        System.out.println(Integer.toBinaryString(3));
        System.out.println(Integer.toBinaryString(5));
        System.out.println(Integer.toBinaryString(a^b));
        System.out.println(Integer.toBinaryString(a&-a) + " "+(a&-a));
        System.out.println(Integer.toBinaryString(a&(-a)));

        System.out.println("6 "+Integer.toBinaryString(6)+"  "
                +Integer.toBinaryString(6&(6-1))+"  "
                +Integer.highestOneBit(6)+"  "
                +Integer.lowestOneBit(6)+" "
                +Integer.bitCount(6));


    }

    public static String alienOrder(String[] words) {

        Map<Character, Integer> indegree = new HashMap<>();
        Map<Character, List<Character>> adjacencyList = new HashMap<>();

        for(String s: words){
            for(char c: s.toCharArray()){
                indegree.put(c,0);
            }
        }

        for(int i=0;i<words.length-1;i++) {
            for(int j=0;j<words[i].length();j++) {
                char c= words[i].charAt(j);
                if(j<words[i+1].length() && words[i].charAt(j) != words[i+1].charAt(j)) {
                    char d = words[i+1].charAt(j);
                    List<Character> list = adjacencyList.getOrDefault(c, new ArrayList<>());
                    list.add(words[i+1].charAt(j));
                    adjacencyList.put(c, list);
                    indegree.put(d, indegree.getOrDefault(d, 0)+1);
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for(Character c : indegree.keySet()) {
            if(indegree.get(c) == 0) {
                queue.add(c);
            }
        }

        if(queue.isEmpty())
            return "";

        String result = "";
        while(!queue.isEmpty()) {
            char c = queue.poll();
            result+=c;
            if(!adjacencyList.containsKey(c))
                continue;
            for(Character neighbour : adjacencyList.get(c)) {
                indegree.put(neighbour, indegree.get(neighbour)-1);
                if(indegree.get(neighbour) == 0)
                    queue.add(neighbour);
            }
        }

        if(result.length() != indegree.size())
            return "";

        System.out.println(result);
        return result;

    }





}

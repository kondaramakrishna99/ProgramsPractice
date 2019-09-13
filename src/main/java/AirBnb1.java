import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class AirBnb1 {

    public static void main(String[] args) {
//        System.out.println(missingWords("I am using HackerRank to improve programming", "am HackerRank to improve").toString());
        List<Integer> list = Arrays.asList(0,2,4,3,1);
        maxDownSequences1(list);
    }

    public static long maxDownSequences1(List<Integer> prices) {

        TreeSet<Integer> leftSet = new TreeSet<>();
        TreeSet<Integer> rightSet = new TreeSet<>();

        leftSet.add(prices.get(0));
        for(int i=1; i<prices.size();i++) {
            rightSet.add(prices.get(i));
        }
        int count = 0;
        for(int i=1; i<prices.size(); i++) {
           rightSet.remove(prices.get(i));
           int higherSetSize = leftSet.tailSet(prices.get(i)).size();
           int lowerSetSize = rightSet.headSet(prices.get(i)).size();
           count+=higherSetSize*lowerSetSize;
           leftSet.add(prices.get(i));
        }
        return count;
    }

        public static long maxDownSequences(List<Integer> prices) {
        // Write your code here
        if (prices == null || prices.size()<3) {
            return 0;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> b-a);
        for (int i : prices) {
            queue.add(i);
        }
        int size = prices.size();
        int count = 0;
        for (int i=0; i <= size-3; i++) {
            queue.remove(prices.get(i));
            PriorityQueue<Integer> temp = new PriorityQueue<>((a,b) -> b-a);
            temp.addAll(queue);
            for (int j=i+1; j<=size-2; j++) {
                if(prices.get(j) >= prices.get(i)) {
                    temp.remove(prices.get(j));
                    continue;
                }
                temp.remove(prices.get(j));
                while (!temp.isEmpty() && temp.peek() >= prices.get(j)) {
                    temp.poll();
                }
                count+=temp.size();
            }
        }
        return count;
    }

    public static List<String> missingWords(String s, String t) {
        // Write your code here
        List<String> result  = new ArrayList<>();

        if(s == null || s.length() == 0) {
            return result;
        }

        if(t == null || t.length() == 0) {
            return Arrays.asList(s.split(" "));
        }

        String[] sWords = s.trim().split(" ");
        String[] tWords = t.trim().split(" ");

        int i = 0;
        int j = 0;
        while (j < tWords.length && i < sWords.length) {
            if(sWords[i].equals(tWords[j])) {
                i++;
                j++;
                continue;
            }
            result.add(sWords[i]);
            i++;
        }
        while (i < sWords.length) {
            result.add(sWords[i++]);
        }
        return result;
    }
}

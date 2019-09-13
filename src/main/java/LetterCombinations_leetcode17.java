import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LetterCombinations_leetcode17 {

    public static void main(String[] args) {
        System.out.println(letterCombinationsUsinQueue("23"));
    }

    public static List<String> letterCombinations(String digits) {
        String[] mappings = new String[]{"-", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        res.add("");

        for(int i=0;i<digits.length();i++) {
            String letters = mappings[Character.getNumericValue(digits.charAt(i))];
            List<String> newRes = new ArrayList<>();
            for(int j=0;j<letters.length();j++) {
                char c = letters.charAt(j);
                for(int k=0;k<res.size();k++) {
                    newRes.add(res.get(k)+c);
                }
            }
            res = newRes;
        }
        return res;
    }

    public static List<String> letterCombinationsUsinQueue(String digits) {
        String[] mappings = new String[]{"-", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        Queue<String> queue = new LinkedList<>();
        queue.offer("");
        for(int i=0;i<digits.length();i++) {
            String letters = mappings[Character.getNumericValue(digits.charAt(i))];
            List<String> newRes = new ArrayList<>();
            int size = queue.size();
            for(int j=0;j<size;j++) {
                String polled = queue.poll();
                for(int k=0;k<letters.length();k++) {
                    queue.offer(polled+letters.charAt(k));
                }
            }
        }
        return new ArrayList<>(queue);
    }
}

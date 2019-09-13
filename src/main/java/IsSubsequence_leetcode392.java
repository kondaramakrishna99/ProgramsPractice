import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IsSubsequence_leetcode392 {

    public boolean isSubsequence(String s, String t) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for(int i=0;i<t.length();i++) {
            char c = t.charAt(i);
            List<Integer> list = map.getOrDefault(c, new ArrayList<>());
            list.add(i);
            map.put(c, list);
        }

        int prev = 0;
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c)) {
                return false;
            }
            int j = Collections.binarySearch(map.get(c), prev);
            if(j<0) {
                j = - j -1;
            }
            if(j == map.get(c).size()) {
                return false;
            }
            prev = map.get(c).get(j)+1;
        }
        return true;
    }

    public boolean isSubsequence1(String s, String t) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            List<Integer> list = map.getOrDefault(c,new ArrayList<>());
            list.add(i);
            map.put(c, list);
        }

        int start = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                return false;
            }
            List<Integer> list = map.get(c);
            int lowestIndex = Collections.binarySearch(list, start);
            if (lowestIndex < 0) {
                lowestIndex = -lowestIndex-1;
            }

            if (lowestIndex == list.size()) {
                return false;
            }

            start = list.get(lowestIndex)+1;
        }
        return true;
    }
}

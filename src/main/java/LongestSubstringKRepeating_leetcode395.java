import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestSubstringKRepeating_leetcode395 {

    public static void main(String[] args) {
        System.out.println(longestSubstring1("bbaaacbd", 3));
    }

    public static int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) return 0;
        int max = 0;
        int[] count = new int[26];
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        List<Integer> pos = new ArrayList<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] < k) pos.add(i);
        }
        if (pos.size() == 0) return s.length();
        pos.add(0, -1);
        pos.add(s.length());
        for (int i = 1; i < pos.size(); i++) {
            int start = pos.get(i-1) + 1;
            int end = pos.get(i);
            int next = longestSubstring(s.substring(start, end), k);
            res = Math.max(res, next);
        }
        return res;
    }

    public static int longestSubstring1(String s, int k) {
        if (s == null || s.length() == 0) return 0;

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int start = 0;
        Map<Character, Integer> currMap = new HashMap<Character, Integer>();
        int max = 0;
        for(int i=0;i<s.length();i++) {
            char currChar = s.charAt(i);
            currMap.put(currChar, currMap.getOrDefault(currChar, 0 )+1);
            if(map.get(currChar) >=k ) {
                if(isValid(currMap, k)) {
                    max = Math.max(max, i-start+1);
                }
            } else {
                currMap.remove(currChar);
                while(start < i) {
                    char c = s.charAt(start);
                    currMap.put(c, currMap.get(c)-1);
                    if(currMap.get(c) == 0) {
                        currMap.remove(c);
                    }
                    start++;
                    if(isValid(currMap, k)) {
                        max = Math.max(max, i-start);
                    }
                }
                currMap.clear();
                start = i+1;
            }
        }
        if(isValid(currMap, k)) {
            max = Math.max(max, s.length()-start);
        }
        return max;
    }

    public static boolean isValid(Map<Character, Integer> map, int k) {
        for(Character curr : map.keySet()) {
            if(map.get(curr) < k) {
                return false;
            }
        }
        return true;
    }
}

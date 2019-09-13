import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct_leetcode340 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringKDistinct("aa", 1));
    }

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {

        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int start = 0;
        for(int i=0;i< s.length();i++) {
            char c= s.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);

            while (map.size() > k) {
                char t = s.charAt(start);
                map.put(t, map.get(t)-1);
                if(map.get(t) == 0)
                    map.remove(t);
                start++;
            }

            max = Math.max(max, i - start + 1);
        }
        max = Math.max(max, s.length() - start);
        return max;
    }





































    public int lengthOfLongestSubstringKDistinct1(String s, int k) {
        if (s == null || s.length() == 0)
            return 0;

        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
            if (map.size() <= k) {
                max = Math.max(max, i-left+1);
            }
            while (map.size() > k) {
                char c1 = s.charAt(left);
                map.put(c1, map.get(c1)-1);
                if(map.get(c1) == 0) {
                    map.remove(c1);
                }
                left++;
            }
        }
        max = Math.max(max, s.length()-left);
        return max;
    }
}

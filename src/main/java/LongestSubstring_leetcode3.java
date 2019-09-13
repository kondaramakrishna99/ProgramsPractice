import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstring_leetcode3 {

    public static void main(String[] args) {
        LongestSubstring_leetcode3 obj = new LongestSubstring_leetcode3();
        System.out.println(obj.lengthOfLongestSubstring1("abba"));
    }

    public int lengthOfLongestSubstring(String s) {
        if(s == null) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int i=0;
        Map<Character, Integer> map = new HashMap<>();
        int maxLength =0;
        for (int j=0; j<s.length();j++) {
            if(map.containsKey(s.charAt(j))) {
                i = Math.max(i,map.get(s.charAt(j))+1);
            }
            maxLength = Math.max(maxLength, j-i+1);
            map.put(s.charAt(j), j);
        }
        return maxLength;
    }

    public int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }


}

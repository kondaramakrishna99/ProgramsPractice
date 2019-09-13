import java.util.HashMap;
import java.util.Map;

public class LongestSubstringTwoDistinct_leetcode159 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringTwoDistinct("ccaabbb"));
    }


    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left=0;
        int max= 0;
        for(int i=0;i<s.length();i++) {
            char c= s.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
            while(map.size() > 2) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar)-1);
                if(map.get(s.charAt(left)) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }
            max = Math.max(max, i-left+1);
            System.out.println(map.toString());
        }
        return max;
    }
}

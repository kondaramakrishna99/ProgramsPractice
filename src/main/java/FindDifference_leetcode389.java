import java.util.Map;
import java.util.HashMap;
public class FindDifference_leetcode389 {

    public static void main(String[] args) {

    }

    public static char findTheDifference(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();

        for(char c : s.toCharArray()) {
            sMap.put(c, sMap.getOrDefault(c,0) + 1);
        }

        for(char c : t.toCharArray()) {
            if(!sMap.containsKey(c)) {
                return c;
            }
            sMap.put(c, sMap.get(c) - 1);
            if(sMap.get(c) == 0) {
                sMap.remove(c);
            }
        }
        return 'a';
    }
}

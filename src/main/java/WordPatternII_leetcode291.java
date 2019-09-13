import java.util.HashMap;
import java.util.Map;

public class WordPatternII_leetcode291 {

    public static void main(String[] args) {
        System.out.println(wordPatternMatch("aaaa", "asdasdasdasd"));
    }

    public static boolean wordPatternMatch(String pattern, String str) {
        return dfs(pattern, str, 0,0, new HashMap<>());
    }

    public static boolean dfs(String pattern, String str, int i, int j, Map<String, String> map) {
        if(i == pattern.length() && j == str.length()) {
            return true;
        }

        if(i == pattern.length() || j == str.length()) {
            return false;
        }

        String ch = pattern.charAt(i)+"";
        if(map.containsKey(ch)) {
            if(str.startsWith(map.get(ch), j)) {
                if(dfs(pattern, str, i+1, j+map.get(ch).length(), map)) {
                    return true;
                }
            }
            return false;
        }
        for(int k=j+1; k<=str.length();k++) {
            map.put(ch+"", str.substring(j,k));
            if(dfs(pattern, str, i+1, j+map.get(ch+"").length(), map)) {
                return true;
            }
            map.remove(ch+"");
        }
        return false;
    }

}

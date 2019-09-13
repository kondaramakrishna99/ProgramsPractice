import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class AllAnagrams_leetcode438 {

    public static void main(String[] args) {
//        System.out.println(findAnagrams("abab", "ab"));
        String str = "F?1:T?4:5";
        StringTokenizer tokenizer = new StringTokenizer(str, "?:", true);
        List<String> list = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            list.add(tokenizer.nextToken());
        }
        System.out.println(list.toString());
    }

    public static List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i< p.length();i++) {
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        Map<Character, Integer> smap = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for(int i=0;i<s.length();i++) {
            char c= s.charAt(i);
            smap.put(c, smap.getOrDefault(c, 0)+1);

            if(i>=p.length()) {
                char temp = s.charAt(i-p.length());
                smap.put(temp, smap.get(temp)-1);
                if(smap.get(temp) == 0)
                    smap.remove(temp);
            }

            if(smap.equals(map)) {
                result.add(i-p.length()+1);
            }
        }

        return result;
    }
}

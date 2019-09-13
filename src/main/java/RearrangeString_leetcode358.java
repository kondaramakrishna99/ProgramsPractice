import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class RearrangeString_leetcode358 {

    public static void main(String[] args) {
        System.out.println(rearrangeString("aabbcc", 3));
    }

    public static String rearrangeString(String s, int k) {

        if (k <= 1 || s == null || s.length() <= 1)
            return s;

        Map<Character, Integer> map  = new HashMap<>();
        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        PriorityQueue<Character> queue = new PriorityQueue<>((a,b) -> {
            int p = map.get(b) - map.get(a);
            if (p == 0)
                return a -b ;
            return p;
        });
        queue.addAll(map.keySet());
        String result = "";
        while(!queue.isEmpty()) {
            int i = 0;
            int size = queue.size();
            for(i=0;i < Math.min(k, size);i++) {
                Character c = queue.poll();
                result += c;
                map.put(c, map.get(c)-1);
                if (map.get(c) == 0) {
                   map.remove(c);
                }
            }

            if (i < k) {
                if(map.isEmpty())
                    return result;
                else
                    return "";
            }
            queue.clear();
            queue.addAll(map.keySet());
        }
        if(map.isEmpty())
            return result;
        return "";
    }
}

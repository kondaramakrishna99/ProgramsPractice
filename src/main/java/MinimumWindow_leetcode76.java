import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumWindow_leetcode76 {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("two", 2);
        map.put("one", 1);

        Map<String, Integer> map1 = new HashMap<>();
        map1.put("two", 2);
        map1.put("one", 1);

        System.out.println(map.equals(map1));

        String str = "1+1i2t";
        System.out.println(Arrays.toString(str.split("[\\+i]")));
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        for(char c:t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        int left = 0;
        Map<Character, Integer> tempMap = new HashMap<>();
        int minLength = s.length()+1;
        int minLeft = 0;
        int count=0;
        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, map.get(c)-1);
                if(map.get(c)>=0)
                    count++;

                while (count == t.length()) {
                    if(i-left+1 < minLength) {
                        minLength = i-left+1;
                        minLeft = i;
                    }
                    if (map.containsKey(s.charAt(left))) {
                        map.put(s.charAt(left), map.get(s.charAt(left))+1);
                        if(map.get(s.charAt(left))>0)
                            count--;
                    }
                    left++;
                }
            }
        }

        if(minLength > s.length()) {
            return "";
        }

        return s.substring(minLeft, minLeft+minLength);
    }

}

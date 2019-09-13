import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings_leetcode249 {

    public static void main(String[] args) {
        System.out.println(groupStrings(new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"}));
    }

    public static List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map =  new HashMap<>();
        for(String str : strings) {
            String temp = "";
            int diff = str.charAt(0) - 'a';
            for(int i=0; i< str.length();i++) {
                char ch = str.charAt(i);
                char transform = (char)(ch-diff);
                if(transform<'a') {
                    transform+=26;
                }
                temp+=transform;
            }
            System.out.println(str+"->"+temp);
            if(!map.containsKey(temp)) {
                map.put(temp, new ArrayList<>());
            }
            map.get(temp).add(str);
        }
        System.out.println(map.toString());
        return new ArrayList<>(map.values());
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams_leetcode49 {

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
//        permute_iterative(new int[]{1,2,3});

    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List <String> > map = new HashMap<>();

        for(String str:strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String sortStr = new String(array);
            List<String> list = map.getOrDefault(sortStr, new ArrayList<>());
            list.add(str);
            map.put(sortStr, list);
        }

        System.out.println(map.toString()+ "  "+map.values());
        return new ArrayList<>(map.values());
    }
}

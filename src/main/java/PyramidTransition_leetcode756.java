import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PyramidTransition_leetcode756 {

    public static void main(String[] args) {

        String bottom = "CBDDA";
        List<String> allowed = Arrays.asList("ACC","ACA","AAB","BCA","BCB","BAC","BAA","CAC","BDA","CAA","CCA","CCC","CCB","DAD","CCD","DAB","ACD","DCA","CAD","CBB","ABB","ABC","ABD","BDB","BBC","BBA","DDA","CDD","CBC","CBA","CDA","DBA","ABA");
        System.out.println(pyramidTransition(bottom, allowed));
    }

    public static boolean pyramidTransition(String bottom, List<String> allowed) {

        Map<String, List<String>> map = new HashMap<>();
        for(int i=0; i<allowed.size(); i++) {
            String word = allowed.get(i);
            map.putIfAbsent(word.substring(0,2), new ArrayList<>());
            map.get(word.substring(0,2)).add(word.substring(2));
        }
        System.out.println(map.toString());
        return helper(bottom, map);
    }

    public static boolean helper(String bottom, Map<String, List<String>> map) {
        if(bottom.length() ==1)
            return true;

        System.out.println(bottom);
        if(!isValidBase(bottom, map)) {
            System.out.println("not valid: "+ bottom);
            return false;
        }
        System.out.println("valid: "+ bottom);
        List<String> nextBottom = new ArrayList<>();
        dfs(bottom, map, "", 0, nextBottom);
        System.out.println(nextBottom.toString());
        for(String str : nextBottom) {
            if (helper(str, map)) {
                return true;
            }
        }
        return false;
    }

    public static void dfs(String bottom, Map<String, List<String>> map, String curr, int index, List<String> nextBottom) {
        if (index == bottom.length()-1) {
            nextBottom.add(curr);
            return;
        }

        String word = bottom.substring(index, index+2);
        List<String> list = map.get(word);
        for(String str : list) {
            dfs(bottom, map, curr+str,index+1, nextBottom);
        }
    }

    public static boolean isValidBase(String bottom, Map<String, List<String>> map) {

        for(int i=0; i< bottom.length()-1;i++) {
            String word = bottom.substring(i, i+2);
            if(!map.containsKey(word)) {
                return false;
            }
        }
        return true;
    }



}

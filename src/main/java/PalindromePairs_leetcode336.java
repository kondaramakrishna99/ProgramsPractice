import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePairs_leetcode336 {

    public static void main(String[] args) {
        String[] words = new String[]{"abcd","dcba","lls","s","sssll"};
        for(int i=0;i<=words[0].length();i++) {
            System.out.println(i+ ": "+ words[0].substring(0,i));
        }
        System.out.println();
//        System.out.println(palindromePairs(words));

    }

    public static List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<words.length; i++) {
            map.put(words[i], i);
        }
        List<List<Integer>> result = new ArrayList<>();

        for (int i=0 ;i<words.length; i++) {
            String str = words[i];
            String revStr = new StringBuilder(str).reverse().toString();
            if (map.containsKey(revStr)) {
                if (i != map.get(revStr)) {
                    result.add(Arrays.asList(i, map.get(revStr)));
                }
            }
        }

        for(int i=0; i<words.length; i++) {
            String word = words[i];

            for(int j=1;j<word.length(); j++) {
                String leftStr = word.substring(0,j);
                String rightStr = word.substring(j);

                String rightRev = new StringBuilder(rightStr).reverse().toString();
                if (isPalindrome(leftStr) && map.containsKey(rightRev)) {
                    result.add(Arrays.asList(map.get(rightRev), i));
                }

                String leftStrRev = new StringBuilder(leftStr).reverse().toString();
                if (isPalindrome(rightStr) && map.containsKey(leftStrRev)) {
                    result.add(Arrays.asList(i, map.get(leftStrRev)));
                }
            }
        }
        System.out.println(result.toString());
        return result;
    }

    public static boolean isPalindrome(String str) {
        String revStr = new StringBuilder(str).reverse().toString();
        return revStr.equals(str);
    }


}

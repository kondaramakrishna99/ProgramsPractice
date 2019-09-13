import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePartition_leetcode131 {

    public static void main(String[] args) {
        System.out.println(partition("aabaa").toString());
//        System.out.println(partitionIter("aabaa").toString());

    }

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
//        partitionDfs(s, 0, new ArrayList<>(), result);
        System.out.println(partitionDfsMemoization(s, 0, new ArrayList<>(), result));

        return result;
    }

    public static void partitionDfs(String s, int index, List<String> curr, List<List<String>> result) {

        if(index==s.length())
        {
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i=index;i<s.length();i++) {
            String str = s.substring(index, i+1);
            if(isPalindrome(str)) {
                curr.add(str);
                partitionDfs(s, i+1, curr, result);
                curr.remove(curr.size()-1);
            }
        }
    }

    static Map<Integer, List<List<String>>> map = new HashMap<>();

    public static List<List<String>> partitionDfsMemoization(String s, int index, List<String> curr, List<List<String>> result) {

        List<List<String>> currResult = new ArrayList<>();

        if(index==s.length())
        {
            List<String> temp = new ArrayList<>();
            currResult.add(temp);
            return new ArrayList<>(currResult);
        }
        if (map.containsKey(index)) {
            return map.get(index);
        }

        for(int i=index;i<s.length();i++) {
            String str = s.substring(index, i+1);
            if(isPalindrome(str)) {
                curr.add(str);
                List<List<String>> tempResult = partitionDfsMemoization(s, i+1, curr, result);
                if(!tempResult.isEmpty()) {
                    for(List<String> list : tempResult) {
                        List<String> tempList = new ArrayList<>(list);
                        tempList.add(0, str);
                        currResult.add(tempList);
                    }
                }
                curr.remove(curr.size()-1);
            }
        }
        map.put(index, new ArrayList<>(currResult));
        return map.get(index);
    }

    public static boolean isPalindrome(String str) {
        int i=0;
        int j = str.length()-1;

        while(i<=j) {
            if(str.charAt(i)!=str.charAt(j))
                return false;

            i++;
            j--;
        }
        return true;
    }
}

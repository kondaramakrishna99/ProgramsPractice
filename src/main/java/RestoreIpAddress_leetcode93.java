import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddress_leetcode93 {

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135").toString());
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        dfs(s, 0, result, 0, "");
        return result;
    }

    public static void dfs(String s, int index, List<String> result, int count, String temp) {

        if(count==4 && index==s.length()) {
            result.add(new String(temp.substring(0, temp.length()-1)));
            return;
        } else if(count == 4 || index == s.length()) {
            return;
        }

        for(int i=index;i<s.length();i++) {
            String str = s.substring(index, i+1);
//            System.out.println(str);
            long num = Long.parseLong(str);
            if(num > 256 || s.startsWith("0") && str.length()>1)
                break;
            if(num>=0 && num<=255) {
                dfs(s, i+1, result, count+1, temp+str+".");
            }
        }
    }

}

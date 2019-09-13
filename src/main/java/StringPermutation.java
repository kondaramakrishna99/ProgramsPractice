import java.util.ArrayList;
import java.util.List;

public class StringPermutation {

    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("aac");
        List<String> result = new ArrayList<>();
//        permute(str, result, "");
        permuteUnique(str.toString(), result, "", new boolean[str.length()]);
        System.out.println(result.toString());
    }

    public static void permuteUnique(String str, List<String> result, String curr, boolean[] visited) {

        if(curr.length() == str.length()) {
            result.add(curr);
            return;
        }

        for(int i=0; i<str.length();i++) {
            if(visited[i]) {
                continue;
            }

            if(i >0 && str.charAt(i) == str.charAt(i-1) && !visited[i-1]) {
                continue;
            }
            visited[i] = true;
            permuteUnique(str, result, curr+str.charAt(i), visited);
            visited[i] = false;
        }
    }

    public static void permute(StringBuilder str, List<String> result, String curr) {

        if(str.length()==0) {
            result.add(new String(curr));
            return;
        }
        for(int i=0;i<str.length();i++) {
            char ch = str.charAt(i);
            str.deleteCharAt(i);
            permute(str, result, curr+ch);
            str.insert(i, ch);
        }
    }
}

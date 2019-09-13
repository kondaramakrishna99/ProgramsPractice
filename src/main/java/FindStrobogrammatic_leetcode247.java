import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindStrobogrammatic_leetcode247 {

    public static void main(String[] args) {
        FindStrobogrammatic_leetcode247 obj = new FindStrobogrammatic_leetcode247();
        System.out.println(obj.findStrobogrammatic(2));
    }

//    static List<String> result = new ArrayList<>();

    public List<String> findStrobogrammatic(int n) {
        if(n == 1) {
            return Arrays.asList("0", "1", "8");
        }

        List<String> list = new ArrayList<>();;
        if(n%2!=0) {
            list.add("0");
            list.add("1");
            list.add("6");
            list.add("9");
            list.add("8");
        } else {
            list.add("");
        }

        List<String> result = new ArrayList<>();
        dfs(n,n,list, result);
        System.out.println(result);
        return result;
    }

    public void dfs (int n, int m, List<String> list, List<String> result) {
        if(m<0)
            return;
        if(m==0) {
            result.addAll(list);
            return;
        }

        List<String> newList = new ArrayList<>();
        for(String str : list) {
            if(m > 2) {
                newList.add("0"+str+"0");
            }
            newList.add("1"+str+"1");
            newList.add("6"+str+"9");
            newList.add("8"+str+"8");
            newList.add("9"+str+"6");
        }
        dfs(n, m-2, newList, result);
    }
}

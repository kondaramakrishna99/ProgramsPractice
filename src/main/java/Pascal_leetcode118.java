import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pascal_leetcode118 {

    public static void main(String[] args) {
        System.out.println(generate(5).toString());
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows == 0)
            return result;

        List<Integer> row = Arrays.asList(1);
        result.add(row);
        if(numRows==1)
            return result;


        for (int i=2;i<=numRows;i++) {
            List<Integer> prev = result.get(result.size()-1);
            List<Integer> curr = new ArrayList<>();
            curr.add(1);
            for(int j=1;j<i-1;j++) {
                curr.add(prev.get(j)+prev.get(j-1));
            }
            curr.add(1);
            result.add(new ArrayList<>(curr));
        }
        return result;
    }
}

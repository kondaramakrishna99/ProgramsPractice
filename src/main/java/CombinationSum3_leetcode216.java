import java.util.ArrayList;
import java.util.List;

public class CombinationSum3_leetcode216 {

    public static void main(String[] args) {
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        combinationSum3(3, 9, result, curr, 0, 0);
        System.out.println(result.toString());
    }

    public static void combinationSum3(int k, int n, List<List<Integer>> result, List<Integer> curr, int start, int sum) {

        if(k==curr.size()) {
            if (sum == n) {
                result.add(new ArrayList<>(curr));
            }
            return;
        }

        if(curr.size() > k) {
            return;
        }

        for(int i= start+1; i<=9;i++) {
            curr.add(i);
            combinationSum3(k,n, result, curr, i, sum+i);
            curr.remove(curr.size()-1);
        }

    }
}

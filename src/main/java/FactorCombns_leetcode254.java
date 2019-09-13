import java.util.ArrayList;
import java.util.List;

public class FactorCombns_leetcode254 {

    public List<List<Integer>> getFactors(int n) {
        return helper(n, 2);
    }

    private List<List<Integer>> helper(int n, int start) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i=start; n/i >= i; i++) {  // condition n/i >=i used as we don't need to call helper to find factors for lower numbers as those would have been already covered and added to result (avoid duplicate results)
            if (n%i == 0) {
                List<List<Integer>> nextRes = helper(n/i, i); //pass start as i to avoid calculation with lower numbers (avoid repetition)
                for (List<Integer> l : nextRes) {
                    l.add(i); // add the current factor to all the factors of n/i
                }
                List<Integer> t = new ArrayList<Integer>();
                t.add(n/i);
                t.add(i);
                res.add(t); //add [n/i, i] to the current factors list
                res.addAll(nextRes);
            }
        }
        return res;
    }

}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_leetcode39 {

    public static void main(String[] args) {
//        ArrayList<Integer> int1 = new ArrayList<Integer>(){{add(1);add(2);add(3);add(4);}};
//        ArrayList<Integer> int2 = new ArrayList<Integer>(){{add(1);add(2);add(3);add(4);}};
//        System.out.println(int1.equals(int2));
//        List<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
//        result.add(int1);
//        System.out.println(result.contains(int2));

        combinationSum(new int[]{2,3,6,7}, 7);
    }

    public static List<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        List<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        getList(candidates, target, 0, 0, new ArrayList<>(),result);
        System.out.println(result);
        return result;
    }

    public static void getList(int[] candidates, int target, int sum, int index, List<Integer> tempResult, List<ArrayList<Integer>> finalResult) {
        if (sum > target)
            return;

        if (sum == target) {
//            if(finalResult.contains(tempResult))
//                return;
            finalResult.add(new ArrayList<>(tempResult));
            System.out.println(tempResult);
            return;
        }

        for(int i=index;i<candidates.length;i++) {
            if(i!=0 && candidates[i]==candidates[i-1])
                continue;

            int newSum = sum+candidates[i];
            tempResult.add(candidates[i]);
            getList(candidates, target, newSum, i, tempResult, finalResult);
            tempResult.remove(tempResult.size()-1);
        }
    }

    public List<List<Integer>> combinationSum_iterative(int[] cands, int t) {
        Arrays.sort(cands); // sort candidates to try them in asc order
        List<List<List<Integer>>> dp = new ArrayList<>();
        for (int i = 1; i <= t; i++) { // run through all targets from 1 to t
            List<List<Integer>> newList = new ArrayList(); // combs for curr i
            // run through all candidates <= i
            for (int j = 0; j < cands.length && cands[j] <= i; j++) {
                // special case when curr target is equal to curr candidate
                if (i == cands[j]) newList.add(Arrays.asList(cands[j]));
                    // if current candidate is less than the target use prev results
                else for (List<Integer> l : dp.get(i-cands[j]-1)) {
                    if (cands[j] <= l.get(0)) {
                        List cl = new ArrayList<>();
                        cl.add(cands[j]); cl.addAll(l);
                        newList.add(cl);
                    }
                }
            }
            dp.add(newList);
        }
        return dp.get(t-1);
    }
}

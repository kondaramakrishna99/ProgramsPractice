import java.util.ArrayList;
import java.util.List;

public class Combinations_leetcode77 {



    public void permute(List<Integer> nums, int k, int count, List<List<Integer>> result, List<Integer> curr) {

        if (count == k) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i=0;i<nums.size();i++) {
            int num = nums.get(i);
            curr.add(nums.get(i));
            nums.remove(i);
            permute(nums, k, count+1, result, curr);
            nums.add(i, num);
            curr.remove(curr.size()-1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int n : nums){
            int size = result.size();
            for(int i=0; i<size; i++){
                List<Integer> subset = new ArrayList<>(result.get(i));
                subset.add(n);
                result.add(subset);
            }
        }
        return result;
    }
}

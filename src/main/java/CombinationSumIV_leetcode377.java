import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

public class CombinationSumIV_leetcode377 {

    static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,6};
        int target = 12;
        System.out.println(combinationSum4(nums, target));
        LinkedHashSet set = new LinkedHashSet<Integer>();
    }

    public static int combinationSum4(int[] nums, int target) {
        Map<Integer, Integer> map =  new HashMap<>();
        int count = dfs(nums, target, 0, map);
        System.out.println(map.toString());
        return count;
    }

    public static int dfs(int[] nums, int target, int start, Map<Integer, Integer> map) {

        if(map.containsKey(target))
            return map.get(target);

        if(target == 0) {
            return 1;
        }
        if(target < 0)
            return 0;

        int count = 0;
        for(int i=0;i<nums.length;i++) {
            count+=dfs(nums, target-nums[i], i, map);
        }
        map.put(target, count);
        return count;
    }

}

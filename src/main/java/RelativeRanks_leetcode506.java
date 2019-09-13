import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class RelativeRanks_leetcode506 {

    public static void main(String[] args) {
        findRelativeRanks(new int[]{5, 4, 3, 2, 1});
        String str = "hi";
    }

    public static String[] findRelativeRanks(int[] nums) {
        if(nums == null || nums.length == 0) return new String[0];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            map.put(nums[i], i);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(entry);
        }

        Collections.sort(list, (a,b) -> b.getKey() - a.getKey());
        System.out.println(list.toString());

        String[] result = new String[nums.length];
        for(int i = 0; i < list.size(); i++) {
            int index = list.get(i).getValue();
            if(i == 0) {
                result[index] = "Gold Medal";
            } else if (i == 1) {
                result[index] = "Silver Medal";
            } else if (i == 2) {
                result[index] = "Bronze Medal";
            } else  {
                result[index] = (i+1)+"";
            }
        }
        System.out.println(Arrays.toString(result));
        return result;
    }
}

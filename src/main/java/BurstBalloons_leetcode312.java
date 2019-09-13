
import org.apache.commons.codec.digest.DigestUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BurstBalloons_leetcode312 {

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,2,3);
        List<Integer> list2 = Arrays.asList(1, 2,3);
        System.out.println(list1.hashCode() + " "+ DigestUtils.sha256Hex(list1.toString()));
        System.out.println(list2.hashCode() + " "+DigestUtils.sha256Hex(list2.toString()));
        System.out.println(list2.equals(list1));
        int[] nums = {3,1,5,8};
        maxCoins(nums);
    }

    public static int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Map<List<Integer>, Integer> map = new HashMap<>();
        Map<String, Integer> map1 = new HashMap<>();
        System.out.println(dfs1(numList,  map1));
        System.out.println(map1.toString());
        return 0;
    }

    public static int dfs1(List<Integer> nums,  Map<String, Integer> map) {

        String hash = DigestUtils.sha256Hex(nums.toString());

        if(map.containsKey(hash)) {
            System.out.println("map: "+hash);
            return map.get(hash);
        }
        if(nums.size() == 1) {
            map.put(hash, nums.get(0));
            return nums.get(0);
        }
        System.out.println(nums.toString());
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.size();i++) {
            int element = nums.get(i);

            int temp = i == 0 ? element * nums.get(i+1) : i == nums.size()-1 ? element*nums.get(i-1) :
                    element *nums.get(i-1) * nums.get(i+1);
            nums.remove(i);
            max = Math.max(max, temp + dfs1(nums, map));
            nums.add(i, element);
        }
        map.put(hash, max);
        return max;
    }

    public static int dfs(List<Integer> nums,  Map<List<Integer>, Integer> map) {

        if(map.containsKey(nums)) {
            System.out.println("map: "+nums);
            return map.get(nums);
        }
        if(nums.size() == 1) {
            map.put(new ArrayList<>(nums), nums.get(0));
            return nums.get(0);
        }
        System.out.println(nums.toString());
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.size();i++) {
            int element = nums.get(i);

            int temp = i == 0 ? element * nums.get(i+1) : i == nums.size()-1 ? element*nums.get(i-1) :
                    element *nums.get(i-1) * nums.get(i+1);
            nums.remove(i);
            max = Math.max(max, temp + dfs(nums, map));
            nums.add(i, element);
        }
        map.put(new ArrayList<>(nums), max);
        return max;
    }
}


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Threesum_leetcode15 {

    public static void main(String[] args) {
//        Set<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();
//        result.add(new ArrayList<Integer>(){{add(1);add(2);}});
//        result.add(new ArrayList<Integer>(){{add(2);add(1);}});
//        System.out.println(result);
        System.out.println(threeSum1(new int[]{-1,0,1,2,-1,-4}));

    }

    public List<List<Integer>> threeSum(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i =0;i<nums.length;i++) {
            map.put(nums[i], i);
        }
        Set<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();
        for(int i=0;i<nums.length;i++) {
            for(int j=i+1;j<nums.length;j++) {
                int target = -nums[i]-nums[j];
                if(map.containsKey(target) && map.get(target) !=i && map.get(target)!=j) {
//                    result.add();
                }
            }
        }
        return null;
    }

    public static List<List<Integer>> threeSum1(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for(int i=0;i<nums.length-2;i++) {
            int j=i+1;
            int k=nums.length-1;

            if(i>0 && nums[i] == nums[i-1]) {
                continue;
            }

            while(j<k) {
                int sum = nums[i]+nums[j]+nums[k];
                if(sum==0) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    result.add(temp);
                    while(j<k && nums[j+1]==nums[j]) {
                        j++;
                    }
                    while(j<k && nums[k-1]==nums[k]) {
                        k--;
                    }
                    j++;
                    k--;
                } else if(sum<0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                }
            }
        }

        return result;
    }

}

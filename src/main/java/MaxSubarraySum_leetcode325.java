import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MaxSubarraySum_leetcode325 {

    public static void main(String[] args) {

    }

//    public int maxSubArrayLen(int[] nums, int k) {
//
//        Map<Integer, Integer> sums = new HashMap<>();
//        sums.put(-1, 0);
//
//        int sum = 0;
//        for(int i=0; i<nums.length; i++) {
//            sum+=nums[i];
//            sums.put(i, sum);
//        }
//
//        System.out.println(sums.toString());
//
//        TreeMap<Integer, Integer> map = new TreeMap<>();
//        map.put(-1, 0);
//        int total = 0;
//        int max = 0;
//        for(int i=0; i<nums.length; i++) {
//            total+=nums[i];
//            Integer lower = map.ceilingKey(k-total);
//            if(lower != null) {
////                max = Math.max()
//            }
//            map.put(i, total);
//        }
//
//    }
}

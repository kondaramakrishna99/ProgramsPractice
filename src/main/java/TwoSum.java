import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[]{2,1,9,4,4,56,90,3};
        AtomicInteger atomicInteger = new AtomicInteger(0);
        Map<Integer, Integer> map = Arrays.stream(nums).boxed().collect(Collectors.toMap(x -> x, x -> atomicInteger.getAndAdd(1), (x1, x2) ->x1) );
        System.out.println(map);
        System.out.println(twoSum(nums, 8));
        StringBuilder sb = new StringBuilder("abcd");
        sb.replace(0,2, "def");
        System.out.println(sb.toString());
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        Integer[] array = set.toArray(new Integer[set.size()]);
        System.out.println(Arrays.toString(array));
    }

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2 ) {
            return null;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i < nums.length ; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }

        return null;
    }
}

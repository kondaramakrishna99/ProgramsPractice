import java.util.Arrays;

public class MatchSticks_leetcode473 {

    public boolean makesquare(int[] nums) {
        if (nums.length == 0) return false;
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // First jude sum can divide by 4
        if (sum % 4 != 0) {
            return false;
        }
        int width = sum / 4;
        // If any num bigger than width, return false
        for (int num : nums) {
            if (num > width) return false;
        }
        boolean[] used = new boolean[nums.length];
        return dfs(nums, used, 0, 0, width, 0);
    }

    private boolean dfs(int[] nums, boolean[] used, int acc, int start, int target, int count) {
        if (count == 4) {
            // Judge if we use all the nums
            for (int i = 0; i < used.length; i++) {
                if (!used[i]) return false;
            }
            return true;
        } else if (acc > target) {
            return false;
        } else if (acc == target) {
            return dfs(nums, used, 0, 0, target, count + 1);
        } else {
            for (int i = start; i < nums.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    if (dfs(nums, used, acc + nums[i], i + 1, target, count)) return true;
                    used[i] = false;
                }
            }
            return false;
        }
    }

}

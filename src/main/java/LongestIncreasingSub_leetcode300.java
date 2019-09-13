import java.util.Stack;

public class LongestIncreasingSub_leetcode300 {

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length<=1)
            return 1;

        Stack<Integer> stack = new Stack<>();
        stack.push(nums[0]);
        int max = 0;

        for(int i=1;i<nums.length;i++) {
            while (!stack.isEmpty() && stack.peek()<nums[i]) {
                stack.pop();
            }
            stack.push(nums[i]);
            System.out.println(stack.toString());
            max = Math.max(max, stack.size());
        }

        return max;
    }
}

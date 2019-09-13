import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MaximumNumber_leetcode321 {

    public static void main(String[] args) {
        int[] nums = {9, 1, 2, 5, 8, 3};
        System.out.println(maxArray(nums, 6));
    }

    public static List<Integer> maxArray(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<nums.length;i++) {
            if(stack.isEmpty()) {
                stack.push(nums[i]);
                continue;
            }
            if(nums.length - i <= k - stack.size()) {
                stack.push(nums[i]);
                continue;
            }
            int remaining = nums.length - i;

            while (stack.size() + remaining > k) {
                if(stack.peek() <= nums[i])
                    stack.pop();
                else {
                    break;
                }
            }
            if(stack.size() < k)
                stack.push(nums[i]);
        }
        return new ArrayList<>(stack);
    }
}

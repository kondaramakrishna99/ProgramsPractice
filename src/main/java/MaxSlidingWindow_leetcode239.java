import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;
import java.util.LinkedList;

public class MaxSlidingWindow_leetcode239 {

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(maxSlidingWindow(nums,3)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> queue = new LinkedList<>();
        int[] result = new int[nums.length-k+1];
        int index =0;
        for(int i=0;i<nums.length;i++) {

            //remove the nums outside k
            while (!queue.isEmpty() && queue.peekFirst() <= i-k) {
                queue.pollFirst();
            }

            //remove smaller elements
            while (!queue.isEmpty()) {
                if(nums[queue.peekLast()] < nums[i]) {
                    queue.pollLast();
                } else
                    break;
            }

            queue.offerLast(i);
            if(i >= k-1)
                result[index++] = nums[queue.peekFirst()];
            System.out.println(Arrays.toString(result));
        }

        return result;
    }

}

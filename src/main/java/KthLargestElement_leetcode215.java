import java.util.PriorityQueue;
import java.util.TreeSet;

public class KthLargestElement_leetcode215 {

    public static void main(String[] args) {
//        System.out.println(findKthLargest(new int[]{}));
        TreeSet<Integer> set = new TreeSet<>();
        }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((s1,s2) -> s2.compareTo(s1));

        for(int i=0;i<nums.length;i++) {
            queue.offer(nums[i]);
        }

        for(int i=1;i<k;i++) {
            queue.poll();
        }
        return queue.poll();
    }
}

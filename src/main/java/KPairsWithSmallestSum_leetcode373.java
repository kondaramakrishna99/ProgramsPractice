import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KPairsWithSmallestSum_leetcode373 {

    public static void main(String[] args) {
        System.out.println(kSmallestPairs(new int[]{1,7,11}, new int[]{2,4,6}, 3).toString());
    }

    public static List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> nums1[a[0]]+nums2[a[1]]-nums1[b[0]]-nums2[b[1]]);
        List<int[]> result = new ArrayList<>();
        int m = nums1.length;
        int n= nums2.length;
        if (m == 0 || n == 0) return result;
        for(int i=0; i<m;i++) {
            queue.offer(new int[]{i,0});
        }

        while (!queue.isEmpty() && result.size()<k) {
            int[] curr = queue.poll();
            int i = curr[0];
            int j = curr[1];

            result.add(new int[]{nums1[i], nums2[j]});

            if(j<nums2.length-1) {
                queue.offer(new int[]{i, j + 1});
            }
        }
        return result;
    }
}

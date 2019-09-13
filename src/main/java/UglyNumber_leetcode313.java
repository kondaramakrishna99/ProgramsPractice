import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class UglyNumber_leetcode313 {

    public static void main(String[] args) {
        System.out.println(nthSuperUglyNumber(12, new int[]{2,7,13,19}));
    }

    public static int nthSuperUglyNumber(int n, int[] primes) {
        if(n == 0)
            return 1;

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        int[] indexes =  new int[primes.length];
        int[] result = new int[n];
        result[0] = 1;
        Arrays.fill(indexes, 0);

        for(int i=0;i<primes.length;i++) {
            queue.add(primes[i]);
            set.add(primes[i]);
        }
        System.out.println(queue.toString());

        for(int i=1; i<n; i++) {
            result[i] = queue.poll();
            for (int j=0;j<primes.length;j++) {
                if(primes[j]*result[indexes[j]] == result[i]) {
                    indexes[j]++;
                    int val = primes[j]*result[indexes[j]];
                    if(!set.contains(val)) {
                        queue.offer(val);
                        set.add(val);

                    }
                }
            }
            System.out.println(queue.toString());
        }

        return result[n-1];
    }
}

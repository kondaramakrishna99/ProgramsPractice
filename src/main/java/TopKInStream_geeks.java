import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKInStream_geeks {

    public static void main(String[] args) {
        int[] array = {5, 2, 1, 3, 2, 5, 1 };
        System.out.println(Arrays.toString(topK(array, 2)));
    }

    public static int[] topK(int[] array, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i:array) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        System.out.println(map.toString());

        Queue<Integer> priorityQueue = new PriorityQueue<Integer>((a, b) ->
        {
            if (map.get(a) == map.get(b)) {
                return b - a;
            }
            return map.get(a).compareTo(map.get(b));
        });

        for(int i : map.keySet()) {
            priorityQueue.offer(i);
            if(priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        
        System.out.println(priorityQueue.toString());

        int length = Math.min(priorityQueue.size(), k);
        int[] result = new int[length];
        for(int i=0;i<length;i++) {
            result[i] = priorityQueue.poll();
        }
        return result;
    }


}

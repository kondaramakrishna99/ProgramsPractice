import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.LinkedList;
import java.util.Set;

public class networkDelayTime {

    public static void main(String[] args) {
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        System.out.println(networkDelayTime(times, 4, 2));
    }

    public static int networkDelayTime(int[][] times, int N, int K) {

        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for(int[] row : times) {
            Map<Integer, Integer> map = graph.getOrDefault(row[0], new HashMap<>());
            map.put(row[1], row[2]);
            graph.put(row[0], map);

            map = graph.getOrDefault(row[1], new HashMap<>());
            map.put(row[0], row[2]);
            graph.put(row[1], map);
        }

        System.out.println(graph.toString());
        Map<Integer, Integer> distances = new HashMap<>();
        distances.put(K, 0);
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> distances.get(a) - distances.get(b));
        queue.offer(K);
        Set<Integer> visited = new HashSet<>();
        int result =0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            visited.add(curr);
            result+= distances.get(curr);
            System.out.println("polled "+ curr+" distance: "+ distances.get(curr));
            Map<Integer, Integer> edges = graph.get(curr);
            for(int key : edges.keySet()) {
                if(visited.contains(key)) {
                   continue;
                }
                int weight = distances.containsKey(key) ?  Math.min(distances.get(key), edges.get(key) + distances.get(curr)) : edges.get(key) + distances.get(curr);
                distances.put(key, weight);
                queue.offer(key);
            }
        }
        return result;
    }
}

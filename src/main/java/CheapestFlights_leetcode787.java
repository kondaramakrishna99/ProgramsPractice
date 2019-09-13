import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.LinkedList;

public class CheapestFlights_leetcode787 {

    public static void main(String[] args) {
        int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};
        int[][] clone = flights.clone();
        System.out.println(Arrays.deepToString(clone));
        System.out.println(findCheapestPrice(3, flights, 0,2,0));
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

        if(src == dst)
            return 0;

        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();

        for(int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int cost = flight[2];

            graph.putIfAbsent(from, new HashMap<>());
            graph.get(from).put(to, cost);
        }
        System.out.println(graph.toString());

//        Queue<int[]> queue = new LinkedList<>();
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        //int[src, cost, stops]
        priorityQueue.offer(new int[]{src, 0, 0});
        int min = Integer.MAX_VALUE;
        while(!priorityQueue.isEmpty()) {
            int[] curr = priorityQueue.poll();
            int currCity = curr[0];
            int cost = curr[1];
            int stops = curr[2];

            if(currCity == dst) {
//                min = Math.min(min, cost);
//                continue;
                return cost;
            }
            if(!graph.containsKey(currCity) || stops == K+1 ) {
                continue;
            }

            Map<Integer, Integer> neighbours =  graph.get(currCity);
            for(int neighbour : neighbours.keySet()) {
                priorityQueue.offer(new int[]{neighbour, cost+neighbours.get(neighbour), stops+1});
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}

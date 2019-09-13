import java.util.PriorityQueue;

public class SlidingWindowMedia_leetcode480 {

    public static void main(String[] args) {
        PriorityQueue<Integer> minPQ = new PriorityQueue<>((x,y) -> x-y);
        minPQ.offer(1);
        minPQ.offer(2);
        minPQ.offer(3);
        minPQ.remove(2);
        System.out.println(minPQ.poll());
        System.out.println(minPQ.poll());
        System.out.println(minPQ.poll());

    }
}

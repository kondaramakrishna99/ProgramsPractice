import java.util.PriorityQueue;

public class FindMedian_leetcode295 {

    static PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> a.compareTo(b));
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b.compareTo(a));

    public FindMedian_leetcode295() {

    }

    public static void main(String[] args) {
        addNum(1);
        addNum(2);
        System.out.println(findMedian());
        addNum(3);
        System.out.println(findMedian());
    }

    public static void addNum(int num) {
        maxHeap.add(num);
        minHeap.offer(maxHeap.poll());
        if(minHeap.size()  - maxHeap.size() >  1) {
            int temp = minHeap.poll();
            maxHeap.offer(temp);
        }

        System.out.println(" ---------- ");
    }

    public static double findMedian() {
        System.out.println(maxHeap.toString());
        System.out.println(minHeap.toString());
        if(minHeap.size() == maxHeap.size()) {
            return (long)(minHeap.peek() + maxHeap.peek())/2.0;
        } else {
            return minHeap.peek();
        }
    }
}


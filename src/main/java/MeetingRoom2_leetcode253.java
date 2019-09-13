import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoom2_leetcode253 {

    public int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, (a,b) -> {
            if(a.start == b.start) {
                return a.end-b.end;
            }
            return a.start - b.start;
        });

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a,b) -> a-b);
        int count = 1;
        priorityQueue.offer(intervals[0].end);
        for(int i=1;i<intervals.length;i++) {
            if( priorityQueue.peek() < intervals[i].start) {
                priorityQueue.poll();
            }
            priorityQueue.offer(intervals[i].end);
            count = Math.max(count, priorityQueue.size());
        }
        return count;
    }

    public int minMeetingRooms1(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        PriorityQueue<Integer> queue = new PriorityQueue<>(intervals.length);

        queue.offer(intervals[0].end);
        int max = 1;
        for(int i=1;i<intervals.length;i++) {
            Interval temp = intervals[i];

            if(temp.start < queue.peek()) {
                queue.offer(temp.end);
                max = Math.max(max, queue.size());
            } else {
                queue.poll();
                queue.offer(temp.end);
            }
        }

        return max;
    }

   public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
 }
}

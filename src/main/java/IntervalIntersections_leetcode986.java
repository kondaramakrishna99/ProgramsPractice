import java.util.ArrayList;
import java.util.List;

public class IntervalIntersections_leetcode986 {

    class Interval {
           int start;
           int end;
           Interval() { start = 0; end = 0; }
           Interval(int s, int e) { start = s; end = e; }
    }

    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {

        if(A == null || B == null) {
            return null;
        }
        int i = 0;
        int j = 0;
        List<Interval> result = new ArrayList<>();
        while(i<A.length && j<B.length) {
            Interval interval1 = A[i];
            Interval interval2 = B[j];

            if(interval1.end < interval2.start || interval2.end < interval1.start) {
                if(interval1.end < interval2.end) {
                    i++;
                } else {
                    j++;
                }
                continue;
            }

            Interval temp = new Interval(Math.max(interval1.start, interval2.start),
                    Math.min(interval1.end, interval2.end));
            result.add(temp);
        }
        return result.toArray(new Interval[result.size()]);
    }

}

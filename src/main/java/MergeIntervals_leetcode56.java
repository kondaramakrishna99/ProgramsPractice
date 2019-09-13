import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class MergeIntervals_leetcode56 {

    public static void main(String[] args) {
        Interval interval = new Interval(1,3);
        Interval interval2 = new Interval(8,10);
        Interval interval3 = new Interval(15,18);
        Interval interval1 = new Interval(2,6);

        Interval interval4 = new Interval(1,6);
        Interval interval5 = new Interval(4,5);


        List<Interval> list = new ArrayList<Interval>(){{
            add(interval);
            add(interval1);
            add(interval2);
            add(interval3);
        }};


        List<Interval> list1 = new ArrayList<Interval>(){{
            add(interval4);
            add(interval5);
        }};
        System.out.println(merge1(list1));

        Interval interval_1 = new Interval(1,2);
        Interval interval_2 = new Interval(3,5);
        Interval interval_3 = new Interval(6,7);
        Interval interval_4 = new Interval(8,10);
        Interval interval_5 = new Interval(12,15);

        Interval newInterval = new Interval(6,6);

        list1 = new ArrayList<Interval>(){{
            add(interval_2);
            add(interval_5);
        }};

        System.out.println(insert(list1, newInterval));


        List<Interval> tempList = new ArrayList<Interval>(){{
            add(interval);
            add(interval2);
            add(interval3);
            add(interval1);
        }};
        System.out.println("tempList: "+tempList.toString());
        Collections.sort(tempList, (a,b) -> {
           if (a.start == b.start)
               return a.end - b.end;
           return a.start - b.start;
        });
        System.out.println("sorted tempList: "+tempList.toString());
        Interval tempInterval = new Interval(7,20);
        int index = Collections.binarySearch(tempList, tempInterval, (a,b) -> {
            if (a.start == b.start)
                return a.end - b.end;
            return a.start - b.start;
        });
        System.out.println("index: "+(-index-1));
        tempList.add((-index-1), tempInterval);
        System.out.println("inserted tempList: "+tempList.toString());

    }

    public static List<Interval> merge1(List<Interval> intervals) {
        Collections.sort(intervals, (a,b) -> {
            if (a.start == b.start) {
                return a.end - b.end;
            }
            return a.start - b.start;
        });

        List<Interval> result = new ArrayList<>();
        Interval prev = intervals.get(0);
        for (int i=1;i<intervals.size();i++) {
            Interval curr = intervals.get(i);
            if(curr.start > prev.end) {
                result.add(prev);
                prev = curr;
                continue;
            }
            prev.start = Math.min(curr.start, prev.start);
            prev.end = Math.max(curr.end, prev.end);
        }
        result.add(prev);
        return result;
    }


    public static List<Interval> merge(List<Interval> intervals) {

        Collections.sort(intervals, (i1, i2) -> {
            if(i1.start < i2.start) {
                return -1;
            } else if(i1.start == i2.start) {
                if(i1.end < i2.end)
                    return -1;
                else return 1;
            }
            return 1;
        });
        System.out.println(intervals.toString());

        List<Interval> result = new ArrayList<>();
        result.add(intervals.get(0));
        for (int i=1;i<intervals.size();i++) {
            if(intervals.get(i).start <= intervals.get(i-1).end) {
                Interval prev = result.get(result.size()-1);
                result.set(result.size()-1, new Interval(prev.start, Math.max(prev.end, intervals.get(i).end)));
            } else {
                result.add(intervals.get(i));
            }
        }

        System.out.println(result.toString());
        return result;
    }

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        List<Interval> result = new ArrayList<>();

        if(intervals == null || intervals.isEmpty()) {
            result.add(newInterval);
            return result;
        }

        if(newInterval.end < intervals.get(0).start) {
            intervals.add(0, newInterval);
            return intervals;
        }
        int size = intervals.size();
        if(newInterval.start> intervals.get(size-1).end){
            intervals.add(newInterval);
            return intervals;
        }

        int startIndex=-1;
        int endIndex=-1;
        Interval merged = new Interval(newInterval.start,newInterval.end);
        for(int i=0;i<intervals.size();i++) {

            if(intervals.get(i).end < newInterval.start) {
                result.add(intervals.get(i));
                startIndex=i;
                continue;
            } else if(intervals.get(i).start>newInterval.end) {
                result.add(intervals.get(i));
                continue;
            }

            merged = new Interval(Math.min(merged.start,intervals.get(i).start),
                    Math.max(merged.end, intervals.get(i).end));

        }
        result.add(startIndex+1, merged);
        return result;
    }

    public List<Interval> insert_concide(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        int i = 0;
        // add all the intervals ending before newInterval starts
        while (i < intervals.size() && intervals.get(i).end < newInterval.start)
            result.add(intervals.get(i++));
        // merge all overlapping intervals to one considering newInterval
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval = new Interval( // we could mutate newInterval here also
                    Math.min(newInterval.start, intervals.get(i).start),
                    Math.max(newInterval.end, intervals.get(i).end));
            i++;
        }
        result.add(newInterval); // add the union of intervals we got
        // add all the rest
        while (i < intervals.size()) result.add(intervals.get(i++));
        return result;
    }


    public static class Interval {
         int start;
         int end;
         Interval() { start = 0; end = 0; }
         Interval(int s, int e) { start = s; end = e; }

        @Override
        public String toString() {
            return "["+start+","+end+"]";
        }
    }


}

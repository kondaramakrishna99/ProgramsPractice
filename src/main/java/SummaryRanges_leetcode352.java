import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class SummaryRanges_leetcode352 {


    TreeMap<Integer, Interval> treeMap = new TreeMap<>();

    /** Initialize your data structure here. */
    public SummaryRanges_leetcode352() {
        TreeSet<Integer> set = new TreeSet<>();
    }

    public static void main(String[] args) {
        int[] nums = {6,7,2,4,5};
        TreeSet<Integer> treemap = new TreeSet<Integer>((a,b) -> {
            return nums[a] - nums[b];
        });
        Interval[] list = new Interval[3];
        Arrays.sort(list, (a,b) -> {
           return a.start - b.start;
        });

        Map<Integer, Integer> map = new HashMap<>();
        List<Map.Entry<Integer, Integer>> list1 = new ArrayList<>(map.entrySet());
        Collections.sort(list1, ( a,  b) -> {
            return a.getKey() - b.getKey();
        });

        for(int i = 0; i <nums.length;i++) {
            treemap.add(i);
        }
        System.out.println(treemap.toString());
    }

    public void addNum(int val) {
        if(treeMap.containsKey(val))
            return;
        Integer lowerKey = treeMap.lowerKey(val);
        Integer higherKey = treeMap.higherKey(val);

        if(lowerKey == null && higherKey == null) {
            treeMap.put(val, new Interval(val, val));
            return;
        } else if (lowerKey == null) {
            if (treeMap.get(higherKey).start == val + 1) {
                treeMap.get(higherKey).start = val;
            } else {
                treeMap.put(val, new Interval(val, val));
            }
            return;
        } else if (higherKey == null) {
            if (treeMap.get(lowerKey).end + 1 == val) {
                treeMap.get(lowerKey).end = val;
            } else {
                treeMap.put(val, new Interval(val, val));
            }
            return;
        }

        if (lowerKey != null && higherKey != null && treeMap.get(lowerKey).end + 1 == val && val +1 == higherKey) {
            treeMap.get(lowerKey).end = treeMap.get(higherKey).end;
            treeMap.remove(higherKey);
        } else if (lowerKey != null && treeMap.get(lowerKey).end + 1 >= val) {
            treeMap.get(lowerKey).end = Math.max(treeMap.get(lowerKey).end, val);
        } else if (higherKey != null && treeMap.get(higherKey).start == val + 1) {
            treeMap.get(higherKey).start = Math.min(treeMap.get(higherKey).start, val);
        } else {
            treeMap.put(val, new Interval(val, val));
        }

    }

    public List<Interval> getIntervals() {
        return new ArrayList<>(treeMap.values());
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

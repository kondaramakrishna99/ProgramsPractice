import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MeetingRooms_leetcode252 {

    public static void main(String[] args) {
        Map<String, List<String>> map =  new HashMap<String, List<String>>(){{
            put("srt", new ArrayList<>());
        }};

    }

    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals.length <= 1)
            return true;
        Arrays.sort(intervals, (a, b) -> {
            if(a.start == b.start) {
                return a.end - b.end;
            } else {
                return a.start - b.start;
            }
        });

        for(int i=1;i<intervals.length;i++) {
            int prev = i-1;
            if(intervals[i].start < intervals[prev].end)
                return false;
        }
        return true;

    }

    public class Interval {
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;
public class CourseSchedule_leetcode207 {

    public static void main(String[] args) {
        int[][] prereq = {{1,0}};
        System.out.println(canFinish(2, prereq));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0)
            return true;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<numCourses;i++) {
            map.put(i, new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];

        for(int[] prereq : prerequisites) {
            inDegree[prereq[0]]++;
            List<Integer> list = map.getOrDefault(prereq[1], new ArrayList<>());
            list.add(prereq[0]);
            map.put(prereq[1], list);
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<inDegree.length;i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int count = 0;
        if(queue.isEmpty() && inDegree.length>0)
            return false;

        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for(int i : map.get(course)) {
                inDegree[i]--;
                if(inDegree[i]==0) {
                    queue.offer(i);
                }
            }
        }
        return count == numCourses;
    }

}

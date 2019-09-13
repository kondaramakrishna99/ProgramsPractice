import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Amazon1 {

    public static void main(String[] args) {

        int deviceCapacity = 7;
        List<List<Integer>> foregroundAppList = new ArrayList<>();
        List<List<Integer>> backgroundAppList = new ArrayList<>();

        Collections.sort(foregroundAppList, (a,b) -> a.get(1)-b.get(1));
        Collections.sort(backgroundAppList, (a,b) -> a.get(1)-b.get(1));

//        int i = foregroundAppList.size()-1;
//        int j =
//        while(i)

        int max = Integer.MIN_VALUE;
        for(int i=0; i<foregroundAppList.size();i++) {
            for(int j=0;j<backgroundAppList.size();j++) {
                int memory1 = foregroundAppList.get(i).get(1);
                int memory2 = backgroundAppList.get(j).get(1);
                int sum = memory1 + memory2;
                if(sum > max && sum <=deviceCapacity) {
                    max = sum;
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<foregroundAppList.size();i++) {
            for(int j=0;j<backgroundAppList.size();j++) {
                int memory1 = foregroundAppList.get(i).get(1);
                int memory2 = backgroundAppList.get(j).get(1);
                int sum = memory1 + memory2;
                if (sum == max) {
                    int device1 = foregroundAppList.get(i).get(0);
                    int device2 = backgroundAppList.get(j).get(0);
                    result.add(Arrays.asList(device1, device2));
                }
            }
        }

//        int minParts = 4;
//        List<Integer> parts = Arrays.asList(8,4,6,12);
//
//        PriorityQueue<Integer> queue = new PriorityQueue<>();
//        int result = 0;
//
//        queue.addAll(parts);
//        while(queue.size() > 1) {
//            int minPart1 = queue.poll();
//            int minPart2 = queue.poll();
//            result+=minPart1+minPart2;
//            queue.offer(minPart1+minPart2);
//        }
//
//        System.out.println(result);
    }
}

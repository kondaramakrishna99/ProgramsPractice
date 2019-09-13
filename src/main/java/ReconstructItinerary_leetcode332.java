import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructItinerary_leetcode332 {

    public static void main(String[] args) {
        String[][] tickets= {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
        System.out.println(findItinerary(tickets).toString());
    }

    public static List<String> findItinerary(String[][] tickets) {

        Map<String, List<String>> map = new HashMap<>();

        for(String[] ticket : tickets) {
            String from = ticket[0];
            String to = ticket[1];
            map.putIfAbsent(from, new ArrayList<>());
            map.get(from).add(to);
        }

        for(String key : map.keySet()) {
            Collections.sort(map.get(key));
        }
        List<String> list = new ArrayList<>();
        list.add("JFK");
        dfs(map, 0, list, "JFK", tickets.length);

        return result;
    }
    static List<String> result = null;

    public static boolean dfs(Map<String, List<String>> map, int ticketCount,
                              List<String> list, String src, int totalCount) {

        if(ticketCount == totalCount) {
            result =  new ArrayList<>(list);
            return true;
        }
        if (!map.containsKey(src)) {
            return false;
        }
        List<String> destList = map.get(src);
        for(int i=0; i<destList.size(); i++) {
            String dest = destList.get(i);
            list.add(dest);
            destList.remove(i);
            if(dfs(map, ticketCount+1, list, dest, totalCount)) {
                return true;
            }
            list.remove(list.size()-1);
            destList.add(i, dest);
        }
        return false;

    }


//    public static List<String> findItinerary(String[][] tickets) {
//        Map<String, List<String>> map = new HashMap<>();
//
//        for(String[] ticket : tickets) {
//            List<String> dest = map.getOrDefault(ticket[0], new ArrayList<>());
//            dest.add(ticket[1]);
//            map.put(ticket[0], dest);
//        }
//        for(String key : map.keySet()) {
//            Collections.sort(map.get(key));
//        }
//        System.out.println(map.toString());
//        ticketCount = tickets.length;
//        dfs(map, new ArrayList<String>(){{add("JFK");}}, "JFK", "", 0);
//        return result;
//    }
//
//    static List<String> result = new ArrayList<>();
//    static String dests;
//    static int ticketCount;
//    public static boolean dfs(Map<String, List<String>> map, List<String> list, String departure, String itinerary, int count) {
//        if(count == ticketCount) {
////            if(dests == null || itinerary.compareTo(dests) < 0) {
////                result = new ArrayList<>(list);
////                dests = itinerary;
////                System.out.println(result.toString());
////            }
//            result = new ArrayList<>(list);
//            dests = itinerary;
//            System.out.println(result.toString());
//            return true;
//        }
//        if(!map.containsKey(departure)) {
//            return false;
//        }
//        List<String> destinations = map.get(departure);
//        for(int i =0; i<destinations.size();i++) {
//            String dest = destinations.get(i);
//            destinations.remove(i);
//            list.add(dest);
//            if(dfs(map, list, dest, itinerary+" "+dest, count+1)) {
//                return true;
//            }
//            destinations.add(i, dest);
//            list.remove(list.size()-1);
//        }
//        return false;
//    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ConnectedComponents_leetcode323 {

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
//        System.out.println(countComponents(5, edges));
        System.out.println(unionFind(5, edges));
    }

    public static int countComponents(int n, int[][] edges) {

        //build map
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] edge : edges) {
            List<Integer> list = map.getOrDefault(edge[0], new ArrayList<>());
            list.add(edge[1]);;
            map.put(edge[0], list);

            list = map.getOrDefault(edge[1], new ArrayList<>());
            list.add(edge[0]);
            map.put(edge[1], list);
        }
        System.out.println(map.toString());

        int count = 0;
        Set<Integer> visited = new HashSet<>();
        for(int i=0;i<n;i++) {
            if(visited.contains(i))
                continue;
            dfs(i, map, visited);
            System.out.println(i+" "+visited.toString());

            count++;
        }
        return count;
    }

    public static void dfs(int from, Map<Integer, List<Integer>> map, Set<Integer> visited) {


        List<Integer> list = map.get(from);
        visited.add(from);
        for(int i=0; i<list.size(); i++) {
            int to = list.get(i);
            if(visited.contains(to))
                continue;
            dfs(to, map, visited);
        }
    }

    public static int unionFind(int n, int[][] edges) {

        int[] parents = new int[n];
        for(int i=0; i< parents.length;i++) {
            parents[i] = i;
        }
        System.out.println(Arrays.toString(parents));

        for(int[] edge: edges) {
            int parentFrom = getParent(edge[0], parents);
            int parentTo = getParent(edge[1], parents);

            if(parentFrom != parentTo) {
                parents[parentFrom] = parentTo;
            }
            System.out.println(Arrays.toString(edge)+"  -> "+Arrays.toString(parents));
        }

        int count = 0;
        for(int i=0; i< parents.length;i++) {
            if(parents[i] == i) {
                count++;
            }
        }
        return count;
    }

    public static int getParent(int i, int[] parents) {
        while(parents[i] != i) {
            i = parents[i];
        }
        return i;
    }
}

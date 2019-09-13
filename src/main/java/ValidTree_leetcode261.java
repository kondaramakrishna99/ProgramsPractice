import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidTree_leetcode261 {

    public boolean validTree(int n, int[][] edges) {
        if(n==1 && edges.length==0)
            return true;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] edge : edges) {
            List<Integer> list = map.getOrDefault(edge[0], new ArrayList<>());
            list.add(edge[1]);
            map.put(edge[0], list);
            list = map.getOrDefault(edge[1], new ArrayList<>());
            list.add(edge[0]);
            map.put(edge[1], list);
        }

        if(map.size()!=n)
            return false;

        boolean[] visited = new boolean[n];
        int[] count = new int[1];
        count[0] = 0;
        if(!dfs(map, visited, -1, edges[0][0], count)) {
            return false;
        }
        if(count[0]!=n)
            return false;
        return true;
    }

    public boolean dfs(Map<Integer, List<Integer>> map, boolean[] visited, int parent, int node, int[] count) {

        if(visited[node])
            return false;

        visited[node] = true;
        count[0]++;
        List<Integer> children = map.get(node);
        for(int i=0;i<children.size();i++) {
            if(children.get(i)==parent)
                continue;
            if(!dfs(map, visited, node, children.get(i), count))
                return false;
        }
        return true;
    }

}

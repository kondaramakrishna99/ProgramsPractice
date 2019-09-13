import java.util.Stack;

public class Bipartite_leetcode785 {

    public static void main(String[] args) {

    }

    public boolean isBipartite(int[][] graph) {

        int[] colors = new int[graph.length];

        for(int i=0; i< graph.length ; i++) {
            if (colors[i] == 0 && !dfs(graph, colors, i, 1)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs (int[][] graph, int[] colors, int node , int color) {
        if(colors[node] == color) {
            return true;
        }

        if(colors[node]!=0 && colors[node] != color) {
            return false;
        }

        colors[node] = color ;
        for(int i : graph[node]) {
            if (!dfs(graph, colors, i, -color)) {
                return false;
            }
        }

        return true;
    }


}

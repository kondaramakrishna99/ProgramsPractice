import java.util.Arrays;

public class WallsAndGates_leetcode286 {

    public static void main(String[] args) {
        int[][] rooms ={{Integer.MAX_VALUE,-1,0,Integer.MAX_VALUE},{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,-1},
                {Integer.MAX_VALUE,-1,Integer.MAX_VALUE,-1}, {0,-1,Integer.MAX_VALUE,Integer.MAX_VALUE}};
        wallsAndGates(rooms);
    }

    public static void wallsAndGates(int[][] rooms) {
        int[][] distances = new int[rooms.length][rooms[0].length];
        int m = rooms.length;
        int n = rooms[0].length;

        for(int[] distance : distances) {
            Arrays.fill(distance, Integer.MAX_VALUE);
        }

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(rooms[i][j] == 0) {
                    dfs(rooms, 0, i, j, distances);
                }
            }
        }

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(rooms[i][j] != -1) {
                    rooms[i][j] = distances[i][j];
                }
            }
        }

        for(int[] distance : rooms) {
            System.out.println(Arrays.toString(distance));
        }

    }

    public static void dfs(int[][] rooms, int count, int i, int j, int[][] distances) {
        if(i<0 ||i>=rooms.length || j<0 || j>=rooms[0].length || distances[i][j] < count || rooms[i][j] == -1)
            return;

        distances[i][j] = count;
        dfs(rooms, count+1, i,j+1, distances);
        dfs(rooms, count+1, i,j-1, distances);
        dfs(rooms, count+1, i+1,j, distances);
        dfs(rooms, count+1, i-1,j, distances);
    }
}

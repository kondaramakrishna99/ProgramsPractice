import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Matrix01_leetcode542 {

    public static void main(String[] args) {
        int[][] matrix = {{0,0,0}, {0,1,0}, {1,1,1}};
        updateMatrix(matrix);
    }

    public static int[][] updateMatrix(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] indexes = {{-1,0},{0,-1},{1,0},{0,1}};

        int[][] dist = new int[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i< rows; i++) {
            for(int j=0; j< cols;j++) {
                if(matrix[i][j] == 0) {
                    dist[i][j]  = 0;
                    queue.offer(new int[]{i,j});
                } else {
                    dist[i][j]  = Integer.MAX_VALUE;
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();

            for(int[] index : indexes) {
                int newX = curr[0] + index[0];
                int newY = curr[1] + index[1];

                if(newX < 0 || newY < 0 || newX >= rows || newY >= cols
                || dist[newX][newY] <= dist[curr[0]][curr[1]]+1) {
                    continue;
                }

                queue.offer(new int[]{newX, newY});
                dist[newX][newY] = dist[curr[0]][curr[1]] + 1;
            }
        }

        System.out.println(Arrays.deepToString(dist));
        return dist;
    }
}

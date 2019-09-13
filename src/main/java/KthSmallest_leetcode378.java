import java.util.PriorityQueue;

public class KthSmallest_leetcode378 {

    public static void main(String[] args) {
        int[][] matrix ={{1,5,9},{10,11,13},{12,13,15}};
        System.out.println(kthSmallest(matrix, 8));
    }

    public static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Point> queue = new PriorityQueue<>((x,y) -> x.val - y.val);

        queue.offer(new Point(matrix[0][0], 0, 0));
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i=1; i< k; i++) {
            Point temp = queue.poll();
            if(temp.x+1 <= rows-1) {
                int newX = temp.x+1;
                int newY = temp.y;
                queue.offer(new Point(matrix[newX][newY], newX, newY));
            }
            if(temp.y+1 <= cols-1) {
                int newX = temp.x;
                int newY = temp.y+1;
                queue.offer(new Point(matrix[newX][newY], newX, newY));
            }
        }
        return queue.poll().val;
    }

    static class Point {
        int val;
        int x;
        int y;
        Point(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }
    }

}

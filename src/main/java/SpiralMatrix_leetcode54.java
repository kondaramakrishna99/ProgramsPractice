import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_leetcode54 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1},{2},{3}};
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {

        int i= matrix.length;
        int j = matrix[0].length;

        int top = 0;
        int bottom = i-1;

        int left = 0;
        int right = j-1;

        List<Integer> result = new ArrayList<>();
        while (top<=bottom) {

            for(int k=left;k<=right;k++) {
                result.add(matrix[top][k]);
            }
            top++;

            if(top > bottom)
                break;

            for(int k= top ;k<=bottom;k++) {
                result.add(matrix[k][right]);
            }
            right-- ;

            if(left > right)
                break;

            for(int k=right;k>=left;k--) {
                result.add(matrix[bottom][k]);
            }

            bottom--;

            for(int k=bottom;k>=top;k--) {
                result.add(matrix[k][left]);
            }
            left++;
        }

        return  result;
    }
}

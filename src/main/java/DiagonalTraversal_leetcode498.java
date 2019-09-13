import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiagonalTraversal_leetcode498 {

    public static void main(String[] args) {
        int[][] array = {{1, 2, 3,4}, {5, 6, 7,8}, {9, 10, 11,12}};
        findDiagonalOrder(array);
    }

    public static int[] findDiagonalOrder(int[][] matrix) {
        List<int[]> list = new ArrayList<>();
        int[] result = new int[matrix.length * matrix[0].length];
        int index = 0;
        list.add(new int[]{0, 0});
        boolean isUp = true;
        List<int[]> temp = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int[] curr = list.get(i);
            int row = curr[0];
            int col = curr[1];
            result[index++] = matrix[row][col];
            if (isUp) {
                if (row + 1 <= matrix.length - 1) {
                    temp.add(0, new int[]{row + 1, col});
                }
                if (i == list.size() - 1) {
                    if (col + 1 <= matrix[0].length - 1) {
                        temp.add(0, new int[]{row, col + 1});
                    }
                    isUp = !isUp;
                    i = -1;
                    list = new ArrayList<>(temp);
                    temp.clear();
                    continue;
                }
            } else if (!isUp) {
                if (i == 0) {
                    if (col + 1 <= matrix[0].length - 1) {
                        temp.add(0, new int[]{row, col + 1});
                    }
                }
                if (row + 1 <= matrix.length - 1) {
                    temp.add(0, new int[]{row + 1, col});
                }
                if (i == list.size() - 1) {
                    isUp = !isUp;
                    i = -1;
                    list = new ArrayList<>(temp);
                    temp.clear();
                    continue;
                }
            }
        }


        System.out.println(Arrays.toString(result));
        return result;
    }
}

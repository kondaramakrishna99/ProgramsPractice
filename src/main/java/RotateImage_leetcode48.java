public class RotateImage_leetcode48 {

    public void rotate(int[][] M) {
        for (int i = 0; i < (M.length+1)/2; i++) {
            for (int j = 0; j < M.length/2; j++) {
                int tmp = M[i][j];
                M[i][j] = M[M.length-j-1][i];
                M[M.length-j-1][i] = M[M.length-i-1][M.length-j-1];
                M[M.length-i-1][M.length-j-1] = M[j][M.length-i-1];
                M[j][M.length-i-1] = tmp;
            }
        }
    }
}

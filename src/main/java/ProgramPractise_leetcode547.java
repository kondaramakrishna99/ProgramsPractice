import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ProgramPractise_leetcode547 {

    public static void main(String[] args) {
        int[][] array = {{1,1,0},{1,1,1},{0,1,1}};
        System.out.println(findCircleNum(array));
    }

    public static int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) {
            return 0;
        }
        int[] parent = new int[M.length];

        for(int i=0;i<parent.length;i++) {
            parent[i] = i;
        }
        int rows = M.length;
        int cols = M[0].length;
        for (int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(i!=j && M[i][j] == 1) {
                    union(i, j, parent);
                }
            }
        }
        System.out.println(Arrays.toString(parent));
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<parent.length;i++) {
            set.add(find(i, parent));
        }
        System.out.println(set.toString());
        return set.size();
    }

    public static int find(int i, int[] parent) {
        while(parent[i] != i) {
            i = parent[i];
        }
        return i;
    }

    public static void union(int i, int j, int[] parent) {
        int parentI = find(i, parent);
        int parentJ = find(j, parent);
        parent[parentJ] = parentI;
    }


}

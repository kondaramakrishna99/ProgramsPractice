import java.util.ArrayList;
import java.util.List;

public class SmallestRectangle_leetcode302 {

    public static void main(String[] args) {
        char[][] image = {{'0','0','1','0'},{'0','1','1','0'},{'0','1','0','0'}};
        System.out.println(minArea(image, 0, 2));
    }

    public static int minArea(char[][] image, int x, int y) {
        if(image == null || image.length == 0 || image[0].length == 0)
            return 0;
        List<int[]> result = new ArrayList<>();
        dfs(image, x, y, result);
        int minX = x;
        int minY = y;
        int maxX = x;
        int maxY = y;
        for (int i=0;i<result.size();i++) {
            minX = Math.min(minX, result.get(i)[0]);
            minY = Math.min(minY, result.get(i)[1]);
            maxX = Math.max(maxX, result.get(i)[0]);
            maxY = Math.max(maxY, result.get(i)[1]);
        }
        return (maxX-minX+1) * (maxY-minY+1);
    }

    public static void dfs(char[][] image, int x, int y, List<int[]> result) {
        if(x<0 || y<0 || x >= image.length || y>= image[0].length || image[x][y]=='0') {
            return;
        }
        result.add(new int[]{x,y});
        image[x][y] = '0';
        dfs(image, x-1, y, result);
        dfs(image, x+1, y, result);
        dfs(image, x, y+1, result);
        dfs(image, x, y-1, result);
    }


}

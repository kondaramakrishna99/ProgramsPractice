import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Maze3_leetcode499 {

    static char[] dirsChars = {'u','d','l','r'};
    static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    static List<String> resultList = new ArrayList<>();
    static int minCount = Integer.MAX_VALUE;
    static String minString = "";

    public static void main(String[] args) {
        int[][] maze = {{0,0,0,0,0}, {1,1,0,0,1}, {0,0,0,0,0}, {0,1,0,0,1}, {0,1,0,0,0}};
        int[] ball = {4,3};
        int[] hole = {3,0};

//        System.out.println(findShortestWay(maze, ball, hole));
//
        int[] array = {2,4,6,10};
        int i= Arrays.binarySearch(array, 6);
        System.out.println(i+"  "+(-i-1));
    }

    //bfs :

    public static String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        dfs(maze, ball, hole, visited, "", 0);
        return minString;
    }

    public static void dfs(int[][] maze, int[] ball, int[] hole, boolean[][] visited, String result, int count) {

        int ballI = ball[0];
        int ballJ = ball[1];
        if(ballI < 0 || ballJ < 0 || ballI >= maze.length || ballJ >= maze[0].length
                || visited[ballI][ballJ] || maze[ballI][ballJ] == 1)
            return;

        if(ballI == hole[0] && ballJ == hole[1]) {
            resultList.add(result);
            if (count < minCount) {
                minCount = count;
                minString = result;
            } else if (count == minCount) {
                minString = minString.compareTo(result) < 0 ? minString : result;
            }
            System.out.println(result+", "+count+", "+minString+", "+minCount);
            return;
        }

        visited[ballI][ballJ] = true;
        for (int i=0; i<dirs.length; i++) {
            int[] newdir = {ball[0]+dirs[i][0], ball[1]+dirs[i][1]};
            String newDirection = result.isEmpty() || dirsChars[i]!=result.charAt(result.length()-1) ? result+dirsChars[i] : result;
            dfs(maze, newdir, hole, visited, newDirection, count+1);
        }
        visited[ballI][ballJ] = false;
    }
}

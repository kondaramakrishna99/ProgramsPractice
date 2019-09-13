import java.util.Arrays;
import java.util.List;

public class WordSearch_leetcode79 {

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(Arrays.toString(board));
        System.out.println(exist(board, "ABCB"));

    }

    public static boolean exist(char[][] board, String word) {

        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(dfs(word, i, j, board, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean dfs(String word, int i, int j, char[][] board, int wordIndex) {

        if(wordIndex == word.length()){
            return true;
        }

        if(i<0 || i>=board.length || j<0 || j>=board[0].length ) {
            return false;
        }

        if(board[i][j] != word.charAt(wordIndex)) {
            return false;
        }

        char ch = board[i][j];
        board[i][j] = '#';
        boolean isPresent = dfs(word, i+1, j, board,wordIndex+1)
                || dfs(word, i-1, j, board,wordIndex+1)
                || dfs(word, i, j-1, board,wordIndex+1)
                || dfs(word, i, j+1, board,wordIndex+1);
        board[i][j] = ch;
        return isPresent;

    }

    public static boolean exist1(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        int m= board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if (existDfs1(board, word, i, j, 0, visited)) {
                   return true;
                }
            }
        }
        return false;
    }

    public static boolean existDfs1(char[][] board, String word, int i, int j, int index, boolean[][] visited) {

        if(index == word.length())
            return true;

        if( i<0 || i>=board.length || j<0 || j>=board[0].length || visited[i][j])
            return false;

        if (board[i][j] != word.charAt(index))
            return false;

        visited[i][j] = true;

        boolean search =  existDfs1(board, word, i-1, j, index+1, visited) ||
                existDfs1(board, word, i, j-1, index+1, visited) ||
                existDfs1(board, word, i, j+1, index+1, visited) ||
                existDfs1(board, word, i+1, j, index+1, visited) ;

        visited[i][j] = false;
        return search;
    }
}

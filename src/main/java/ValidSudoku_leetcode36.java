import java.util.HashSet;
import java.util.Set;

public class ValidSudoku_leetcode36 {

    public boolean isValidSudoku(char[][] board) {

        for(int i=0;i<9;i++) {
            Set<Character> rowSet = new HashSet<>();
            Set<Character> columnSet = new HashSet<>();
            Set<Character> cubeSet = new HashSet<>();
            for(int j=0;j<9;j++){
                if(board[i][j] != '.' && !rowSet.add(board[i][j])) {
                    return false;
                }
                if (board[j][i] != '.' && !columnSet.add(board[j][i])) {
                    return false;
                }
                int row = 3*(i/3);
                int col = 3*(i%3);
                if ( board[row+j/3][col+j%3]!='.' && !cubeSet.add(board[row+j/3][col+j%3])) {
                    return false;
                }
            }
        }

        return true;
    }

}

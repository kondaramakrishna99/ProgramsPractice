import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class SlidingPuzzle_leetcode773 {

    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static Map<Integer, Integer> map = new HashMap<>();
    static int min_move = Integer.MAX_VALUE;

    public static void main(String[] args) {
        System.out.println();
        int[][] board = {{4,1,2},{5,0,3}};
        SlidingPuzzle_leetcode773 obj = new SlidingPuzzle_leetcode773();
//        System.out.println(slidingPuzzleDFS(board));
        System.out.println(obj.slidingPuzzleBFS(board));
    }

    public  int slidingPuzzleBFS(int[][] board) {
        Queue<State> queue = new LinkedList<>();
        int[][] desired = {{1,2,3},{4,5,0}};
        String result = Arrays.deepToString(desired);
        int zeroX=0;
        int zeroY=0;
        for(int i=0;i<board.length;i++) {
            for(int j=0; j<board[0].length;j++) {
                if(board[i][j] == 0) {
                    zeroX = i;
                    zeroY = j;
                    break;
                }
            }
        }
        State currState = new State(board, zeroX, zeroY);
        queue.offer(currState);
        Set<String> visited = new HashSet<>();
        visited.add(Arrays.deepToString(currState.board));
        int moves = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size;i++) {
                currState = queue.poll();
                System.out.println("here: "+Arrays.deepToString(currState.board)+"  "+desired);
                if(Arrays.deepToString(currState.board).equals(result)) {
                    return moves;
                }
                List<State> nextStates = currState.getNextStates();
                for(State state : nextStates) {
                    if(!visited.contains(Arrays.deepToString(state.board))) {
                        ((LinkedList<State>) queue).add(state);
                        visited.add(Arrays.deepToString(state.board));
                    }
                }
            }
            moves++;
        }
        return -1;
    }

    class State {
        int[][] board;
        int zeroX;
        int zeroY;
        State(int[][] board, int i, int j) {
            this.board = clone(board);
            this.zeroX = i;
            this.zeroY = j;
        }

        List<State> getNextStates() {
            List<State> result = new ArrayList<>();

            int[][] next = {{-1,0},{1,0},{0,-1},{0,1}};
            for(int i=0; i<next.length;i++) {
                int nextI = next[i][0]+zeroX;
                int nextJ = next[i][1]+zeroY;
                if(nextI >=0 && nextI<=1 && nextJ>=0 && nextJ<=2) {
                    int[][] boardClone = clone(board);
                    swap(boardClone, zeroX, zeroY, nextI, nextJ);
                    State temp =  new State(boardClone, nextI, nextJ);
                    System.out.println(Arrays.deepToString(temp.board));
                    result.add(temp);
                }

            }
            return result;
        }

        public int[][] clone(int[][] board) {
            int[][] temp = new int[board.length][board[0].length];
            for(int i=0;i<board.length;i++) {
                for(int j=0; j<board[0].length;j++) {
                    temp[i][j] = board[i][j];
                }
            }
            return temp;

        }

        public void swap(int[][] board, int i, int j, int nextI, int nextJ) {
            int temp = board[i][j];
            board[i][j] = board[nextI][nextJ];
            board[nextI][nextJ] = temp;
        }
    }

    public static int slidingPuzzleDFS(int[][] board) {
        map.put(123450, 0);
        int[] zero = new int[2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    zero[0] = i;
                    zero[1] = j;
                    break;
                }
            }
        }
        helper(board, zero[0], zero[1], 0);
        return min_move == Integer.MAX_VALUE ? -1 : min_move;
    }
    private static void helper(int[][] board, int x, int y, int move) {
        if (move > min_move) return;
        int code = encode(board);
        if (code == 123450) {
            min_move = move;
            System.out.println("soln "+code);
            return;
        }
        if (move > min_move) {
             return;
        }
        if (map.containsKey(code)) {

//            if (move > map.get(code)) {
//                System.out.println("return");
//
//                return;
//            }
            System.out.println("return "+code);
            return;
        }
        System.out.println(code);
        map.put(code, move);
        for (int[] dir : dirs) {
            int nx = x + dir[0], ny = y + dir[1];
            if (nx >= 0 && nx < 2 && ny >= 0 && ny < 3) {
                swap(board, x, y, nx, ny);
                helper(board, nx, ny, move + 1);
                swap(board, nx, ny, x, y);
            }
        }
        System.out.println("remove "+code);
        map.remove(code);
    }
    private static void swap (int[][] board, int i, int j, int ii, int jj) {
        int temp = board[i][j];
        board[i][j] = board[ii][jj];
        board[ii][jj] = temp;
    }
    private static int encode(int[][] board) {
        int code = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                code *= 10;
                code += board[i][j];
            }
        }
        return code;
    }
}

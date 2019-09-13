import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class SnakeGame {

    Deque<Position> deque = new LinkedList<>();
    Set<Position> set = new HashSet<>();
    int[][] food;
    int len;
    int rows;
    int cols;
    int score;
    public SnakeGame(int width, int height, int[][] food) {
        this.food = food;
        this.rows = height;
        this.cols = width;
        deque.add(new Position(0,0));
        set.add(new Position(0,0));
        len = 0;
    }

    public int move(String direction) {
        Position curr = deque.peekFirst();
        switch (direction) {
            case "U":
                curr.x--;
                break;
            case "D":
                curr.x++;
                break;
            case "R":
                curr.y++;
                break;
            case "L":
                curr.y--;
                break;
        }
        set.remove(deque.peekLast());
        if(curr.x<0 || curr.x>=rows || curr.y<0 || curr.y>=cols || len>=food.length || set.contains(curr))
            return -1;

        deque.add(curr);
        if(len < food.length && curr.x==food[len][0] && curr.y == food[len][1]) {
            deque.addLast(deque.peekLast());
            len++;
            set.add(curr);
            score++;
        }
        deque.pollLast();
        return score;
    }

    class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Position pos) {
            if(this.x == pos.x && this.y == pos.y) {
                return true;
            }
            return false;
        }
    }
}

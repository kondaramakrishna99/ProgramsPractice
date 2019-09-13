import java.util.ArrayList;
import java.util.List;

public class FlipGame_leetcode293 {

    public static void main(String[] args) {
        System.out.println(generatePossibleNextMoves("++"));
    }

    public static List<String> generatePossibleNextMoves(String s) {

        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            int index = s.indexOf("++", i);
            if(index == -1)
                break;
            list.add(s.substring(0, index)+"--"+s.substring(Math.min(index+2, s.length())));
            i = index+1;
        }
        return list;

    }
}

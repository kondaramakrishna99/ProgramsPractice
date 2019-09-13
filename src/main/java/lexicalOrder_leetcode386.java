import java.util.ArrayList;
import java.util.List;

public class lexicalOrder_leetcode386 {

    public static void main(String[] args) {
        lexicalOrder(100);
    }

    public static List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        dfs(n, list, 1);
        System.out.println(list.toString());
        return list;
    }

    public static void dfs(int n, List<Integer> list, int start) {

        for (int i = start; i <= start+9; i++) {
            if( i > n )
                return;
            list.add(i);
            dfs(n, list, i*10);
        }
    }

}

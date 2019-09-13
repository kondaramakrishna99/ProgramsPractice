import java.util.HashMap;
import java.util.Map;

public class PerfectSquares_leetcode279 {

    public static void main(String[] args) {
        numSquares(13);
    }

    public static int numSquares(int n) {
        int result = dfs(n, new HashMap<>());
        System.out.println(result);
        return result;
    }

    public static int dfs(int n, Map<Integer, Integer> map) {
        if(n == 0)
            return 0;
        if(map.containsKey(n))
            return map.get(n);
        int min = Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++) {
            min = Math.min(min, dfs(n-i*i, map)+1);
        }

        map.put(n, min);
        return min;
    }
}

import java.util.Arrays;

public class SplitArray_leetcode410 {

    public static void main(String[] args) {
        int[] array = {7,2,5,10,8};
        System.out.println(splitArray(array, 4));
    }
    //dfs + memoization
    public static int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[] presum = new int[n+1];
        presum[0] = 0;

        for (int i = 1; i <= n; i++) {
            presum[i] += nums[i-1] + presum[i-1];
        }

        int[][] visited = new int[n][m+1];
        return dfs(0, m, nums, presum, visited);
    }

    private static int dfs(int start, int m, int[] nums, int[] presum, int[][] visited) {
        if (m == 1) {
            return presum[nums.length] - presum[start];
        }

        if (visited[start][m] != 0) {
            return visited[start][m];
        }

        int maxSum = Integer.MAX_VALUE;

        for (int i = start; i < nums.length-1; i++) {
            int l = presum[i+1] - presum[start];
            int rightIntervalMax = dfs(i+1, m-1, nums, presum, visited);
            maxSum = Math.min(maxSum, Math.max(l, rightIntervalMax));

        }

        visited[start][m] = maxSum;
        return maxSum;
    }


    //dp soln
    public static int splitArray1(int[] nums, int m) {


        int[][] dp = new int[m+1][nums.length];
        int sum = 0;

        for(int i=0;i<nums.length;i++) {
            sum+=nums[i];
            dp[1][i] = sum;
        }

        if (m > nums.length) {
            return sum;
        }

        for(int i=2;i<=m;i++) {
            for(int j=i-1;j<nums.length;j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=0;k<j;k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i-1][k], dp[1][j]-dp[1][k]));
                }
            }
//            System.out.println(i+" " + Arrays.toString(dp[i]));
        }

        return dp[m][nums.length-1];
    }


}

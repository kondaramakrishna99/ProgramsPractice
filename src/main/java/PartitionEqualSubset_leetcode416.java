public class PartitionEqualSubset_leetcode416 {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum %2 != 0) return false;
        sum /= 2;

        boolean dp[][] = new boolean[nums.length + 1][sum + 1];

        for (int i = 0; i < nums.length + 1; i++) {
            for (int j = 0; j < sum + 1; j ++) {
                if (i == 0 || j == 0)
                    dp[i][j] = false;
            }
        }

        dp[0][0] = true;

        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (j >= nums[i- 1])
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i-1]];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[nums.length][sum];
    }

}

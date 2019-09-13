public class HouseRobber3_leetcode337 {

    int max = Integer.MIN_VALUE;

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }

    public int[] dfs(TreeNode root) {

        if (root == null)
            return new int[]{0,0};

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int rob = root.val + left[1]+right[1];
        int nonrob = Math.max(left[0] + right[0], left[1]+right[1]);
        int nonrob1 = Math.max(left[0]+right[1], left[1]+right[0]);

        return new int[]{rob, Math.max(nonrob, nonrob1)};
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

public class DiameterBinaryTree_leetcode543 {

    static int max = 0;
    public static int diameterOfBinaryTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        dfs(root);
        return max;
    }

    public static int dfs(TreeNode root) {
        if(root == null)
            return 0;

        if(root.left == null && root.right == null) {
            return 1;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        max = Math.max(max, left+right);
        return Math.max(left, right)+1;

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

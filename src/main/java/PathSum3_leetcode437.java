public class PathSum3_leetcode437 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static int count = 0;
    static boolean first = true;

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(-3);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(11);
        TreeNode node7 = new TreeNode(3);
        TreeNode node8 = new TreeNode(-2);
        TreeNode node9 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        node4.left = node7;
        node4.right = node8;
        node5.right = node9;
        System.out.println(pathSum(node1, 8));
    }

    public static int pathSum(TreeNode root, int sum) {
        dfs(root, 0, sum);
        return count;
    }

    public static void dfs(TreeNode curr, int sum, int target) {
        if(sum == target)
            count++;

        if(curr == null)
            return;

        if(first) {
            first = false;
            dfs(curr.left, curr.val, target);
            dfs(curr.right, curr.val, target);
        } else  {
            dfs(curr.left, curr.val+sum, target);
            dfs(curr.left, curr.val, target);
            dfs(curr.right, curr.val+sum, target);
            dfs(curr.right, curr.val, target);
        }
    }
}

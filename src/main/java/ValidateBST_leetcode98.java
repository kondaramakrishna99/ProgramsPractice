public class ValidateBST_leetcode98 {

    public static void main(String[] args) {

//        System.out.println(isValidBST(3));
    }

    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public static boolean isValidBST(TreeNode root, int max, int min) {
        if(root == null)
            return true;

        if(root.val<min || root.val>max) {
            return false;
        }
        return isValidBST(root.left, root.val, min) && isValidBST(root.right, max, root.val);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

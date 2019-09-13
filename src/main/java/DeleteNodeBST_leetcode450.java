public class DeleteNodeBST_leetcode450 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {

    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return null;
        if(root.val == key && root.left == null && root.right == null) {
            return null;
        }

        TreeNode prev = new TreeNode(-1);
        prev.right = root;
        TreeNode curr = root;
        while(curr!=null && curr.val != key) {
            prev = curr;
            if(key < curr.val) {
                curr = curr.left;
            } else if (key > curr.val) {
                curr = curr.right;
            }
        }

        if(curr == null)
            return root;

        if (curr.left == null && curr.right == null) {
            if (prev.left == curr) {
                prev.left = null;
            } else if (prev.right == curr)
                prev.right = null;
        } else if (curr.left == null) {
            if (prev.left == curr) {
                prev.left = curr.right;
            } else if (prev.right == curr)
                prev.right = curr.right;
        } else {
            curr.val = getMax(curr.left);
            curr.left = deleteNode(curr.left, curr.val).right;
        }
        return prev.right;
    }

    public static int getMax(TreeNode curr) {
        while (curr.right != null) {
            curr = curr.right;
        }
        return curr.val;
    }

}

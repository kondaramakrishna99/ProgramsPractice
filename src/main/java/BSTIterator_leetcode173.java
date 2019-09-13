import java.util.Stack;

public class BSTIterator_leetcode173 {

    Stack<TreeNode> stack = new Stack<>();
    public BSTIterator_leetcode173(TreeNode root) {
        TreeNode curr = root;

        while(curr!=null) {
            stack.push(curr);
            curr = curr.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        if (!hasNext())
            return -1;

        TreeNode top = stack.pop();
        if(top.right!=null) {
            TreeNode right = top.right;
            TreeNode curr = right;
            while(curr!=null) {
                stack.push(curr);
                curr = curr.left;
            }
        }
        return top.val;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

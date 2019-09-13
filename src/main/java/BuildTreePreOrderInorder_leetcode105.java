import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class BuildTreePreOrderInorder_leetcode105 {

    public static void main(String[] args) {

        TreeNode root = buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        System.out.println(root);
        System.out.println(levelOrder(root).toString());
    }
    public static  TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0)
            return null;
        return buildTree(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }


    public static TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {

        if(inStart==inEnd) {
            return new TreeNode(inorder[inStart]);
        }

        if(inStart>inEnd)
            return null;

        int rootVal = preorder[preStart];
        int inPos=inStart;
        for(int i=inStart;i<=inEnd;i++) {
            if(inorder[i]==rootVal) {
                inPos = i;
            }
        }
        int leftSize = inPos - inStart;

        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(preorder, inorder, preStart+1, preStart+leftSize, inStart, inPos-1);
        root.right = buildTree(preorder, inorder, preStart+leftSize+1, preEnd, inPos+1, inEnd);

        return root;
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0;i<size;i++) {
                TreeNode curr = queue.poll();
                level.add(curr.val);
                if(curr.left!=null)
                    queue.offer(curr.left);
                if(curr.right!=null)
                    queue.offer(curr.right);
            }
            result.add(level);
        }

        return result;

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}

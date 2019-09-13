import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode level1left = new TreeNode(2);
        TreeNode level1right = new TreeNode(3);
        TreeNode level2_1 = new TreeNode(4);
        TreeNode level2_2 = new TreeNode(5);
        TreeNode level2_3= new TreeNode(6);
        TreeNode level2_4 = new TreeNode(7);
        TreeNode level3_1 = new TreeNode(8);
        TreeNode level3_2= new TreeNode(15);

        root.left = level1left;
        root.right = level1right;
        level1left.left = level2_1;
        level1left.right = level2_2;
        level1right.left = level2_3;
        level1right.right = level2_4;
        level2_1.left = level3_1;
        level2_4.right = level3_2;

        System.out.println(preOrderTraversal(root).toString());
        System.out.println(preOrderIterative(root).toString());
    }


    public static List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preOrderDfs(root, result);
        return result;
    }

    public static void preOrderDfs(TreeNode root, List<Integer> result) {
        if(root == null) {
            return;
        }
        result.add(root.val);
        preOrderDfs(root.left,result);
        preOrderDfs(root.right, result);
    }

    public static List<Integer> preOrderIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root != null) {
            stack.push(root);
        }

        while(!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            result.add(curr.val);
            if(curr.right!=null) {
                stack.push(curr.right);
            }
            if(curr.left!=null) {
                stack.push(curr.left);
            }
        }
//        System.out.println(result.toString());
        return result;
    }

}

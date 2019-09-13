import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal_leetcode94 {

    static class TreeNode {
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

        System.out.println(inorderTraversal(root).toString());
        System.out.println(inorderIterative(root).toString());
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderDfs(root, result);
        return result;
    }

    public static void inorderDfs(TreeNode root, List<Integer> result) {
         if(root == null)
             return;

        inorderDfs(root.left, result);
        result.add(root.val);
        inorderDfs(root.right, result);
    }

    public static List<Integer> inorderIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root==null) {
            return result;
        }

        TreeNode curr = root;
        while (curr!=null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        return result;
    }

    //interesting two stack solution in https://www.geeksforgeeks.org/iterative-postorder-traversal/

    public static List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root==null) {
            return result;
        }

        TreeNode prev = null;
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode curr = stack.peek();
            if(prev == null || prev.left==curr || prev.right == curr) {
                if(curr.left!=null) {
                    stack.push(curr.left);
                } else if(curr.right!=null) {
                    stack.push(curr.right);
                } else {
                    result.add(stack.pop().val);
                }
            } else if (curr.left == prev) {
                if(curr.right!=null) {
                    stack.push(curr.right);
                } else {
                    result.add(stack.pop().val);
                }
            } else if (curr.right == prev) {
                result.add(stack.pop().val);
            }
            prev =curr;
        }
        return result;
    }


}

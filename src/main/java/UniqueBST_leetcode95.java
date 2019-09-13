import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniqueBST_leetcode95 {

    public static void main(String[] args) {
        System.out.println(generateTrees(3));
    }


    public static List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = generateTrees(1,n);
        result.forEach(treeNode -> System.out.println(preOrderTraversal(treeNode).toString()));
        return result;
    }


    public static List<TreeNode> generateTrees(int min, int max) {

        List<TreeNode> result = new ArrayList<>();
        if(min > max) {
            result.add(null);
            return result;
        }

        if (min == max) {
            result.add(new TreeNode(min));
            return result;
        }


        for(int i=min; i<=max;i++) {
            List<TreeNode> leftNodes = generateTrees(min, i-1);
            List<TreeNode> rightNodes = generateTrees(i+1, max);
            for(TreeNode left: leftNodes) {
                for(TreeNode right : rightNodes) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    result.add(node);
                }
            }
        }
        return result;
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

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

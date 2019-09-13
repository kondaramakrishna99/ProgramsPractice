import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

public class SerializaDeserializeTree_leetcode297 {

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(Arrays.binarySearch(nums, 0));

        TreeNode root = new TreeNode(1);
        TreeNode level1left = new TreeNode(2);
        TreeNode level1right = new TreeNode(3);
        TreeNode level2_1 = new TreeNode(4);
        TreeNode level2_2 = new TreeNode(5);
//        TreeNode level2_3= new TreeNode(6);
//        TreeNode level2_4 = new TreeNode(7);
//        TreeNode level3_1 = new TreeNode(8);
//        TreeNode level3_2= new TreeNode(15);

        root.left = level1left;
        root.right = level1right;
        level1right.left = level2_1;
        level1right.right = level2_2;

        System.out.println(serialize1(root));
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "null";

        String result = "";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if(curr == null) {
                result+="null,";
                continue;
            }
            result+=curr.val+",";
            queue.add(curr.left);
            queue.add(curr.right);
        }
        return result.substring(0,result.length()-1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("null"))
            return null;

        String[] nodes = data.split(",");
        int j=1;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (!nodes[j].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(nodes[j]));
                curr.left = left;
                queue.add(left);
            }
            j++;
            if (!nodes[j].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(nodes[j]));
                curr.right = right;
                queue.add(right);
            }
            j++;
        }
        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static String serialize1(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder str = new StringBuilder();

        while(!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if(curr == null) {
                str.append("#,");
                continue;
            }
            str.append(curr.val+",");
            queue.offer(curr.left);
            queue.offer(curr.right);
        }
        return str.substring(0, str.length()-1);
    }

    public static TreeNode deSerialize1(String str) {

        String[] array = str.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(array[0]));
        int j=1;
        Queue<TreeNode> queue = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if(!array[j].equals("#")) {
                curr.left = new TreeNode(Integer.parseInt(array[j]));
                queue.offer(curr.left);
            }
            j++;
            if(!array[j].equals("#")) {
                curr.right = new TreeNode(Integer.parseInt(array[j]));
                queue.offer(curr.right);
            }
            j++;
        }

        return root;
    }
}

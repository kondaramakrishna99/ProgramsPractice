public class SerializeAndDeserBST_leetcode449 {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        String str = sb.toString();
        return str.isEmpty() ? "" : sb.toString().substring(0, sb.length()-1);
    }

    public void dfs(TreeNode root, StringBuilder sb) {
        if(root == null) {
            return;
        }
        sb.append(root.val).append(",");
        dfs(root.left, sb);
        dfs(root.right, sb);
    }

    public TreeNode deserialize(String data) {
        if(data == null || data.isEmpty()) {
            return null;
        }
        String[] array = data.split(",");
        return deserializeDfs(array, 0, array.length-1);
    }

    public TreeNode deserializeDfs(String[] array, int left, int right) {
        if(left > right)
            return null;
        if(left == right) {
            return new TreeNode(Integer.parseInt(array[left]));
        }

        TreeNode curr = new TreeNode(Integer.parseInt(array[left]));
        int i = left+1;
        while(i<=right) {
            if(Integer.parseInt(array[i]) > Integer.parseInt(array[left])) {
                break;
            }
            i++;
        }

        curr.left = deserializeDfs(array, left+1, i-1);
        curr.right = deserializeDfs(array, i, right);

        return curr;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

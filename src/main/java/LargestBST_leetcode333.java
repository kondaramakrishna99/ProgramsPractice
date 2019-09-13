
import java.util.Comparator;
import java.util.Objects;

public class LargestBST_leetcode333 {

    int max = Integer.MIN_VALUE;
    public int largestBSTSubtree(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left ==null && root.right == null) {
            return 1;
        }
        Point result = dfs(root);
        return max;
    }

    public Point dfs(TreeNode root) {
        if (root == null) {
            max = Math.max(max, 0);
            return new Point(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);
        }

        if(root.left ==null && root.right == null) {
            max = Math.max(max, 1);
            return new Point(root.val, root.val);
        }

        Point left = dfs(root.left);
        Point right = dfs(root.right);

        if(left.isBST && right.isBST && root.val<right.min && root.val > left.max) {
            max = Math.max(max, 1+left.count+right.count);
            return new Point(Math.min(left.min, root.val), Math.max(root.val, right.max), 1+left.count+right.count, true);
        } else {
            return new Point(root.val, root.val, 1, false);
        }

    }

    public static class Point {
        int count;
        int min;
        int max;
        boolean isBST;
        Point(int minM, int maxM) {
            min = minM;
            max = maxM;
            count =  1;
            isBST = true;
        }
        Point(int minM, int maxM, int countM, boolean isBSTM) {
            min = minM;
            max = maxM;
            count = countM;
            isBST = isBSTM;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return count == point.count &&
                    min == point.min &&
                    max == point.max &&
                    isBST == point.isBST;
        }


    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

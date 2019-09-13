import java.util.Arrays;
import java.util.Stack;

public class StringToTree_leetcode536 {

    public static void main(String[] args) {
        str2tree("4(2(3)(1))(6(5))");
    }

    public static TreeNode str2tree(String s) {
        int[] index = new int[s.length()];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<s.length();i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if(c == ')') {
                index[stack.pop()] = i;
            }
        }
        System.out.println(Arrays.toString(s.toCharArray()));
        System.out.println(Arrays.toString(index));

        TreeNode result = dfs(s, index, 0, s.length()-1);
        System.out.println(result);
        return result;
    }

    public static TreeNode dfs(String s, int[] indexes, int startIndex, int endIndex) {

        int i = startIndex;
        int nodeValue = 0;
        while (Character.isDigit(s.charAt(i))) {
            nodeValue = nodeValue*10+(s.charAt(i)-'0');
            i++;
        }
        TreeNode root = new TreeNode(nodeValue);
        TreeNode left = null;
        TreeNode right = null;

        if(i <= endIndex && s.charAt(i) == '(') {
            left = dfs(s, indexes, i+1, indexes[i]-1);
            i = indexes[i]+1;
        }
        if(i <= endIndex  && s.charAt(i) == '(') {
            right = dfs(s, indexes, i+1, indexes[i]-1);
        }
        root.left = left;
        root.right = right;
        return root;
    }

//    static int index = 0;
//    public static TreeNode dfs1(String s) {
//
//        int nodeValue = 0;
//        while (Character.isDigit(s.charAt(index))) {
//            nodeValue = nodeValue*10+(s.charAt(index)-'0');
//            index++;
//        }
//        TreeNode root  = new TreeNode(nodeValue);
//        if(index < s.length() && s.charAt(index) == ')') {
//            index++;
//            return root;
//        }
//        TreeNode left = null;
//        TreeNode right = null;
//        if(index < s.length() && s.charAt(index) == '(') {
//            index++;
//             left = dfs(s);
//        }
//        if(index < s.length() && s.charAt(index) == '(') {
//            index++;
//             right = dfs(s);
//        }
//        root.left = left;
//        root.right = right;
//        return root;
//    }

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

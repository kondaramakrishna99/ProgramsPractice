import java.util.Stack;

public class LongestValidParenthesis_leetcode32 {

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int max = Integer.MIN_VALUE;
        int left = -1;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='(')
                stack.push(i);
            else {
                if(stack.isEmpty()){
                    left = i;
                    continue;
                }
                stack.pop();
                max = Math.max(max, stack.isEmpty()?i-left:i-stack.peek());
            }
        }
        return max;
    }
}

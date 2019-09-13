import java.util.Stack;

public class LargestRectangle_leetcode84 {

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }

    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for(int i=0;i<heights.length;i++) {
            if(stack.isEmpty()) {
                stack.push(i);
                continue;
            }

            if(heights[i] > heights[stack.peek()]) {
                stack.push(i);
            } else {
                while(!stack.isEmpty()&&heights[stack.peek()]>= heights[i]) {
                    int height = heights[stack.pop()];
                    int width = (! stack.isEmpty()) ? (i-stack.peek()-1) :i;
                    maxArea = Math.max(maxArea, height*width);
                }
                stack.push(i);
            }
        }
        while (!stack.isEmpty()) {
            int height = heights[stack.pop()];
            int width = (! stack.isEmpty()) ? (heights.length-stack.peek()-1) :heights.length;
            maxArea = Math.max(maxArea, height*width);
        }

        return maxArea;
    }

}

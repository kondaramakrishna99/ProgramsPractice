import java.util.Stack;

public class TrappingRainWater_leetcode42 {

    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];

        left[0] = height[0];
        for (int i=1;i<height.length;i++) {
            left[i] = Math.max(left[i-1], height[i]);
        }

        right[height.length-1] = height[height.length-1];
        for (int i=height.length-2;i>=0;i--) {
            right[i] = Math.max(right[i+1], height[i]);
        }

        int result=0;
        for(int i=1;i<height.length-1;i++) {
            result+=Math.min(left[i],right[i])-height[i];
        }
        return result;

    }

    public int trap1(int[] height) {
        int len = height.length;
        int water = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < len; i++) {
            if (stack.isEmpty() || height[stack.peek()] >= height[i]) {
                stack.push(i);
            } else {
                int tmp = stack.pop();
                if (!stack.isEmpty()) {
                    water += (Math.min(height[stack.peek()],height[i])-height[tmp])*(i-stack.peek()-1);
                }
                i--;
            }
        }
        return water;
    }
}

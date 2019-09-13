import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MaxArea_leetcode11 {

    public static void main(String[] args) {
        int[] array = new int[]{1,1,1};
        System.out.println(maxArea(array));
    }
    public static int maxArea(int[] height) {

        int maxArea = Integer.MIN_VALUE;

        int i=0;
        int j = height.length -1;

        while(i<j) {
            maxArea = Math.max(maxArea, (j-i)*Math.min(height[i], height[j]));
            if(height[i]<height[j])
                i++;
            else
                j--;
        }

        return maxArea;
    }


}

import java.util.Arrays;
import java.util.Collections;

public class RotateArray_leetcode189 {

    public static void main(String[] args) {
        int[] nums = {-1,-100,3,99};
        rotate1(nums, 2);
        System.out.println(Arrays.toString(nums));

        int[] nums1 = {1,2,3,4};
        System.out.println(4-1/3);

    }

    public static void rotate1(int[] nums, int k) {
        int count = 0;
        int i= 0;

        while (count < nums.length) {
            int start = i;
            int prev = nums[start];
            do {
                int next = (i+k)%nums.length;
                int temp = nums[next];
                nums[next] = prev;
                i = next;
                prev = temp;
                count++;
                System.out.println(Arrays.toString(nums));
            } while (i != start);
            i++;
        }
    }

























    public static void rotate(int[] nums, int k) {

        int count = 0;
        int i = 0;
        k = k%nums.length;
        int startIndex = 0;
        while (count<nums.length) {
            int startVal = nums[startIndex];
            int temp = nums[startIndex];
            int temp1;
            i = startIndex;
            while (nums[(i+k)%nums.length] != startVal) {
                temp1 = nums[(i+k)%nums.length];
                nums[(i+k)%nums.length] = temp;
                temp = temp1;
                count++;
                i=(i+k)%nums.length;
            }
            nums[(i+k)%nums.length] = temp;
            count++;
            if (count < nums.length-1) {
                startIndex++;
            }
        }
    }
}

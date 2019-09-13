import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RemoveDuplicates_leetcode26 {

    public static void main(String[] args) {
        int[] array = new int[]{0,0,1,1,1,2,2,3,3,4};
//        System.out.println(removeDuplicates(array));
        System.out.println(removeElement(array,1));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length ==0)
            return 0;
        int end = nums.length;
        int start = 1;
        for(int i=1;i<end;i++) {
            if(nums[i]!=nums[i-1]) {
                nums[start] = nums[i];
                start++;
            }
        }
        return  start;
    }

    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length ==0)
            return 0;

        int i=0;
        int end = nums.length-1;
        for(i=0;i<=end;i++) {
            if(nums[i]==val) {
                nums[i] = nums[end];
                nums[end] = val;
                end--;
                i--;
            }
        }
        System.out.println(Arrays.toString(nums));
        return i;
    }
}

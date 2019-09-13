import java.util.Arrays;

public class RemoveDuplicates_leetcode80 {

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,2,3,3};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));

    }

    public static int removeDuplicates(int[] nums) {

        int left = -1;
        int count = 0;
        for (int i=0;i<nums.length;i++) {
            if (i==0) {
               count=1;
               left = 0;
               continue;
            }

            if (nums[i] == nums[i-1] && count <2) {
                nums[left+1] = nums[i];
                left++;
                count++;
            } else if(nums[i]!=nums[i-1]) {
                nums[left+1] = nums[i];
                left++;
                count = 1;
            }
        }
        return left+1;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}

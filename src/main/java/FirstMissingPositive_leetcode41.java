import java.util.Arrays;

public class FirstMissingPositive_leetcode41 {

    public static void main(String[] args) {
        System.out.println( firstMissingPositive(new int[]{1,1}));
    }

    public static int firstMissingPositive(int[] nums) {
        for(int i=0;i<nums.length;i++) {
            if(nums[i]<=0 || nums[i]>nums.length)
                continue;
            if(nums[i]-1!=i && nums[nums[i]-1]!=nums[i]) {
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
                i--;
            }
        }
        System.out.println(Arrays.toString(nums));

        for(int i=0;i<nums.length;i++) {
            if(nums[i]!=i+1)
                return i+1;
        }
        return nums.length+1;
    }
}

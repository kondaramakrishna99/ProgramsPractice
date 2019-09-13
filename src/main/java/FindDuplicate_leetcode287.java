import java.util.Arrays;

public class FindDuplicate_leetcode287 {

    public static void main(String[] args) {
        System.out.println(findDuplicates(new int[]{2,1,2}));
    }

    public static int findDuplicates(int[] nums) {

        for(int i=0;i<nums.length;i++) {
            if(nums[i] == i)
                continue;
            if(nums[i] != i+1) {
                int newIndex = nums[i];
                int indexVal = nums[newIndex];
                if(newIndex+1 == indexVal) {
                    return nums[i];
                }
                nums[newIndex] = nums[i];
                nums[i] = indexVal;
                i--;
            }
        }
        System.out.println(Arrays.toString(nums));
        for(int i=0;i<nums.length;i++) {
            if(nums[i] != i+1) {
                return nums[i];
            }
        }
        return -1;
    }
}

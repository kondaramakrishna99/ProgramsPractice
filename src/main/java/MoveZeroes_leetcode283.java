public class MoveZeroes_leetcode283 {


    public void moveZeroes(int[] nums) {

        int left = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]!=0) {
                nums[left++] = nums[i];
            }
        }
        for(int i=left;i<nums.length;i++) {
            nums[i] = 0;
        }
    }



    public void moveZeroes1(int[] nums) {
        if(nums == null || nums.length<=1)
            return;

        int left =0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]!=0) {
                nums[left] = nums[i];
                left++;
            }
        }

        for(int i=left;i<nums.length;i++) {
            nums[i]=0;
        }
    }
}

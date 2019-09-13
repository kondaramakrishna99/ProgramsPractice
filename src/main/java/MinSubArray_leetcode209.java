public class MinSubArray_leetcode209 {

    public int minSubArrayLen(int s, int[] nums) {

        if(nums == null || nums.length<=0)
            return 0;

        int left = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;

        for (int i=0;i<nums.length;i++) {
            sum += nums[i];
            while (sum>=s) {
                min = Math.min(i-left+1, min);
                sum -= nums[left];
                left++;
            }
        }
        if (sum >= s) {
            min = Math.min(nums.length-left+1, min);
        }
        return min==Integer.MAX_VALUE ? 0 : min;
    }
}

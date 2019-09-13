public class ThirdMax_leetcode414 {

    public int thirdMax(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;

        int max1  = Integer.MIN_VALUE;
        int max2  = Integer.MIN_VALUE;
        int max3  = Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++) {
            int num = nums[i];

            if(num == max1 || num == max2 || num == max3)
                continue;

            if(num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if(num > max2) {
                max3 = max2;
                max2 = num;
            } else if(num > max3) {
                max3 = num;
            }
        }

        return max3 != Integer.MIN_VALUE ? max3 : Math.max(max1, max2);
    }
}

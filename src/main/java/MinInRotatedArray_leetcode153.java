public class MinInRotatedArray_leetcode153 {
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3,4,5,1,2}));
    }

    public static int findMin(int[] nums) {

        if(nums==null || nums.length==0)
            return 0;

        int left=0;
        int right=nums.length-1;

        while(left<right)
        {
            int mid=(left+right)/2;

            if(nums[mid]<nums[right])
            {
                right=mid;
            }
            else if(nums[mid]>nums[right])
            {
                left=mid;
            }

        }
        return nums[left];

    }
}

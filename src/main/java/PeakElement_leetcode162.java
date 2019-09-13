public class PeakElement_leetcode162 {

    public int findPeakElement(int[] nums) {
        int i= 0;
        int j = nums.length - 1;
        if(nums.length <= 1) {return 1;}
        while(i<j) {
            int mid = (i+j)/2;
            if(mid == 0) {
                if ( nums[mid] > nums[mid+1]) {
                    return 0;
                } else
                    return 1;
            }  else {
                if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) {
                    return mid;
                } else if (nums[mid] > nums[mid-1] && nums[mid] < nums[mid+1]) {
                    i = mid+1;
                } else {
                    j = mid - 1;
                }
            }
        }
        return i;
    }


}

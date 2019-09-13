import java.util.Arrays;

public class SearchRotatedArray_leetcode33 {

    public static void main(String[] args) {
//         System.out.println(search(new int[]{3,5,1}, 3));
        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10}, 8)));
    }

    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length -1;
        while (start <= end) {
            int mid = (start+end)/2;
            if(nums[mid] == target)
                return mid;
            if(nums[mid]<nums[end]) {
                if (target>nums[mid] && target<=nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if(target>=nums[start] && target<nums[mid]) {
                    end = mid - 1;
                } else  {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

    public static int[] searchRange(int[] nums, int target) {
        return new int[]{binarySearchLeft(nums, target), binarySearchRight(nums, target)};
    }

    public static int binarySearchLeft(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int left = -1;
        while(start <= end) {
            int mid = (start + end)/2;
            if(nums[mid]==target)
            {
                left = mid;
                end = mid -1;
            }else if(target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return left;
    }

    public static int binarySearchRight(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int left = -1;
        while(start <= end) {
            int mid = (start + end)/2;
            if(nums[mid]==target)
            {
                left = mid;
                start = mid + 1;
            } else if(target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return left;
    }
}

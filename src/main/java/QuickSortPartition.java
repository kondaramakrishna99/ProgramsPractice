import java.util.Arrays;

public class QuickSortPartition {

    public static void main(String[] args) {
        int[] nums = {2, 4,1,0,5,3,6,2,2};
        System.out.println(partition(nums, 0, nums.length-1));
        System.out.println(Arrays.toString(nums));
        medianTogether(nums);

    }

    public static int partition(int[] nums, int left, int right) {

        int pivot = left+1;

        for(int i=left+1;i<=right;i++) {
            if (nums[i]<=nums[left]) {
                swap(nums, pivot, i);
                pivot++;
            }
        }
        swap(nums, pivot-1, left);
        System.out.println(Arrays.toString(nums));
        return pivot-1;
    }

    public static void medianTogether(int[] nums) {
        int j=0;
        int k = nums.length-1;
        int i=0;
        int median = 2;
        while(i<=k) {
            if(nums[i]<median) {
                swap(nums, j, i);
                j++;
                i++;
            } else if (nums[i]> median) {
                swap(nums, i, k);
                k--;
            } else if (nums[i] == median) {
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

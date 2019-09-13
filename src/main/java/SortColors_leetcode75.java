import java.util.Arrays;

public class SortColors_leetcode75 {

    public static void main(String[] args) {
        int[] array = new int[]{2,0,2,1,1,0,1,2,1,0};
        sortColors(array);
        System.out.println(Arrays.toString(array));

    }

    public static void sortColors(int[] nums) {

        int left = 0;
        int right = nums.length-1;
        for (int i=0;i<=right;i++) {
            if(nums[i]==0) {
                swap(nums, i, left);
                left++;
            } else if(nums[i]==2){
                swap(nums,i,right);
                right--;
                i--;
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] =  temp;
    }
}

import java.util.Arrays;

public class MergeSortedArray_leetcode88 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        merge(nums1,3, nums2, 3 );
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m-1;
        int j= n-1;
        int index = m+n-1;
        while(i>=0 || j>=0) {

            int num1 = i>=0 ?nums1[i]:Integer.MIN_VALUE;
            int num2 = j>=0 ? nums2[j] : Integer.MIN_VALUE;

            if(num1 >= num2) {
                nums1[index] = num1;
                index--;
                i--;
            } else {
                nums1[index] = num2;
                index--;
                j--;
            }
        }
    }

}

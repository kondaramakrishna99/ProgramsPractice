public class SingleNumber_leetcode137 {

    public static void main(String[] args) {
        int[] nums = {0,1,0,1,0,1,99};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        int[] digit = new int[32];
        for(int i = 0; i < 32; i++){
            // for each digit, we count the number of appearance in the array
            for (int j = 0; j < nums.length; j++){
                digit[i]+= (nums[j]>>i)&1; // get the value (0 or 1) at ith digit of nums[j]
            }
        }
        int res = 0;
        for (int i =0; i< 32; i++){
            // (digit[i]%3) is mode of 3, if it is not zero, it means the single number has 1 on this digit.
            int d = digit[i]%3 ==0 ? 0: 1;
            res += (d)<<i;
        }
        return res;
    }
}

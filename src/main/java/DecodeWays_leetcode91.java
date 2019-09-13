public class DecodeWays_leetcode91 {

    public static void main(String[] args) {
        System.out.println(numDecodings("12"));
    }

    public static int numDecodings(String s) {
        int[] nums = new int[s.length()+1];

        nums[0] = 1;
        nums[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i=1;i<s.length();i++) {
            int first = Integer.parseInt(s.substring(i,i+1));
            int second = Integer.parseInt(s.substring(i-1,i+1));

            if(first >=1 && first <=9) {
                nums[i+1] += nums[i];
            }

            if(second>=10 && second <=26) {
                nums[i+1] += nums[i-1];
            }
        }
        return nums[nums.length-1];
    }

}

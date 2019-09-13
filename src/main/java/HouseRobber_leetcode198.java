public class HouseRobber_leetcode198 {

    public int rob(int[] nums) {

        int maxNonRob = 0;
        int maxRob = nums[0];

        int prevMaxNonRob = 0;
        int prevMaxRob = nums[0];
        for(int i =1;i<nums.length;i++) {
            maxRob = prevMaxNonRob+nums[i];
            maxNonRob = Math.max(prevMaxNonRob, prevMaxRob);

            prevMaxNonRob = maxNonRob;
            prevMaxRob = maxRob;
        }
        return Math.max(prevMaxRob, prevMaxNonRob);
    }
}

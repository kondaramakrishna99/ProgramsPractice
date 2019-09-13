import java.util.Collections;

public class PredictWinner_leetcode486 {

    public static void main(String[] args) {
        System.out.println(predictTheWinner(new int[]{1, 5, 233, 7}));
    }

    public static boolean predictTheWinner(int[] nums)
    {
        int bestChoice = winner(nums, 0, nums.length-1, 1);
        return bestChoice >= 0;
    }

    private static int winner(int[] nums, int start, int end, int turn) {
        if (start == end) {
            System.out.println("final start:"+ start+ "->"+nums[start]+ " end:"+ end+"->"+nums[end]+" "+turn);
            return turn * nums[start];
        }
        int pickLeft = turn * nums[start] + winner(nums, start+1, end, -turn);
        System.out.println("start:"+ start+ "->"+nums[start]+ " end:"+ end+"->"+nums[end]+" "+turn+" pickLeft "+pickLeft);
        int pickRight = turn * nums[end] + winner(nums, start, end-1, -turn);
        System.out.println("start:"+ start+ "->"+nums[start]+ " end:"+ end+"->"+nums[end]+" "+turn+" pickRight "+pickRight);
        int bestChoice = turn > 0 ? Math.max(pickLeft, pickRight) : Math.min(pickLeft, pickRight);
        System.out.println("start:"+ start+ "->"+nums[start]+ " end:"+ end+"->"+nums[end]+" "+turn+" bestChoice "+bestChoice);
        return bestChoice;
    }
}

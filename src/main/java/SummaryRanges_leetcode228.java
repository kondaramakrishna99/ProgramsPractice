import java.util.ArrayList;
import java.util.List;

public class SummaryRanges_leetcode228 {

    public static void main(String[] args) {
        int[] nums  = {0,2,3,4,6,8,9};
        System.out.println(summaryRanges(nums));
    }

    public static List<String> summaryRanges(int[] nums) {

        int start = nums[0];
        int count =1;
        List<String> result = new ArrayList<>();
        for(int i=1;i<nums.length;i++) {
            if(nums[i] == nums[i-1]+1) {
                count++;
                continue;
            }
            if(count!=1) {
                result.add(start+"->"+nums[i-1]);
            } else {
                result.add(start+"");
            }
            start = nums[i];
            count = 1;
        }
        if(count!=1) {
            result.add(start+"->"+nums[nums.length-1]);
        } else {
            result.add(start+"");
        }

        return  result;


    }
}

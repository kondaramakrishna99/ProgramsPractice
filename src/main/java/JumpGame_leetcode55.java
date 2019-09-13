public class JumpGame_leetcode55 {

    public static void main(String[] args) {
//        System.out.println(canJump(new int[]{2,3,1,1,4}));
        System.out.println(jump(new int[]{2,3,1,1,4}));

    }

    public static boolean canJump(int[] nums) {
        int max_step = nums[0];
        for(int i=1;i<nums.length;i++) {
            if (i > max_step)
                return false;
            max_step = Math.max(nums[i]+i, max_step);
        }
        return true;
    }

    //copied from best code
    public int jump_easy(int[] A) {
        int sc = 0;
        int e = 0;
        int max = 0;
        for(int i=0; i<A.length-1; i++) {
            max = Math.max(max, i+A[i]);
            if( i == e ) {
                sc++;
                e = max;
            }
        }
        return sc;
    }

    public static int jump(int[] nums) {

        int i = 0;
        int count = 0;
        while (i<nums.length-1) {
            int maxJump = nums[i]+i;
            count++;
            if(maxJump>=nums.length-1)
                return count;
            int nextJump = Integer.MIN_VALUE;
            int nextIndex = i;
            for(int j=i+1;j<=maxJump;j++) {
                if (nums[j] + j > nextJump) {
                    nextJump = nums[j] + j;
                    nextIndex = j;
                }
            }
            if(i==nextIndex)
                return  -1;
            i = nextIndex;
        }
        return count;
    }
}

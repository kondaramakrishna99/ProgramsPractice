import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.stream.Collectors;

public class CreateMaxNumber_leetcode321 {

    public static void main(String[] args) {
        Stack<Integer> temp = new Stack<>();
        temp.push(1);
        temp.push(2);
        temp.push(3);
        System.out.println(String.valueOf(temp));
//        System.out.println(getMax(new int[]{3, 4, 6, 5}, 0));
        Random random = new Random();
        System.out.println(random.nextInt(500));
    }

    public static List<Integer> getMax(int[] array, int k) {
        Stack<Integer> stack  = new Stack<>();
        if(k==0)
            return new ArrayList<>();
        if(k>=array.length) {
            return Arrays.stream(array).boxed().collect(Collectors.toList());
        }

        for(int i=0;i<array.length;i++) {
            if(stack.isEmpty()) {
                stack.push(array[i]);
                continue;
            }
            int remaining = k - stack.size();
            if(array[i]<=stack.peek()) {
                if(remaining > 0) {
                    stack.push(array[i]);
                }
            } else {
                int rightInArray = array.length - i - 1;
                while (!stack.isEmpty() && array[i]>stack.peek() && rightInArray >= remaining) {
                    stack.pop();
                    remaining = k - stack.size();
                }
                stack.push(array[i]);
            }
        }
        return new ArrayList<>(stack);
    }

    /*
    https://leetcode.com/problems/create-maximum-number/discuss/77283/Share-my-21ms-java-solution-with-comments
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int get_from_nums1 = Math.min(nums1.length, k);
        int[] ans = new int[k];
        for (int i = Math.max(k - nums2.length, 0); i <= get_from_nums1; i++) {
            int[] res1 = new int[i];
            int[] res2 = new int[k - i];
            int[] res = new int[k];
            res1 = solve(nums1, i);
            res2 = solve(nums2, k - i);
            int pos1 = 0, pos2 = 0, tpos = 0;

            while (res1.length > 0 && res2.length > 0 && pos1 < res1.length && pos2 < res2.length) {
                if (compare(res1, pos1, res2, pos2))
                    res[tpos++] = res1[pos1++];
                else
                    res[tpos++] = res2[pos2++];
            }
            while (pos1 < res1.length)
                res[tpos++] = res1[pos1++];
            while (pos2 < res2.length)
                res[tpos++] = res2[pos2++];

            if (!compare(ans, 0, res, 0))
                ans = res;
        }

        return ans;
    }

    public boolean compare(int[] nums1, int start1, int[] nums2, int start2) {
        for (; start1 < nums1.length && start2 < nums2.length; start1++, start2++) {
            if (nums1[start1] > nums2[start2]) return true;
            if (nums1[start1] < nums2[start2]) return false;
        }
        return start1 != nums1.length;
    }

    public int[] solve(int[] nums, int k) {
        int[] res = new int[k];
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            while (len > 0 && len + nums.length - i > k && res[len - 1] < nums[i]) {
                len--;
            }
            if (len < k)
                res[len++] = nums[i];
        }
        return res;
    }
     */
}

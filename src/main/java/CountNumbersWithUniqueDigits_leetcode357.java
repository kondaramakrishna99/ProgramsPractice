import java.util.Arrays;
import java.util.List;

public class CountNumbersWithUniqueDigits_leetcode357 {

    public static void main(String[] args) {
        System.out.println(countNumbersWithUniqueDigits(2)+ "count");
    }

    public static int countNumbersWithUniqueDigits(int n) {
        boolean[] digits = new boolean[10];
        int num[] = new int[n];
        dfs(n, digits, 0, num);
        System.out.println();
        return count;
    }
    static int count = 0;

    public static void dfs(int n, boolean[] digits, int index, int[] num) {

        print(num, index);
        count++;
        if(index >= n) {
            return;
        }


        int start = index==0 ? 1 : 0;
        for(int i = start;i<digits.length;i++) {
            if(digits[i] == false) {
                num[index] = i;
                digits[i] = true;
                dfs(n, digits, index+1, num);
                digits[i] = false;
            }
        }
    }

    public static void print(int[] num, int index) {
        String res = "";
        for(int i =0 ; i<index;i++) {
            res+=num[i];
        }
        System.out.println(res+ "  "+ Arrays.toString(num));
    }
}

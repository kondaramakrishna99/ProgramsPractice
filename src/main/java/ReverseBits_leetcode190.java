import java.util.Arrays;

public class ReverseBits_leetcode190 {

    public static void main(String[] args) {
        System.out.println(reverseBits(Integer.MAX_VALUE));
    }
    public static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; ++i) {
            result = result<<1  | (n & 1);
            n >>>= 1;
        }
        return result;  }
}

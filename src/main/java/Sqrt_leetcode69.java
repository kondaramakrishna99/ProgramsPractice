import java.util.List;

public class Sqrt_leetcode69 {

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }

    public static int mySqrt(int x) {
        long start = 0;
        long end = x;
        while(start<=end) {
            long mid = start + (end-start)/2;
            if(mid*mid == x || (mid*mid< x && (mid+1)*(mid+1)>x))
                return (int)mid;
            else if(mid*mid < x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}

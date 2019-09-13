import java.util.HashMap;
import java.util.Map;

public class Powxn_leetcode50 {

    public static void main(String[] args) {
//        System.out.println(myPow(0.00001, 2147483647));
        System.out.println(myPow(2, 21));

        //        permute_iterative(new int[]{1,2,3});

    }
    public static double myPow(double x, int n) {

        boolean neg= false;
        if(n < 0) {
            neg=true;
            n=-n;
        }

        Map<Integer, Double> map = new HashMap<>();

        double result = 1;
        map.put(1, x);

        while (n > 0 ) {

            int power = 1;
            double prod = x;
            while(2*power<=n) {
                power+=power;
                prod*=prod;
                map.put(power, prod);
            }
            n = n-power;
            result*=prod;
            if(n%2==1){
                result*=x;
            }
//            n/=2;
            if(map.containsKey(n/2)){
                result*=map.get(n/2);
                break;
            }
        }

        if(neg)
            return  1/result;

        return result;
    }

    public static double myPow1(double x, int n) {

        double res = 1;
        while (n!=0) {
            x*=x;
            if(n%2==1){
                res=res*x;
            }
            n/=2;
        }
        return res;
    }

    public static double myPow2(double x, int n) {
        long m = n > 0 ? n : -(long)n;
        double ans = 1.0;
        while (m != 0) {
            if ((m & 1) == 1)
                ans *= x;
            x *= x;
            m >>= 1;
        }
        return n >= 0 ? ans : 1 / ans;
    }
}

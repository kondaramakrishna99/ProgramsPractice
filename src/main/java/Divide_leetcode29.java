public class Divide_leetcode29 {

    public static void main(String[] args) {
        System.out.println(divide(1,3));
    }

    public static int divide(int dividend, int divisor) {

        int result=0;
        while (dividend>=divisor) {
            int tempDivisor = divisor;
            int tempDividend = dividend;
            int quotient=1;

            while (tempDividend>=2*tempDivisor) {
                tempDivisor = 2*tempDivisor;
                quotient=2*quotient;
            }
            dividend = dividend - tempDivisor;
            result+=quotient;
        }
        return result;
    }
}

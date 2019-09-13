public class NthDigit_leetcode400 {

    public static void main(String[] args) {
        System.out.println(findNthDigit(1000));
    }
    public static int findNthDigit(int n) {
        if(n == 0)
            return 0;
        int digit = 1;
        while(n > 9*Math.pow(10,digit-1)*digit) {
            n = n - (int)(9*Math.pow(10,digit-1)*digit);
            digit++;
        }

        n = n - 1;
        System.out.println(n);
        int add = n / digit;
        int remainder = n%digit;
        int num = (int)Math.pow(10, digit-1) + add;
        return (num+"").charAt(remainder)-'0';
    }
}

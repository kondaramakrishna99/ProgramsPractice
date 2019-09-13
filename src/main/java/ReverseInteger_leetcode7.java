public class ReverseInteger_leetcode7 {

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
        System.out.println(Integer.MAX_VALUE +"  "+Integer.MIN_VALUE);
    }

    public static int reverse(int x) {
        long reverse = 0;
        while(x!=0) {
            if (reverse*10+x%10 > Integer.MAX_VALUE || reverse*10+x%10 < Integer.MIN_VALUE)
                return 0;
            reverse = reverse*10+x%10;
            x=x/10;
            System.out.println(reverse + "  "+x);
        }
        return (int)reverse;
    }

}

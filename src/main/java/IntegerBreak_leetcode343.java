public class IntegerBreak_leetcode343 {

    public static void main(String[] args) {

        for(int i= 0; i< 5; i++) {
            System.out.println(Integer.toBinaryString((int)Math.pow(4,i)));
        }
    }

    public static int integerBreak(int n) {
        if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        }

        int[] products = new int[n+1];
        products[0] = 1;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        for(int i=4;i<=n;i++) {
            for(int j=1;j<i;j++) {
                products[i] = Math.max(products[i], products[j]*products[i-j]);
            }
        }
        return products[n];
    }
}

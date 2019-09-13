public class ConsecutiveOnes {

    public static void main(String[] args) {
        System.out.println(consecOnes(new int[]{1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1}, 1));
    }

    public static int consecOnes(int[] array, int m) {

        if(m>array.length)
            return array.length;

        int left=0,right=-1,max=Integer.MIN_VALUE;
        int zeroes=0;
        for(int i=0;i<array.length;i++) {
            if(array[i]==1) {
//                right++;
                max= Math.max(max, i-left+1);
                continue;
            }
            zeroes++;
            if(zeroes>m) {
                while(array[left]!=0){
                    left++;
                }
                left++;
                zeroes--;
            }
            max= Math.max(max, i-left+1);
        }
        return max;
    }

    public static int[] flip(String str) {

        int left=0;
        int right =0;
        int maxLeft=-1;
        int maxRight = -1;
        int ones=0;
        int zeroes = 0;
        int maxDiff = 0;

        for(int i=0;i<str.length();i++) {
            if(str.charAt(i)=='0')
                zeroes++;
            if(str.charAt(i)=='1')
                ones++;

            if(zeroes-ones<0) {
                left = i+1;
                right=i+1;
                zeroes=0;
                ones=0;
            }
            else {
                if (zeroes - ones > maxDiff) {
                    maxDiff = zeroes - ones;
                    maxLeft = left;
                    maxRight = right;
                }
                right++;
            }
        }
        if(maxLeft >=0) {
            return new int[]{maxLeft+1, maxRight+1};
        }
        return new int[0];
    }


}

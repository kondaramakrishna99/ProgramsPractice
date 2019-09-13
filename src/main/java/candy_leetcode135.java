import java.util.Arrays;

public class candy_leetcode135 {

    public static void main(String[] args) {
        System.out.println(candy(new int[]{1,0,2}));
    }

    public static int candy(int[] ratings) {
        int[] result = new int[ratings.length];

        Arrays.fill(result,1);

        for(int i=1;i<ratings.length;i++) {
            if(ratings[i]>ratings[i-1]) {
                result[i] = result[i-1]+1;
            }
        }
        System.out.println(Arrays.toString(result));

        for(int i=ratings.length-2;i>=0;i--) {
            if(ratings[i]>ratings[i+1]) {
                result[i] = Math.max(result[i], result[i+1]+1);
            }
        }
        System.out.println(Arrays.toString(result));
        int sum=0;
        for(int i:result) {
            sum+=i;
        }
        return sum;
    }
}

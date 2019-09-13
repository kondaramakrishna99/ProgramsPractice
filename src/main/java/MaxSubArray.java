import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MaxSubArray {

    public static void main(String[] args) {
        int[] array = new int[]{-500};
        List<Integer> list =  IntStream.of(array).boxed().collect(Collectors.toList());
//        System.out.println(maxSubArray(list));
//        System.out.println(Arrays.toString(maxset(new int[]{ 0,0,-1,0})));
        System.out.println(maxSet1(new int[]{0,0,-1,0}));
    }

    public static int maxSubArray(final List<Integer> A) {
        int finalMax=A.get(0);
        int maxSum=A.get(0);
        for(int i=1;i<A.size();i++) {
            maxSum = Math.max(A.get(i), maxSum+A.get(i));
            finalMax = Math.max(maxSum, finalMax);
        }
        return finalMax;
    }

    public static int[] maxSet1(int[] A) {
        int left = 0;
        long maxSum = -1;
        long sum = 0;
        int minLeft = -1;
        int length = 0;
        int i;
        for(i=0;i<A.length;i++) {
            if(A[i]<0) {
                if(sum>maxSum){
                    maxSum = sum;
                    length = i - left;
                    minLeft = left;
                } else if (sum==maxSum && length>i-left) {
                    length = i-left;
                    minLeft = left;
                }
                left=i+1;
                sum = 0;
                continue;
            }
            sum = sum+A[i];
        }
        if(sum>maxSum){
            maxSum = sum;
            length = i - left;
            minLeft = left;
        } else if (sum==maxSum && length<i-left) {
            length = i-left;
            minLeft = left;
        }

        if(length == 0)
            return new int[0];

        int[] result = new int[length];
        for(i=0;i<length;i++) {
            result[i] = A[minLeft+i];
        }
        System.out.println(Arrays.toString(result));
        return  result;
    }


}

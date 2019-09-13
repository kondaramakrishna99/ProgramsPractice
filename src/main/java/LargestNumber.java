import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

    public static void main(String[] args) {
        largestNumber(new Integer[]{3, 30, 34, 5, 9});
    }

    public static String largestNumber(Integer[] A) {
        Arrays.sort(A, (i1,i2) -> {
            return (i2+""+i1).compareTo(i1+""+i2);
        });
        System.out.println(Arrays.toString(A));
        StringBuilder result =  new StringBuilder();
        for(int i=0;i<A.length;i++) {
            result.append(A[i]);
        }

        while(result.charAt(0)=='0')
            result.deleteCharAt(0);

        System.out.println(result);
        return result.toString();
    }
}

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PermutationSeq_leetcode60 {

    public static void main(String[] args) {
        System.out.println(getPermutation(4,9));
    }

    public static String getPermutation(int n, int k) {

        k = k-1;
        int[] fact = factorial(n);
        List<Integer> list = IntStream.range(1,n+1).boxed().collect(Collectors.toList());
        String result = "";
        for(int i=n;i>0;i--){
            int index = k/fact[i-1];
            result+=list.remove(index);
            k=k%fact[i-1];
            System.out.println(i+" "+result);
        }
        return result;
    }

    public static int[] factorial(int n) {
        int[] fact = new int[n+1];
        fact[0]=1;

        for(int i=1;i<=n;i++) {
            fact[i] = fact[i-1]*i;
        }

        return fact;
    }


}

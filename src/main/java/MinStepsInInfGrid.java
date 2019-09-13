import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MinStepsInInfGrid {

    public static void main(String[] args) {
        int[] array = new int[]{2, 5, 6, 8, 6, 1, 2, 4, 5};
        ArrayList<Integer> list = (ArrayList)IntStream.of(array).boxed().collect(Collectors.toList());
        System.out.println(plusOne(list));
    }

    public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
        int numSteps = 0;
        for(int i = 1; i < X.size(); i++){
            numSteps += Math.max( Math.abs(X.get(i) - X.get(i-1)), Math.abs(Y.get(i) - Y.get(i-1)) );
        }
        return numSteps;
    }

    public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {

        if(A == null)
            return A;

        int carry = 0;
        int i=A.size()-1;
        for (i=A.size()-1;i>=0;i--) {
            if(A.get(i)<9) {
                A.set(i,A.get(i)+1);
                break;
            }
            A.set(i,0);
        }

        ArrayList<Integer> result = new ArrayList<>();
        if(i==-1)
            result.add(1);
        int start=0;
        for(int j=0;j<A.size();j++) {
            if(A.get(j)!=0) {
                start = j;
                break;
            }
        }
        for(int j=start;j<A.size();j++) {
            result.add(A.get(j));
        }
        return result;
    }

}

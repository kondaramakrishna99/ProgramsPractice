import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MaxAbsDiff {

    public static void main(String[] args) {
        int[] array = new int[]{1,3,-1};
        ArrayList<Integer> list =  (ArrayList)IntStream.of(array).boxed().collect(Collectors.toList());
        System.out.println(maxArr(list));
    }

    public static  int maxArr(ArrayList<Integer> A) {
        if(A==null || A.size()==1)
            return 0;

//        int max = Integer.MIN_VALUE;
//        for(int i=0;i<A.size();i++) {
//            for(int j=i+1;j<A.size();j++) {
//                max = Math.max(max, Math.abs(A.get(i)-A.get(j))+Math.abs(i-j));
//            }
//        }
//
//        return max;

        int[] vals = new int[A.size()];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<A.size();i++) {
            vals[i] = Math.abs(A.get(i)+i);
            max = max > vals[i] ? max : vals[i];
            min = min < vals[i] ? min : vals[i];
        }
//        return Math.abs();
        return 0;
    }

    public class ArrayIndex {
        int index;
        int value;

        ArrayIndex(int i, int v) {
            index = i;
            value = v;
        }
    }


}

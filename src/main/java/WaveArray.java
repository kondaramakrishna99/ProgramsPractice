import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WaveArray {

    public static void main(String[] args) {

        System.out.println(wave(new ArrayList<Integer>(Arrays.asList(1,1,3,4))));
        List<Integer> nums = Arrays.asList(1,2,34);
        Integer[] num = nums.toArray(new Integer[nums.size()]);
        System.out.println(Arrays.toString(num));
    }

    public static ArrayList<Integer> wave(ArrayList<Integer> A) {
        boolean up = true;

        for(int i=0;i<A.size()-1;i++) {
            if(up) {
                if(A.get(i+1)<A.get(i)) {
                    swap(A, i);
                }
            } else {
                if (A.get(i+1)>A.get(i)) {
                    swap(A,i);
                }
            }
            up=!up;
        }
        return A;
    }

    public static void swap(ArrayList<Integer> A, int i) {
        int temp = A.get(i);
        A.set(i, A.get(i+1));
        A.set(i+1, temp);
    }
}

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RepeatedNumber {

    public static void main(String[] args) {
        int[] array = new int[]{3,1,2,5,3};
        ArrayList<Integer> list =  (ArrayList)IntStream.of(array).boxed().collect(Collectors.toList());
        System.out.println(repeatedNumber(list));
    }

    public static ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        Set<Integer> set = IntStream.range(1,A.size()+1).boxed().collect(Collectors.toSet());
        Integer a = 0;
        Integer b;
        for(int i:A) {
            if(set.contains(i)) {
                set.remove(i);
            } else {
                a = i;
            }
        }
        b = set.stream().findFirst().get();
        ArrayList<Integer> result = new ArrayList<>();
        result.add(a);
        result.add(b);
        return result;
    }

}

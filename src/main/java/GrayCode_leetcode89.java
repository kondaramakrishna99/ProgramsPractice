import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GrayCode_leetcode89 {

    public static void main(String[] args) {
        System.out.println(grayCode(3).toString());
    }

    public static List<Integer> grayCode(int n) {
        List<Integer> result =  new ArrayList<>();
        result.add(0);

        for(int i=1;i<=n;i++) {
            List<Integer> temp = new ArrayList<>(result);
            for(int j= result.size()-1;j>=0;j--) {
                temp.add(result.get(j)+(int)Math.pow(2, i-1));
            }
            result = temp;
            System.out.println(result.toString());
        }
        return result;
    }

}

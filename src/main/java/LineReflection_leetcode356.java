import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LineReflection_leetcode356 {

    //https://leetcode.com/problems/line-reflection/discuss/153377/10-ms-and-13-ms-2-Java-Solutions-with-Explanations
    public boolean isReflected(int[][] points) {
        HashMap<Integer,Set<Double>> Ys = new HashMap<>();
        double average=0;  int count=0;
        for(int[] point:points){
            Set<Double> ls = Ys.get(point[1]);
            if(ls==null) ls=new HashSet<>();
            if(ls.contains((double)point[0])) continue;
            ls.add((double)point[0]);  Ys.put(point[1], ls);
            average+=point[0]; count++;
        }
        average/=count;
        for(Set<Double> ls:Ys.values()){
            for(double i:ls) {
                if(i==average) continue;
                double find = 2*average-i;
                if(!ls.contains(find))  return false;
            }
        }
        return true;
    }
}

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision_leetcode399 {

    public static void main(String[] args) {
        String[][] equations = {{"a", "b"}, {"b", "c"}};
        double[] values= {2.0, 3.0};
        String[][] queries = {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
        calcEquation(equations, values, queries);
    }

    public static double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map<String, Double>> equationValues = new HashMap<>();
        for (int i=0;i < equations.length; i++) {
            String num = equations[i][0];
            String den = equations[i][1];
            Double value = values[i];
            Map<String, Double> numMap = equationValues.getOrDefault(num, new HashMap<>());
            numMap.put(den, value);
            equationValues.put(num, numMap);

            Map<String, Double> denMap = equationValues.getOrDefault(den, new HashMap<>());
            denMap.put(num, 1/value);
            equationValues.put(den, denMap);
        }
        System.out.println(equationValues.toString());

        for (String[] query : queries) {
            System.out.println(dfs(query[0], equationValues, new HashSet<>(), query[0], query[1]));
        }
        return null;
    }

    public static double dfs(String num, Map<String, Map<String, Double>> equationValues, Set<String> visited, String queryNum, String queryDen) {

        visited.add(num);
        for(String den: equationValues.get(num).keySet()) {
            if (den.equalsIgnoreCase(queryDen)) {
                return equationValues.get(num).get(den);
            }
            if (!visited.contains(den)) {
                Double val = dfs(den, equationValues, visited, queryNum, queryDen);
                if (val != -1) {
                    return val * equationValues.get(num).get(den);
                }
            }
        }
        visited.remove(num);
        return -1;
    }

}

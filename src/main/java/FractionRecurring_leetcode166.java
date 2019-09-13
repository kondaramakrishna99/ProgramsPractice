import java.util.HashMap;
import java.util.Map;

public class FractionRecurring_leetcode166 {

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(1,2));
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        String result = "" ;
        if(denominator == 0) {
            return String.valueOf(Integer.MAX_VALUE);
        }
        if (numerator%denominator == 0) {
           return numerator/denominator+"";
        }

        if (numerator <0 ^ denominator<0) {
            result="-";
        }
        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);

        if(numerator > denominator) {
            result+=numerator/denominator+".";
        } else {
            result+="0.";
        }

        numerator = numerator % denominator;
        Map<Integer, Integer> map =new HashMap<>();

        while (numerator!=0) {
            if (map.containsKey(numerator)) {
                int index = map.get(numerator);
                result = result.substring(0,index)+"("+result.substring(index)+")";
                return result;
            }
            numerator = numerator * 10;
            int newNum = numerator % denominator;
            int dividedend = numerator / denominator;
            result+=dividedend;
            map.put(numerator/10, result.length()-1);
            numerator = newNum;
        }
        return result;
    }
}

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Ternary_leetcode439 {

    public static void main(String[] args) {
        System.out.println(parseTernary("F?T:F?T?1:2:F?3:4"));
    }

    public static String parseTernary(String expression) {
        Stack<Integer> stack = new Stack<>();
        int[] indexes = new int[expression.length()];
        for(int i=0;i<expression.length();i++) {
            char c = expression.charAt(i);
            if(c == '?') {
                stack.push(i);
            } else if (c == ':') {
                indexes[stack.pop()] = i;
            }
        }
        System.out.println(Arrays.toString(indexes));

        int start = 0;

        while (start < expression.length()-1 && expression.charAt(start+1) == '?') {
            char c = expression.charAt(start);
            if(c == 'T') {
                start = start + 2;
            } else if(c == 'F') {
                start = indexes[start+1]+1;
            }
        }

        return  expression.charAt(start)+"";
    }
}

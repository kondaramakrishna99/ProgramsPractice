import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis_leetcode20 {

    public static void main(String[] args) {
        System.out.println(isValid("([)]"));
    }

    public static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<Character, Character>(){{
            put(')','(');
            put('}','{');
            put(']','[');
        }};

        if(s==null || s.length()==0)
            return true;

        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++) {
            Character c = s.charAt(i);
            if(!map.containsKey(c)) {
                stack.push(c);
            } else if(map.get(c)!=stack.pop()){
                return false;
            }
        }

        return stack.isEmpty();
    }

}

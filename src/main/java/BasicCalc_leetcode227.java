import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BasicCalc_leetcode227 {

    public static void main(String[] args) {
        System.out.println(calculate("5*3-5*4/2+2"));
    }

    public static int calculate(String s) {
        StringTokenizer stringTokenizer = new StringTokenizer(s, "+-*/", true);
        List<String> tokens = new ArrayList<>();

        while(stringTokenizer.hasMoreTokens()){
            tokens.add(stringTokenizer.nextToken());
        }

        System.out.println(tokens.toString());

        Stack<Integer> numsStack = new Stack<>();
        Stack<String> opsStack = new Stack<>();
        for(int i=0;i<tokens.size();i++) {
            String token = tokens.get(i);

            if(Character.isDigit(token.charAt(0))) {
                numsStack.push(Integer.parseInt(token));
                continue;
            }

            calculateStackOps(numsStack, opsStack, token);
            opsStack.push(token);
        }
        calculateStackOps(numsStack, opsStack, "+");

        return numsStack.pop();

    }

    public static void calculateStackOps(Stack<Integer> numsStack , Stack<String> opsStack, String token) {
        while (!opsStack.isEmpty() && isHigherPreceedence(opsStack.peek(), token)) {
            String prevSign = opsStack.pop();
            if (prevSign.equals("+")) {
                numsStack.push(numsStack.pop()+numsStack.pop());
            } else if (prevSign.equals("-")) {
                numsStack.push(-numsStack.pop()+numsStack.pop());
            } else if (prevSign.equals("*")) {
                numsStack.push(numsStack.pop()*numsStack.pop());
            } else if (prevSign.equals("/")) {
                int a = numsStack.pop();
                int b = numsStack.pop();
                numsStack.push(b/a);
            }
        }
    }

    public static boolean isHigherPreceedence(String prevSign, String currSign) {
        if ("*/".contains(prevSign)) {
            return true;
        }
        if ("+-".contains(prevSign) && "*/".contains(currSign)) {
            return false;
        }

        return true;
    }
}

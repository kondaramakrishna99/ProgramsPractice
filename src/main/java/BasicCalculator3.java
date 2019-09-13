import java.util.ArrayList;
import java.util.Stack;

public class BasicCalculator3 {


    public static void main(String[] args) {
        System.out.println(baicCalculator("(2*(3/3+2))"));
    }

    public static int baicCalculator(String str) {


        String operations = "+-*/";
        int currNum = 0;
        Stack<Integer> numsStack = new Stack<>();
        Stack<Character> opsStack = new Stack<>();

        //(2*3-4)+3/(1-5)
        // 34+543
        for(int i=0; i<str.length();i ++)  {
            char ch = str.charAt(i);

            //number case
            if (Character.isDigit(ch)) {
                int start = i;
                while(Character.isDigit(ch)) {
                    i++;
                    if (i>=str.length()) {
                        break;
                    }
                    ch = str.charAt(i);
                }
                currNum = Integer.parseInt(str.substring(start,i));
                numsStack.push(currNum);
                i--;
                continue;
            }

            if (operations.contains(ch+"")) {
                if (opsStack.isEmpty()) {
                    opsStack.push(ch);
                } else {
                    calculateStack(numsStack, opsStack, ch);
                }
                continue;
            }

            if(ch =='(') {
                int matchingIndex = findParenthesis(str, i);
                int resultSubString = baicCalculator(str.substring(i+1, matchingIndex));
                numsStack.push(resultSubString);
                i = matchingIndex;
            }
        }

        calculateStack(numsStack, opsStack, '+');
        return numsStack.pop();

    }

    public static void calculateStack(Stack<Integer> numsStack, Stack<Character> opsStack, char currSign) {
        while(!opsStack.isEmpty() && isHigherPrecendence(opsStack.peek(), currSign)) {
            char sign  = opsStack.pop();
            if(sign == '+') {
                numsStack.push(numsStack.pop()+numsStack.pop());
            } else if(sign == '-') {
                numsStack.push(-numsStack.pop()+numsStack.pop());
            } else if(sign == '*') {
                numsStack.push(numsStack.pop()*numsStack.pop());
            } else if(sign == '/') {
                int a = numsStack.pop();
                int b = numsStack.pop();
                numsStack.push(b/a);
            }

        }
        opsStack.push(currSign);
    }

    public static boolean isHigherPrecendence(char prevSign, char currSign) {
        if("+-".contains(prevSign+"") && "*/".contains(currSign+""))
            return false;

        return true;
    }

    public static int findParenthesis(String str, int i) {
        int count = 1;
        for(int j = i+1; j<str.length();j++) {
            char ch = str.charAt(j);
            if (ch == '(') {
                count++;
            } else if (ch == '-'){
                count --;
                if (count == 0) {
                    return j;
                }
            }
        }
        return str.length();
    }
}

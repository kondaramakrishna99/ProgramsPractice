import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class DiffWaysToAddParenthesis_leetcode241 {

    public static void main(String[] args) {
        String str = "2*32-4*5";
        System.out.println(diffWaysToCompute1("2*32-4*5"));
        StringTokenizer stringTokenizer = new StringTokenizer(str, "+-*", true);
        while(stringTokenizer.hasMoreTokens()) {
            System.out.println(stringTokenizer.nextToken());
        }
        System.out.println(str.chars().noneMatch(c -> c=='*'));

    }



    public List<Integer> diffWaysToCompute(String input) {
        if(input == null || input.length()==0)
            return Arrays.asList();

        if(input.length()==1) {
            return Arrays.asList(Integer.parseInt(input));
        }

        List<Integer> result = new ArrayList<>();
        boolean onlyDigits = true;
        for(int i=0;i<input.length();i++) {
            char c = input.charAt(i);
            if(Character.isDigit(c)) {
               continue;
            }
            onlyDigits = false;
            List<Integer> left = diffWaysToCompute(input.substring(0,i));
            List<Integer> right = diffWaysToCompute(input.substring(i+1));

            for(int j=0;j<left.size();j++) {
                int leftInt = left.get(j);
                for(int k=0;k<right.size();k++) {
                    int rightInt = right.get(k);
                    if(c == '+') {
                        result.add(leftInt+rightInt);
                    } else if(c=='-') {
                        result.add(leftInt-rightInt);
                    } else if(c=='*') {
                        result.add(leftInt*rightInt);
                    }
                }
            }
        }
        if(onlyDigits) {
            return Arrays.asList(Integer.parseInt(input));
        }
        return result;
    }





        public static  List<Integer> diffWaysToCompute1(String input) {
        List<Integer> result = new ArrayList<>();
        if(input == null)
            return null;
        if (input.length() == 1) {
            result.add(Integer.parseInt(input));
            return result;
        }
        if(input.chars().mapToObj(c -> (char)c).noneMatch(c -> (c == '+' || c == '-' || c == '*'))) {
            result.add(Integer.parseInt(input));
            return result;
        }


        for(int i=0;i<input.length();i++) {
            char c = input.charAt(i);
            if (c == '*' || c == '+' || c=='-') {
                List<Integer> left = diffWaysToCompute1(input.substring(0, i));
                List<Integer> right = diffWaysToCompute1(input.substring(i+1));
                for(int numLeft : left) {
                    for (int numRight: right) {
                        if (c=='*') {
                           result.add(numLeft*numRight);
                        } else if (c=='+') {
                            result.add(numLeft+numRight);
                        } else if (c=='-') {
                            result.add(numLeft-numRight);
                        }
                    }
                }
            }
        }
        return result;
    }

}

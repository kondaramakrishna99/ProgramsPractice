import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BasicCalculator_leetcode224 {

    public static void main(String[] args) {
        String str = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(calculate3(str));
    }

    public static int calculate3(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }
        int sum = 0;
        int sign = 1;

        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(ch == '+') {
                sign = 1;
                continue;
            }

            if (ch == '-') {
                sign = -1;
                continue;
            }
            if(Character.isDigit(ch)) {
                int num = 0;
                while (Character.isDigit(ch)) {
                    num = num*10+ch-'0';
                    i++;
                    if(i>=s.length()) {
                        break;
                    }
                    ch = s.charAt(i);
                }
                i--;
                sum = sum+sign*num;
                continue;
            }
            if(ch == '(') {
                int endIndex = getMatchingIndex(s, i);
                sum+=sign*calculate3(s.substring(i+1, endIndex));
                i = endIndex;
            }
        }
        return sum;
    }

    public static int getMatchingIndex(String s, int start) {
        int count=1;
        for(int i=start+1; i<s.length();i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                count++;
            } else if (ch == ')') {
                count--;
            }
            if(count == 0) {
                return i;
            }
        }
        return -1;
    }

    public static int calculate(String s) {
        if(s == null || s.length() == 0)
            return 0;
        s = s.replaceAll("\\s+","");
        String prevSymbol ="+";
        int sum = 0;
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            int j = i;
            if(Character.isDigit(c)) {
                while (j< s.length() && Character.isDigit(s.charAt(j))) {
                    j++;
                }
                int num = Integer.parseInt(s.substring(i,j));
                if(prevSymbol.equals("+")) {
                    sum+=num;
                } else if(prevSymbol.equals("-")) {
                    sum-=num;
                }
                i = j-1;
                continue;
            }

            if (c == '+' || c =='-') {
                prevSymbol = c+"";
                continue;
            }

            if(c == '(') {
                int matchingIndex = findMatching(s, i);
                String str = s.substring(i+1, matchingIndex);
                sum = prevSymbol.equals("+") ? sum+calculate(str) : sum - calculate(str);
                i = matchingIndex;
            }
        }
        return sum;
    }

    public static int findMatching(String s, int i) {

        int count = 1;
        for(int j=i+1;j<s.length();j++) {
            if(s.charAt(j) == '(') {
                count++;
            } else if(s.charAt(j) == ')') {
                count--;
            }
            if(count == 0) {
                return j;
            }
        }
        return s.length()-1;
    }




    public static int calculate1(String s) {
        if(s == null || s.length() == 0)
            return 0;
        s = s.trim().replaceAll("\\s+","");
        StringTokenizer tokenizer = new StringTokenizer(s, " ()+-", true);
        List<String> list = new ArrayList<String>();
        while (tokenizer.hasMoreElements()) {
            list.add(tokenizer.nextToken());
        }
        System.out.println(list.toString());
        return calculate1(list, 0, list.size()-1);
    }

    public static int calculate1(List<String> str, int lowerIndex, int upperIndex) {

        int sum = 0;
        int sign = 1;
        for(int i=lowerIndex;i<=upperIndex;i++) {
            String temp = str.get(i);
            if(temp.equals("(")) {
                int upperIndexStr = getMatching1(str, i);
                sum = sum+sign*calculate1(str, i+1, upperIndexStr-1);
                i = upperIndexStr;
            } else if(temp.equals("+")) {
                sign = 1;
            }  else if(temp.equals("-")) {
                sign = -1;
            } else if(temp.equals(")")){
                continue;
            } else {
                int value = Integer.parseInt(temp);
                sum = sum+sign*value;
            }
        }
        return sum;
    }

    public static int getMatching1(List<String> str, int index) {
        int open=0;
        for(int i=index;i<str.size();i++) {
            if(str.get(i).equals("(")) {
                open++;
            } else if (str.get(i).equals(")")) {
                open--;
                if(open == 0) {
                    return i;
                }
            }
        }
        return str.size()-1;
    }

}

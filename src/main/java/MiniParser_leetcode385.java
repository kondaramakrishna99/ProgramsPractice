import java.util.ArrayList;
import java.util.List;

public class MiniParser_leetcode385 {

    public static void main(String[] args) {
        NestedInteger result = deserialize("[]");
        System.out.println(result.toString());
    }

    public static NestedInteger deserialize(String s) {
        if(s== null || s.length() == 0)
            return new NestedInteger();
        NestedInteger nestedInteger = new NestedInteger();

        for (int i=0; i < s.length();i++) {
            char c= s.charAt(i);

            if (Character.isDigit(c)) {
               int num = 0;
               while (Character.isDigit(c)) {
                   num = num*10+(c-'0');
                   i++;
                   if(i == s.length())
                       break;
                   c = s.charAt(i);
               }
                nestedInteger.setInteger(num);
            }

            if (c == '[') {
                int closedBracketIndex = findMatchingIndex(s, i);
                NestedInteger child = deserialize(s.substring(i+1, closedBracketIndex-1));
                nestedInteger.add(child);
                i = closedBracketIndex;
            }
        }
        return nestedInteger;
    }

    public static int findMatchingIndex(String str, int openIndex) {
        int count = 0;
        int i = openIndex;
        do {
            char c= str.charAt(i);
            if (c == '[') {
                count++;
            } else if (c == ']') {
                count --;
            }
            i++;
        } while (count != 0) ;
        return i;
    }









  // This is the interface that allows for creating nested lists.
  // You should not implement it, or speculate about its implementation
  public interface INestedInteger {
      // Constructor initializes an empty nested list.
//      public NestedInteger();
//
//      // Constructor initializes a single integer.
//      public NestedInteger(int value);

      // @return true if this NestedInteger holds a single integer, rather than a nested list.
      public boolean isInteger();

      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      public Integer getInteger();

      // Set this NestedInteger to hold a single integer.
      public void setInteger(int value);

      // Set this NestedInteger to hold a nested list and adds a nested integer to it.
      public void add(NestedInteger ni);

      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return null if this NestedInteger holds a single integer
      public List<NestedInteger> getList();
  }

    static class NestedInteger {
        private List<NestedInteger> list;
        private Integer integer;

        public NestedInteger(List<NestedInteger> list){
            this.list = list;
        }

        public void add(NestedInteger nestedInteger) {
            if(this.list != null){
                this.list.add(nestedInteger);
            } else {
                this.list = new ArrayList<>();
                this.list.add(nestedInteger);
            }
        }

        public void setInteger(int num) {
            this.integer = num;
        }

        public NestedInteger(Integer integer){
            this.integer = integer;
        }

        public NestedInteger() {
            this.list = new ArrayList();
        }

        public boolean isInteger() {
            return integer != null;
        }

        public Integer getInteger() {
            return integer;
        }

        public List<NestedInteger> getList() {
            return list;
        }

        public String printNi(NestedInteger thisNi, StringBuilder sb){
            if(thisNi.isInteger()) {
                sb.append(thisNi.integer);
                sb.append(",");
            }
            sb.append("[");
            for(NestedInteger ni : thisNi.list){
                if(ni.isInteger()) {
                    sb.append(ni.integer);
                    sb.append(",");
                }
                else {
                    printNi(ni, sb);
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }

}

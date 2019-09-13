import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedIterator_leetcode341 implements Iterator<Integer> {

    public static void main(String[] args) {
        List<NestedInteger> list = new ArrayList<>();
        NestedInteger one = new NestedInteger(1);
        NestedInteger two = new NestedInteger(2);
        list.add(one);
        list.add(one);


        NestedInteger list1 = new NestedInteger(list);

        NestedInteger list2 = new NestedInteger(2);


        List<NestedInteger> original = new ArrayList<>();
        original.add(list1);
        original.add(list2);
        original.add(list1);

//        System.out.println(NestedInteger.printNi(original, new StringBuilder()));

        NestedIterator_leetcode341 obj = new NestedIterator_leetcode341(original);
        System.out.println(obj.next());
        System.out.println(obj.next());
        System.out.println(obj.next());
        System.out.println(obj.next());

    }

    static Stack<Iterator<NestedInteger>> stack = new Stack<>();
    static Integer current = null;

    public NestedIterator_leetcode341(List<NestedInteger> nestedList) {
        if (nestedList != null) {
            stack.push(nestedList.iterator());
        }
    }

    @Override
    public Integer next() {
        return current;
    }


    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            Iterator<NestedInteger> node = stack.peek();

            // This will clear out empty iterators.
            if (!node.hasNext()) {
                stack.pop();
                continue;
            }

            // If the value is an integer, done - load up and return.
            // Otherwise push the current list to the top of the stack and continue.
            NestedInteger value = node.next();
            if (value.isInteger()) {
                current = value.getInteger();
                return true;
            } else {
                stack.push(value.getList().iterator());
            }
        }

        return false;
    }


     public interface NestedIntegerI {

              // @return true if this NestedInteger holds a single integer, rather than a nested list.
             public boolean isInteger();
            // @return the single integer that this NestedInteger holds, if it holds a single integer
            // Return null if this NestedInteger holds a nested list
             public Integer getInteger();

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

        public static String printNi(NestedInteger thisNi, StringBuilder sb){
            if(thisNi.isInteger()) {
                sb.append(thisNi.integer);
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
            sb.substring(0, sb.length()-1);
            sb.append("],");
            return sb.toString();
        }
    }
}

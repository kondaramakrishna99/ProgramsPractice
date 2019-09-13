import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

public class NestedList_leetcode364 {

    public int depthSumInverse(List<NestedInteger> nestedList) {
        List<Integer> levels =  new ArrayList<>();

        Queue<NestedInteger> queue = new LinkedList<>();
        for(NestedInteger nestedInteger : nestedList) {
            queue.add(nestedInteger);
        }

        while(!queue.isEmpty()) {
            int size = queue.size();
            int levelSum = 0;
            for(int i=0;i<size;i++) {
                NestedInteger curr = queue.poll();
                if(curr.isInteger()) {
                    levelSum+=curr.getInteger();
                } else {
                    for(NestedInteger temp : curr.getList()) {
                        queue.add(temp);
                    }
                }
            }
            levels.add(levelSum);
        }

        int depth =1;
        int result = 0;
        for(int i=levels.size()-1;i>=0;i--) {
            result+=depth*levels.get(i);
            depth++;
        }
        return result;

    }

      // This is the interface that allows for creating nested lists.
      // You should not implement it, or speculate about its implementation
      public interface NestedInteger {
//          // Constructor initializes an empty nested list.
//          public NestedInteger();
//
//          // Constructor initializes a single integer.
//          public NestedInteger(int value);

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

}

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class RandomizedSet_leetcode380 {

    Map<Integer, Integer> indexToItemMap = new HashMap<>();
    Map<Integer, Integer> itemToIndexMap = new HashMap<>();
    Random random = new Random();
    /** Initialize your data structure here. */
    public RandomizedSet_leetcode380() {
        Set<Integer> set = new HashSet<>();

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (itemToIndexMap.containsKey(val)) {
            return false;
        }

        int size = indexToItemMap.size();
        indexToItemMap.put(size, val);
        itemToIndexMap.put(val, size);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!itemToIndexMap.containsKey(val)) {
            return false;
        }

        int lastElement = indexToItemMap.get(indexToItemMap.size()-1);
        int indexOfItemToRemove = itemToIndexMap.get(val);
        indexToItemMap.put(indexOfItemToRemove, lastElement);
        itemToIndexMap.put(lastElement, indexOfItemToRemove);
        indexToItemMap.remove(indexToItemMap.size()-1);
        itemToIndexMap.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int n = random.nextInt(indexToItemMap.size());
        return indexToItemMap.get(n);
    }
}

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList_leetcode138 {

    class RandomListNode {
         int label;
         RandomListNode next, random;
         RandomListNode(int x) { this.label = x; }
     };

    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> hashMap = new HashMap<>();
        if(head == null)
            return null;

        RandomListNode tempHead = new RandomListNode(head.label);
        hashMap.put(head, tempHead);
        RandomListNode curr = head;

        while (curr!=null) {
            RandomListNode currClone = hashMap.get(curr);

            if(curr.next!=null) {
                if(!hashMap.containsKey(curr.next)) {
                    hashMap.put(curr.next, new RandomListNode(curr.next.label));
                }
                currClone.next = hashMap.get(curr.next);

            }
            if(curr.random!=null) {
                if(!hashMap.containsKey(curr.random)) {
                    hashMap.put(curr.random, new RandomListNode(curr.random.label));
                }
                currClone.random = hashMap.get(curr.random);
            }
            curr = curr.next;
        }
        return tempHead;
    }
}

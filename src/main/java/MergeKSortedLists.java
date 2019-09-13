import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


public class MergeKSortedLists {

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);

        ListNode node3 = new ListNode(2);
        node3.next = new ListNode(6);

        lists[0]=node1;
        lists[1]=node2;
        lists[2]=node3;

//        ListNode result = mergeKLists(lists);
//        printList(result);
        mergeKListsUsingPQ(lists);

    }

    public static ListNode mergeKListsUsingPQ(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, Comparator.comparing(x -> x.val));
        for(ListNode node:lists) {
            queue.offer(node);
        }
        ListNode tempHead = new ListNode(-1);
        ListNode curr = tempHead;
        while (!queue.isEmpty()) {
            curr.next = queue.poll();
            curr = curr.next;
            System.out.print(curr.val+" ");
            if(curr.next!=null)
                queue.offer(curr.next);
        }
        System.out.println();
        printList(tempHead.next);
        return tempHead.next;

    }

    public static ListNode mergeKLists(ListNode[] lists) {

        ListNode tempHead = new ListNode(-1);
        ListNode curr = tempHead;

        while(curr!=null) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            for(int i=0;i< lists.length;i++) {
                if(lists[i] != null && lists[i].val<min) {
                    min = lists[i].val;
                    index = i;
                }
            }
            if(index==-1)
                break;
            curr.next = lists[index];
            curr = curr.next;
            lists[index] = lists[index].next;
            System.out.print(curr.val+" ");
        }
        System.out.println();
        return tempHead.next;

    }

     public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
     }

    public static void printList(ListNode temp) {
        while(temp != null) {
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }
}

import java.util.Arrays;

public class DeleteDuplicates_leetcode82 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
//        ListNode node4 = new ListNode(2);
//        ListNode node5 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;

        printList(deleteDuplicates(node1));
    }


    public static ListNode deleteDuplicates(ListNode head) {
        ListNode tempHead = new ListNode(-1);
        ListNode pre = tempHead;
        ListNode curr = head;
        pre.next = curr;

        while (curr!=null) {
            if(curr==head) {
                pre = curr;
                curr = curr.next;
                continue;
            }
            if(curr.val!=pre.val) {
                pre.next = curr;
                pre = curr;
            }
            curr = curr.next;

        }
        pre.next = null;
        return tempHead.next;
    }

    public static void printList(ListNode curr) {
        ListNode temp = curr;
        while(temp != null) {
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}

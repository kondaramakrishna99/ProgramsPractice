public class RotateList_leetcode61 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;

        print(node1);
        ListNode result = rotateRight(node1, 4);
        print(result);
    }

    public static ListNode rotateRight(ListNode head, int k) {

        int length = getLength(head);
        k = k%length;
        int index = length - k;
        ListNode curr = head;
        for(int i=0;i<index-1;i++) {
            curr = curr.next;
        }
        ListNode newHead = curr.next;
        curr.next = null;

        ListNode newCurr = newHead;
        while(newCurr.next!=null) {
            newCurr = newCurr.next;
        }
        newCurr.next = head;
        return newHead;
    }

    public static int getLength(ListNode head) {
        int i=0;
        ListNode curr = head;
        while(curr!=null) {
            i++;
            curr = curr.next;
        }
        return i;
    }

    public static void print(ListNode head) {
        ListNode curr = head;
        while(curr!=null) {
            System.out.print(curr.val+" ");
            curr = curr.next;
        }
        System.out.println();
    }
}

public class ReverseKGroup {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode result = reverseKGroup(node1,6);
        printList(result);
        System.out.println();

    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode tempHead = new ListNode(-1);
        ListNode prev = tempHead;
        prev.next = head;
        ListNode curr = head;

        while (curr != null) {
            for(int i=0;i<k && curr!=null;i++){
                curr = curr.next;
            }
            if(curr == null)
                break;
            ListNode startNode = prev.next;
            prev.next = flipK(startNode, curr);
            prev = startNode;
        }
        return tempHead.next;
    }

    public static ListNode flipK(ListNode startNode, ListNode endNode) {
        ListNode prev = endNode;
        ListNode curr = startNode;
        ListNode next;
        while (curr!=null && curr != endNode) {
            next = curr.next;
            curr.next = prev;
            prev  = curr;
            curr = next;
        }
        return prev;
    }

    public static void printList(ListNode curr) {
        while(curr!=null) {
            System.out.println(curr.val+ "  ");
            curr =curr.next;
        }
        System.out.println();
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}

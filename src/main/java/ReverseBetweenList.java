public class ReverseBetweenList {

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

        printList(node1);
        printList(reverseBetween(node1,2,4));
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode tempHead= new ListNode(-1);
        ListNode prev =  tempHead;
        ListNode curr = head;
        prev.next = curr;

        for(int i=1;i<m;i++) {
            curr =curr.next;
            prev = prev.next;
        }
        System.out.println(curr.val+"  "+prev.val);
        ListNode mNode = curr;

        for(int i=m;i<=n;i++) {
            curr = curr.next;
        }
        System.out.println("n+1 val: "+curr.val);

        ListNode nNextNode = curr;

        ListNode tempMnode = mNode;

        ListNode prev1= nNextNode;
        while(tempMnode!=nNextNode) {
            ListNode next = tempMnode.next;
            tempMnode.next = prev1;
            prev1 = tempMnode;
            tempMnode = next;
        }
        prev.next = prev1;
        return tempHead.next;
    }

    public static void printList(ListNode curr) {
        while(curr!=null) {
            System.out.print(curr.val+ "  ");
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


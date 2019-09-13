public class InsertionSort_leetcode147 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
//        ListNode node5 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        node4.next = node5;
        printList(node1) ;
        printList(mergeSort(node1));
//        printList(insertionSortList(node1));

    }


    public static ListNode mergeSort(ListNode head) {

        if(head == null || head.next == null)
            return head;

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(slow);

        ListNode mergeList = merge(left,  right);
        return  mergeList;
    }

    public static ListNode merge(ListNode head1, ListNode head2) {
        ListNode tempHead = new ListNode(-1);
        ListNode curr = tempHead;

        ListNode curr1 = head1;
        ListNode curr2 = head2;

        while (curr1!=null && curr2!=null) {
            if(curr1.val <= curr2.val) {
                curr.next = curr1;
                curr = curr.next;
                curr1 = curr1.next;
            } else {
                curr.next = curr2;
                curr = curr.next;
                curr2 = curr2.next;
            }
        }
        if (curr1 != null) {
            curr.next = curr1;
        } else {
            curr.next = curr2;
        }
        return tempHead.next;
    }


    public static ListNode insertionSortList(ListNode head) {

        if(head == null || head.next == null) {
            return head;
        }

        ListNode curr = head.next;
        ListNode tempHead= new ListNode(-1);
        tempHead.next = head;
        ListNode prev= head;

        while(curr != null) {
            ListNode next = curr.next;

            ListNode newPrev= tempHead;
            ListNode newCurr = tempHead.next;
            while(newCurr != curr) {
                ListNode newCurrNext = newCurr.next;
                if(curr.val < newCurr.val) {
                    newPrev.next = curr;
                    curr.next = newCurr;
                    prev.next = next;
                    break;
                }
                newPrev = newCurr;
                newCurr = newCurrNext;
            }
            if(prev.next != next) {
                prev = curr;
            }
            curr = next;
            printList(tempHead) ;
        }
        return tempHead.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static void printList(ListNode head) {
        ListNode temp = head;
        while(temp != null) {
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }

}

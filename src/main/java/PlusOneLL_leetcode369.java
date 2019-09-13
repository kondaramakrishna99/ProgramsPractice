public class PlusOneLL_leetcode369 {


    public ListNode plusNode(ListNode head) {

        if (head == null)
            return head;

        ListNode reverseListHead = reverseList(head, null);

        ListNode revCurr = reverseListHead;
        int carry = 1;
        while (revCurr != null) {
            int val = revCurr.val;
            if(val == 9) {
                revCurr.val=0;
                carry = 1;
            } else {
                revCurr.val+=1;
                carry = 0;
                break;
            }
            revCurr = revCurr.next;
        }

        head = reverseList(reverseListHead, null);
        if (carry == 1) {
            ListNode tempHead = new ListNode(1);
            tempHead.next = head;
            head = tempHead;
        }

        return head;

    }

    public ListNode reverseList(ListNode head, ListNode tail) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != tail) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}

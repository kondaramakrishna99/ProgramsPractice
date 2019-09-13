public class MergeTwoSortedLists_leetcode21 {

     //     * Definition for singly-linked list.

    class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null && l2==null)
            return null;

        ListNode tempHead = new ListNode(-1);
        ListNode curr = tempHead;
        while(l1 !=null && l2!=null) {
            if(l1.val<=l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if(l2 != null)
            curr.next = l2;
        else if (l1 != null) {
            curr.next = l1;
        }

        return tempHead.next;

    }
}

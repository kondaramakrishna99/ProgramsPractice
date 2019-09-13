public class SortedListToBst_leetcode109 {

    public TreeNode sortedListToBST(ListNode head) {

        if(head == null)
            return null;
        if(head.next == null) {
            return new TreeNode(head.val);
        }


        ListNode prevMid = midPrevNode(head);
        ListNode mid = prevMid.next;
        ListNode midNext = mid.next;
        prevMid.next = null;
        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(midNext);
        return root;
    }

    public ListNode midPrevNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode tempHead = new ListNode(-1);
        ListNode prev = tempHead;
        prev.next = slow;

        while(fast!=null && fast.next!=null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        return prev;
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}

public class AddTwoNumbers_leetcode2 {

    public static void main(String[] args) {
        AddTwoNumbers_leetcode2 obj = new AddTwoNumbers_leetcode2();
        obj.addTwoNumbers(null, null);
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;

        System.out.println(getIntFromList(node1));

        System.out.println("list: ");
        printList(node1);
        printList(reverseList(node1));

        l1 = reverseList(l1);
        l2 = reverseList(l2);
        ListNode tempHead = new ListNode(-1);
        ListNode curr = tempHead;

        int carry=0;
        int sum = 0;
        while(l1!=null || l2!=null) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2val = l2 != null ? l2.val : 0;
            sum = l1Val + l2val + carry;
            ListNode presNode = new ListNode(sum%10);
            carry = sum/10;
            curr.next = presNode;
            curr = curr.next;
            l1 = l1!=null ? l1.next : null;
            l2 = l2!=null ? l2.next : null;
        }
        if (carry != 0) {
            curr.next = new ListNode(carry);
        }
        return tempHead.next;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next== null) {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public void printList(ListNode l1) {
        ListNode temp = l1;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println();

    }

    public int getIntFromList(ListNode l1) {
        if (l1 == null)
            return -1;

        int num=0;
        int pos=1;

        ListNode temp = l1;
        while (l1 != null) {
            num = num + l1.val*pos;
            pos = pos * 10;
            l1= l1.next;
        }

        return num;
    }


     // Definition for singly-linked list.
     class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

}

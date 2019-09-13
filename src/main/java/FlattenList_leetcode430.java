public class FlattenList_leetcode430 {

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {}

        public Node(int _val,Node _prev,Node _next,Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + next +
                    ", child=" + child +
                    '}';
        }
    };
    static Node dummyHead = new Node(-1, null, null, null);
    static Node prev = dummyHead;

    public static void main(String[] args) {
        Node node1 = new Node(1, null, null, null);
        Node node2 = new Node(2, null, null, null);
        Node node3 = new Node(3, null, null, null);
        Node node4 = new Node(4, null, null, null);
        Node node5 = new Node(5, null, null, null);
        Node node6 = new Node(6, null, null, null);
        Node node7 = new Node(7, null, null, null);
        Node node8 = new Node(8, null, null, null);
        Node node9 = new Node(9, null, null, null);
        Node node10 = new Node(10, null, null, null);
        Node node11 = new Node(11, null, null, null);
        Node node12 = new Node(12, null, null, null);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node3.child = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        node8.child = node11;
        node11.next = node12;

        Node result = flatten(node1);
        while (result != null) {
            System.out.print(result.val+"->");
            result = result.next;
        }
    }

    public static Node flatten(Node head) {
        dfs(head);
        Node result = dummyHead.next;
        dummyHead = null;
        System.out.println(result);

        return result;
    }

    public static void dfs(Node curr) {
        if(curr == null)
            return;

        Node next = curr.next;
        Node child = curr.child;

        curr.prev = prev;
        prev.next = curr;
        prev = curr;

        if(curr.child!=null) {
            dfs(curr.child);
            prev.child = null;
            curr.child = null;
        }
        dfs(next);
    }
}

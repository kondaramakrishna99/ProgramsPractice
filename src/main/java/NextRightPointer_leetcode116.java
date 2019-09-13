import java.util.LinkedList;
import java.util.Queue;

public class NextRightPointer_leetcode116 {

   public class TreeLinkNode {
     int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }
  }

    public void connectWithoutExtraMem(TreeLinkNode root) {
        TreeLinkNode curr = root;
        while (curr!=null) {
            TreeLinkNode tempHead = new TreeLinkNode(-1);
            TreeLinkNode prev = tempHead;

            while(curr!=null) {
                if(curr.left!=null) {
                    prev.next = curr.left;
                    prev = prev.next;
                }
                if(curr.right!=null) {
                    prev.next = curr.right;
                    prev = prev.next;
                }
                curr = curr.next;
            }
            curr = tempHead.next;
        }
    }

    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> queue = new LinkedList<>();
        if(root == null)
            return;

        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i=0;i<size;i++) {
                TreeLinkNode curr = queue.poll();
                if(i==size-1) {
                    curr.next = null;
                } else {
                    curr.next = queue.peek();
                }
                if(curr.left!=null) {
                    queue.offer(curr.left);
                }
                if(curr.right!=null) {
                    queue.offer(curr.right);
                }
            }
        }
    }
}

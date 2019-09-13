public class BSTImpl {

    Node root;

    class Node {
        Node left;
        Node right;
        int val;
        int count;
        Node(int val) {
            this.val = val;
            count = 1;
        }
    }

    Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
        } else if(root.val == val) {
            root.count++;
        } else if(root.val < val) {
            root.count++;
            root.right = insert(root.right, val);
        } else if(root.val > val) {
            root.left = insert(root.left, val);
        }
        return root;
    }

    int search(Node root, int val) {
        if (root == null)
            return 0;
        if (root.val == val) {
            return root.count;
        }

        if(root.val < val) {
            return search(root.right, val);
        } else if (root.val > val) {
            return root.count + search(root.left, val);
        }
        return 0;
    }

}

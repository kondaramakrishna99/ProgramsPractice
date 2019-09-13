import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Codec {

    public static void main(String[] args) {
        Node two = new Node(2, new ArrayList<>());
        Node four = new Node(4, new ArrayList<>());
        Node five = new Node(5, new ArrayList<>());
        Node six = new Node(6, new ArrayList<>());
        Node three = new Node(3, Arrays.asList(five, six));
        Node one = new Node(1, Arrays.asList(three, two, four));

        String ser = serialize(one);
        System.out.println(ser);
        Node root  = deserialize(ser);
        System.out.println(root.toString());
    }

    // Encodes a tree to a single string.
    public static String serialize(Node root) {
        if (root == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            if(curr == null) {
                continue;
            }
            sb.append(curr.val).append(",").append(curr.children.size()).append(",");
            for (Node n : curr.children) {
                queue.offer(n);
            }
        }
        return sb.substring(0, sb.length()-1);
    }

    // Decodes your encoded data to tree.
    public static Node deserialize(String data) {
        if(data.equals("null")) {
            return null;
        }

        String[] nodes = data.split(",");
        Node root = new Node(Integer.parseInt(nodes[0]), new ArrayList<>(Integer.parseInt(nodes[1])));
        Queue<Node> queue = new LinkedList<>();
        Queue<Integer> capacity = new LinkedList<>();
        queue.offer(root);
        capacity.add(Integer.parseInt(nodes[1]));

        int j = 2;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            int size = capacity.poll();
            for(int i=0;i<size;i++) {
                Node temp = new Node(Integer.parseInt(nodes[j]), new ArrayList<>(Integer.parseInt(nodes[j+1])));
                curr.children.add(temp);
                queue.offer(temp);
                capacity.offer(Integer.parseInt(nodes[j+1]));
                j+=2;
            }
        }
        return root;
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", children=" + children +
                    '}';
        }
    };
}

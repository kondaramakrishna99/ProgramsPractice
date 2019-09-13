import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.TreeMap;

public class Codec_leetcode428 {

    public static void main(String[] args) {
        Node node1 = new Node(1, new ArrayList<>());
        Node node2 = new Node(2, new ArrayList<>());
        Node node3 = new Node(3, new ArrayList<>());
        Node node4 = new Node(4, new ArrayList<>());
        Node node5 = new Node(5, new ArrayList<>());
        Node node6 = new Node(6, new ArrayList<>());
        node1.children.add(node3);
        node1.children.add(node2);
        node1.children.add(node4);
        node3.children.add(node5);
        node3.children.add(node6);
        System.out.println("ser: "+serialize(node1));
        System.out.println("ser1: "+serialize1(node1));
        Node result = deserialize(serialize(node1));
        System.out.println(result.toString());
        TreeMap<Integer, Integer> starts = new TreeMap<>();
    }

    public static String serialize(Node root) {

        if (root == null) {
            return "";
        }
        String result = "";

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            Node temp = queue.poll();
            result+=temp.val+","+temp.children.size()+",";
            queue.addAll(temp.children);
        }
        result=result.substring(0, result.length()-1);
        return  result;
    }

    public static Node deserialize(String data) {
        if (data.equals("")) {
            return null;
        }

        String[] array = data.split(",");
        Queue<Node> queue = new LinkedList<>();
        Queue<Integer> intQueue = new LinkedList<>();

        Node root = new Node(Integer.parseInt(array[0]), new ArrayList<>());
        queue.add(root);
        intQueue.add(Integer.parseInt(array[1]));

        int j=2;
        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            int size = intQueue.poll();
            for(int i=0; i<size;i++) {
                Node temp = new Node(Integer.parseInt(array[j]), new ArrayList<>());
                curr.children.add(temp);
                queue.add(temp);
                intQueue.add(Integer.parseInt(array[j+1]));
                j+=2;
            }
        }

        return root;
    }

    public static String serialize1(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        String result= "";
        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            if(curr == null){
                continue;
            }
            result+=curr.val+","+curr.children.size()+",";
            for(Node child : curr.children) {
                queue.offer(child);
            }
        }
        System.out.println(result.substring(0, result.length()-1));
        return result;
    }

    public static Node deser(String ser) {

        String[] array = ser.split(",");
        Queue<Node> queue = new LinkedList<>();
        Queue<Integer> count = new LinkedList<>();

        Node root = new Node(Integer.parseInt(array[0]),  new ArrayList<>());
        int size = Integer.parseInt(array[1]);
        queue.offer(root);
        count.offer(size);
        int index = 2;
        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            size = count.poll();

            for(int i= 0; i< size; i++) {
                Node temp = new Node(Integer.parseInt(array[index++]),  new ArrayList<>());
                queue.offer(temp);
                count.offer(Integer.parseInt(array[index++]));
                curr.children.add(temp);
            }
        }
        return root;
    }

    // Encodes a tree to a single string.
    public static String serialize2(Node root) {
        List<String> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            if(curr != null) {
                result.add(curr.val+"");
                for(Node child : curr.children) {
                    queue.add(child);
                }
                queue.add(null);
            } else {
                result.add("null");
            }
        }
        return String.join(",", result);
    }

    // Decodes your encoded data to tree.
    public static Node deserialize2(String data) {
        String[] values = data.split(",");
        int i = 0;
        Queue<Node> queue = new LinkedList<>();
        Node root = new Node(Integer.parseInt(values[0]), new ArrayList<>());
        queue.add(root);
        i++;
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            while (!values[i].equals("null")) {
                Node temp = new Node(Integer.parseInt(values[i]), new ArrayList<>());
                curr.children.add(temp);
                queue.add(temp);
                i++;
            }
            i++;
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

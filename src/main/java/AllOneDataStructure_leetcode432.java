
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AllOneDataStructure_leetcode432 {

    class Node {
        Node pre;
        Node next;
        int count;
        Set<String> set;

        Node() {

        }

        Node(int count, String key) {
            this.count = count;
            set = new HashSet<>();
            set.add(key);
        }
    }

    class DLLNode {
        Node head;
        Node tail;
        int len;
        DLLNode() {
            head = new Node(-1, "");
            tail = new Node(Integer.MAX_VALUE, "");
            head.next = tail;
            tail.pre = head;
        }

        void insert(Node newNode, Node next) {
            Node prev = next.pre;
            prev.next = newNode;
            newNode.pre = prev;
            newNode.next = next;
            next.pre = newNode;
            len++;
        }

        void remove(Node removeNode) {
            Node pre = removeNode.pre;
            Node next = removeNode.next;
            pre.next = next;
            next.pre = pre;
            len--;
        }
    }

    Map<String, Node> map = new HashMap<>();
    DLLNode dllNode = new DLLNode();

    public AllOneDataStructure_leetcode432() {
    }

    public void inc(String key) {
        if(!map.containsKey(key)) {
            if(dllNode.head.next.count == 1) {
                dllNode.head.next.set.add(key);
                map.put(key, dllNode.head.next);
            } else {
                Node newNode = new Node(1, key);
                dllNode.insert(newNode, dllNode.head.next);
                map.put(key, newNode);
            }
        } else {
            Node node = map.get(key);
            int count = node.count;
            node.set.remove(key);
            if (node.set.isEmpty()) {
                dllNode.remove(node);
            }
            if(node.next.count == count+1) {
                node.next.set.add(key);
                map.put(key, node.next);
            } else {
                Node newNode = new Node(count+1, key);
                dllNode.insert(newNode, node.next);
                map.put(key, newNode);
            }
        }
    }

    public void dec(String key) {
        Node node = map.get(key);
        int count = node.count;
        node.set.remove(key);
        if(node.set.isEmpty()) {
            dllNode.remove(node);
        }
        count--;
        if(count == 0) {
            map.remove(key);
        } else if(count == node.pre.count){
            node.pre.set.add(key);
            map.put(key, node.pre);
        } else {
            Node newNode = new Node(count, key);
            dllNode.insert(newNode, node.pre.next);
            map.put(key, newNode);
        }
    }

    public String getMaxKey() {
        if (dllNode.len!=0) {
            Node node = dllNode.tail.pre;
            for(String key : node.set) {
                return key;
            }
        }
        return "";
    }

    public String getMinKey() {
        if (dllNode.len!=0) {
            Node node = dllNode.head.next;
            for(String key : node.set) {
                return key;
            }
        }
        return "";
    }

}

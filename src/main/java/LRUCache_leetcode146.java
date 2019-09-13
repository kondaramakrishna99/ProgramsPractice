import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRUCache_leetcode146 {

    public static void main(String[] args) {
        LRUCache_leetcode146 cache = new LRUCache_leetcode146(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }

    Map<Integer, Integer> map = new HashMap<>();
    DoubleLinkedList list;
    int capacity;

    public LRUCache_leetcode146(int capacity) {
        this.capacity = capacity;
        list = new DoubleLinkedList(capacity);
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            int index = list.indexOf(key);
            list.remove(index);
            list.add(key);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key,value);
            int index = list.indexOf(key);
            list.remove(index);
            list.add(key);
        }
        if(map.size()>=capacity) {
            int key1 = list.remove(0);
            map.remove(key1);
        }
        map.put(key,value);
        list.add(key);
    }

    class DoubleLinkedList {
        Node head;
        Node tail;
        DoubleLinkedList(int value) {
            head = new Node(value);
            tail = head;
        }

        void add(int value) {
            Node tempNode = new Node(value);
            if (tail == null) {
                tail = tempNode;
                head = tempNode;
                return;
            }
            tail.next = tempNode;
            tempNode.prev = tail;
            tail = tail.next;
        }

        int indexOf(int value) {
            Node curr = head;
            int index = 0;
            while(curr!=null) {
                if(curr.value == value) {
                    return index;
                }
                curr = curr.next;
                index++;
            }
            return -1;
        }

        int remove(int index) {
            if(index==0) {
                int value = head.value;
                head = head.next;
                if(head == null)
                    tail = head;
                return value;
            }
            Node curr = head;
            int currIndex = 0;
            while(curr!=null) {
                if(currIndex == index) {
                    Node prev = curr.prev;
                    Node next = curr.next;
                    prev.next = next;
                    next.prev = prev;
                    return curr.value;
                }
                curr = curr.next;
                index++;
            }
            return -1;
        }

    }

    class Node {
        int value;
        Node prev;
        Node next;
        Node(int v) {
            value = v;
        }
    }
}

/**
 * Created by Ealing on 3/27/18.
 */
import java.util.*;

class LRU {
    Node head;
    Node tail;
    Map<Integer, Node> map;
    int size;
    int count;

    public LRU(int capacity) {
        head = new Node(0,0);
        tail = new Node(0,0);
        map = new HashMap<>();

        head.next = tail;
        tail.pre = head;

        size = 0;
        count = capacity;
    }

    public int get(int key) {
        System.out.println(key);
        if (!map.containsKey(key)) {
            return -1;
        } else {
            Node node = map.get(key);
            moveToHead(node);

            return node.val;
        }
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);
        map.put(key, node);
        size++;

        if (size > count) {
            Node pop = popTail();
            map.remove(pop.key);
            size--;
        }
    }

    public void addNode(Node node) {
        Node origH = head.next;

        head.next = node;
        node.pre = head;

        node.next = origH;
        origH.pre = node;
    }

    public Node popTail() {
        Node pop = tail.pre;
        pop.pre.next = tail;
        tail.pre = pop.pre;

        return pop;
    }

    public void moveToHead(Node node) {
        Node before = node.pre;
        Node after = node.next;

        before.next = after;
        after.pre = before;

        addNode(node);
    }
}

class Node {
    int key;
    int val;
    Node pre;
    Node next;
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
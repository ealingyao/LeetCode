/**
 * Created by Ealing on 4/3/18.
 */

import java.util.*;

public class LongBenchSeat {
    int size;
    PriorityQueue<Node> pq;

    public LongBenchSeat(int[] arr) {
        size = arr.length;
        pq = new PriorityQueue<>(size, (o1, o2) ->(o2.range-o1.range));

        int left = -1;
        for (int i = 0; i < size; i++) {
            if (arr[i] == 1) {
                pq.offer(new Node(left, arr[i]));
                left = arr[i];
            }
        }
        pq.offer(new Node(left, size));
    }

    public int setSeat() {
        Node node = pq.poll();
        int res;
        if (node.range == 1) {
            res = -1;
        } else if (node.left == -1) {
            res = 0;
            pq.offer(new Node(0, node.right));
        } else if (node.right == size) {
            res = size-1;
            pq.offer(new Node(node.left, size-1));
        } else {
            res = (node.right-node.left)/2;
            pq.offer(new Node(node.left, res));
            pq.offer(new Node(res, node.right));
        }

        return res;
    }

    class Node {
        int left;
        int right;
        int range;
        public Node(int left, int right) {
            this.left = left;
            this.right = right;
            range = right-left;

            if (left == -1 || right == size) {
                range = (range-1)*2;
            }
        }
    }
}
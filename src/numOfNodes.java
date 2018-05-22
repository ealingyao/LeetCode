import java.util.*;

/**
 * Created by Ealing on 4/17/18.
 */
public class numOfNodes {
    public int numOf(DLinkedNode[] list) {
        final int len = list.length;
        Map<DLinkedNode, DLinkedNode> map = new HashMap<>();
        Map<DLinkedNode, Integer> weight = new HashMap<>();
        int count = 0;

        for (int i = 0; i < len; i++) {
            map.put(list[i], list[i]);
            weight.put(list[i], 1);
        }

        for (int i = 0; i < len; i++) {
            if (list[i].next != null) {
                union(list[i], list[i].next, map, weight);
            }
        }

        int res = 0;
        Set<DLinkedNode> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            DLinkedNode root = find(list[i], map);
            if (!set.add(root)) {
                res++;
            }
        }

        return res;
    }

    public void union (DLinkedNode n1, DLinkedNode n2, Map<DLinkedNode, DLinkedNode> map, Map<DLinkedNode, Integer> weight) {
        DLinkedNode root1 = find(n1, map);
        DLinkedNode root2 = find(n2, map);

        if (root1 != root2) {
            int weight1 = weight.get(root1);
            int weight2 = weight.get(root2);

            if (weight1 < weight2) {
                map.put(root1, root2);
                weight.put(root2, weight1+weight2);
            } else {
                map.put(root2, root1);
                weight.put(root1, weight1+weight2);
            }
        }

    }

    public DLinkedNode find(DLinkedNode node, Map<DLinkedNode, DLinkedNode> map) {
        while (map.get(node) != node) {
            map.put(node, map.get(map.get(node)));
            node = map.get(node);
        }

        return node;
    }

    class DLinkedNode {
        int value;
        DLinkedNode next;
        DLinkedNode pre;
        DLinkedNode(int value) {
            this.value = value;
        }
    }
}

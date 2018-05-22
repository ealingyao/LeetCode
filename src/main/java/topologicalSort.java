/**
 * Created by Ealing on 4/17/18.
 */
import java.util.*;

public class topologicalSort {
    public List<String> sort(List<List<String>> list) {
        Map<String, Node> map = new HashMap<>();
        List<Node> nodes = buildGraph(list, map);

        return runGraph(nodes, map);
    }

    private List<Node> buildGraph(List<List<String>> list, Map<String, Node> map) {
        List<Node> nodes = new ArrayList<>();
        for (List<String> l: list) {
            for (int i = 0; i < l.size(); i++) {
                if (!map.containsKey(l.get(i))) {
                    String s = l.get(i);
                    map.put(s, new Node(s));
                    nodes.add(map.get(s));
                }

                if (i >= 1) {
                    map.get(l.get(i-1)).children.add(map.get(l.get(i)));
                }
            }
        }

        return nodes;
    }

    private List<String> runGraph(List<Node> nodes, Map<String, Node> map) {
        List<String> res = new ArrayList<>();
        for (Node node: nodes) {
            if (dfs(res, node, new HashSet<String>(), new HashSet<String>())) {
                return new ArrayList<>();
            }

        }

        return res;
    }

    private boolean dfs(List<String> res, Node node, Set<String> visited, Set<String> circle) {
        if (visited.contains(node.val)) {
            return false;
        }

        if (circle.contains(node.val)) {
            return true;
        }

        visited.add(node.val);
        circle.add(node.val);
        for (Node child: node.children) {
            dfs(res, child, visited, circle);
        }

        res.add(node.val);
        circle.remove(node.val);

        return false;
    }

    class Node {
        String val;
        List<Node> children = new ArrayList<>();
        Node (String val) {
            this.val = val;
        }
    }
}

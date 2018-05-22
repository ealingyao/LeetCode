/**
 * Created by Ealing on 4/2/18.
 */
import java.util.*;

public class courseSchedule {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        Node[] nodes = buildGraph(numCourses, prerequisites);
        return walkGraph(nodes);
    }

    private static Node[] buildGraph(int num, int[][] pre) {
        Node[] nodes = new Node[num];
        for (int i = 0; i < num; i++) {
            nodes[i] = new Node(i);
        }

        for (int[] p: pre) {
            nodes[p[1]].children.add(nodes[p[0]]);
        }

        return nodes;
    }

    private static int[] walkGraph(Node[] nodes) {
        List<Integer> res = new LinkedList<>();
        boolean[] visited = new boolean[nodes.length];
        boolean[] circle = new boolean[nodes.length];
        int[] ret = new int[nodes.length];

        for (Node node: nodes) {
            if (dfs(res, node, visited, circle)) {
                return ret;
            }
        }

        for (int i = 0; i < ret.length; i++) {
            ret[i] = res.get(i);
        }

        return ret;
    }

    //return true if circle
    private static boolean dfs(List<Integer> res, Node node, boolean[] visited, boolean[] circle) {
        if (circle[node.val]) {
            return true;
        }

        if (visited[node.val]) {
            return false;
        }

        visited[node.val] = true;
        circle[node.val] = true;
        for (Node child: node.children) {
            if (dfs(res, child, visited, circle)) {
                return true;
            }
        }

        res.add(0, node.val);
        circle[node.val] = false;

        return false;
    }

    static class Node {
        int val;
        List<Node> children = new ArrayList<>();
        public Node(int x) {
            this.val = x;
        }
    }
}

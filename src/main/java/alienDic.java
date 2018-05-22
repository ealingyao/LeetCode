/**
 * Created by Ealing on 3/28/18.
 */

import java.util.*;

public class alienDic {
    public static String alienOrder(String[] words) {
        List<Node> nodes = buildGraph(words);

        return runGraph(nodes);
    }

    private static List<Node> buildGraph(String[] words) {
        List<Node> nodes = new ArrayList<>();
        Map<Character, Node> map = new HashMap<>();

        for (String word: words) {
            for (char ch: word.toCharArray()) {
                if (!map.containsKey(ch)) {
                    Node node = new Node(ch);
                    map.put(ch, node);
                    nodes.add(node);
                }
            }
        }

        for (int i = 1; i < words.length; i++) {
            String pre = words[i-1];
            String cur = words[i];

            int index = 0;
            while (index < pre.length() && index < cur.length()) {
                if (pre.charAt(index) != cur.charAt(index)) {
                    map.get(pre.charAt(index)).children.add(map.get(cur.charAt(index)));
                    break;
                }
                index++;
            }
        }

        return nodes;
    }

    private static String runGraph(List<Node> nodes) {
        boolean[] visited = new boolean[26];
        boolean[] circle = new boolean[26];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nodes.size(); i++) {
            if (dfs(nodes.get(i), visited, circle, sb)) {
                return "";
            }
        }

        return sb.toString();
    }

    private static boolean dfs(Node node, boolean[] visited, boolean[] circle, StringBuilder sb) {
        if (visited[node._val-'a']) {
            return false;
        }

        if (circle[node._val-'a']) {
            return true;
        }

        visited[node._val-'a'] = true;
        circle[node._val-'a'] = true;

        for (Node child: node.children) {
            if (dfs(child, visited, circle, sb)) {
                return true;
            }
        }
        sb.insert(0, node._val);
        circle[node._val-'a'] = false;

        return false;
    }

    static class Node {
        char _val;
        List<Node> children = new ArrayList<>();
        Node(char val) {
            _val = val;
        }
    }

    public static void main(String[] args) {
        String[] s = {"z", "x", "z"};
        System.out.print(alienOrder(s));
    }
}

/**
 * Created by Ealing on 4/26/18.
 */
import java.util.*;

public class wangweijicheng {
    Map<String, Node> map;
    Node root;

    wangweijicheng() {
        root = new Node("Who", true);
        map = new HashMap<>();
    }

    public void birth(String parent, String child) {
        Node par = map.get(parent);
        Node nChild = new Node(child, true);
        map.put(child, nChild);

        par.children.add(map.get(child));
    }

    public void death(String person) {
        map.get(person).alive = false;
    }

    public List<String> whoIsNext() {
        List<String> res = new ArrayList<>();
        helper(root, res);

        return res;
    }

    private void helper(Node node, List<String> res) {
        if (node.alive) {
            res.add(node.name);
        }

        for (Node child: node.children) {
            helper(child, res);
        }
    }

    class Node {
        String name;
        boolean alive;
        Node parent;
        List<Node> children = new ArrayList<>();
        Node (String name, boolean alive) {
            this.name = name;
            this.alive = alive;
        }
    }
}

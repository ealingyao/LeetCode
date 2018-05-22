/**
 * Created by Ealing on 4/17/18.
 */
public class kBST {
    public int findK (Node root, int k) {
        Node node = root;
        int count = k;

        while (count >= 0) {
            if (node.count == count) {
                break;
            } else if (count < node.count) {
                node = node.left;
            } else {
                count = count-node.count-1;
                node = node.right;
            }
        }

        return node.val;
    }

    class Node {
        int val;
        int count;
        Node left;
        Node right;
        Node (int val, int count) {
            this.val = val;
            this.count = count;
        }
    }
}

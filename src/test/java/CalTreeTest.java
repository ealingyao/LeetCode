import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.*;

/**
 * Created by Ealing on 5/22/18.
 */
public class CalTreeTest {
    @Test
    public void test() {
        CalTree calTree = new CalTree();
        CalTree.TreeNode root = calTree.buildCalTree("(3*(5-4))+((-6)/2)");

        printTree(root);
    }

    private void printTree(CalTree.TreeNode root) {
        Queue<CalTree.TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                CalTree.TreeNode node = queue.poll();
                sb.append(node.val).append(",");

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            System.out.println(sb.toString());
        }
    }
}
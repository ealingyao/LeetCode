import java.util.Stack;

/**
 * "(3*(5-4))+((-6)/2)"
 *
 * 0. '(' continue
 * 1. digits: sb.append
 * 2. operator
 */
public class CalTree {
    public TreeNode buildCalTree(String s) {
        if (s == null || s.length() == 0) {
            return new TreeNode(null);
        }

        Stack<TreeNode> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean sign = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                sb.append(ch);
                sign = true;
            } else {
                if (sb.length() != 0) {
                    stack.push(new TreeNode(sb.toString()));
                    sb = new StringBuilder();
                }

                if (ch == '(' || ch == ' ') {
                    continue;
                } else if (ch == ')') {
                    TreeNode right = stack.pop();
                    TreeNode node = stack.pop();

                    node.right = right;
                    stack.push(node);
                } else {
                    TreeNode node = new TreeNode(ch+"");

                    if (sign) {
                        node.left = stack.pop();

                    }

                    sign = false;
                    stack.push(node);
                }

            }
        }

        if (stack.size() == 2) {
            TreeNode right = stack.pop();
            TreeNode node = stack.pop();

            node.right = right;
            stack.push(node);
        }

        return stack.pop();
    }

    class TreeNode {
        String val;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode (String val) {
            this.val = val;
        }
    }
}

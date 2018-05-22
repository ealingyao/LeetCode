/**
 * Created by Ealing on 4/29/18.
 */

import java.util.*;
public class sumOfBST {
    public int getSumOfBST(TreeNode root, int low, int hi) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        if (root.val <= hi && root.val > low) {
            sum += root.val;
        }
        sum = getSumOfBST(root.left, low, hi) + getSumOfBST(root.right, low, hi) + sum;

        return sum;
    }



    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode (int val) {
            this.val = val;
        }
    }
}

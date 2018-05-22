/**
 * Created by Ealing on 4/25/18.
 */

import java.util.*;
/*
 * pre  [3, 9,20,15,7]
 * post [9,15, 7,20,3]
 */
public class preAndPost {
    int index = 0;
    public TreeNode prePostBuilder(int[] pre, int[] post) {
        int m = pre.length;
        int n = post.length;

        if (m != n || n == 0) {
            return null;
        }

        return helper(pre, post, 0, n-1, n);
    }

    private TreeNode helper(int[] pre, int[] post, int start, int end, int n) {
        if (end < start) {
            return null;
        }

        TreeNode cur = new TreeNode(pre[index]);
        index++;
        if (index == n) {
            return cur;
        }

        int cut = start;
        for (int i = start; i <= end; i++) {
            if (post[i] == pre[index]) {
                cut = i;
                break;
            }
        }

        if (cut <= end) {
            cur.left = helper(pre, post, start, cut, n);
            cur.right = helper(pre, post, cut+1, end, n);
        }

        return cur;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int val) {
            this.val = val;
        }
    }
}

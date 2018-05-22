/**
 * Created by Ealing on 4/3/18.
 */
import java.util.*;

public class maxProd {
    public static int maxProduct(int[] nums) {
        Node res = new Node(nums[0], 0, 0);
        Node max = new Node(nums[0], 0, 0);
        Node min = new Node(nums[0], 0, 0);

        for (int i = 1; i < nums.length; i++) {
            Node tmp = new Node(max.val, max.start, max.end);
            max.val = Math.max(nums[i], Math.max(nums[i]*max.val, nums[i]*min.val));
            if (max.val == nums[i]) {
                max.start = i;
            } else if (max.val == nums[i]*min.val) {
                max.start = min.start;
            }
            max.end = i;

            min.val = Math.min(nums[i], Math.min(nums[i]*tmp.val, nums[i]*min.val));
            if (min.val == nums[i]) {
                min.start = i;
            } else if (min.val == nums[i]*tmp.val) {
                min.start = tmp.start;
            }
            min.end = i;

            if (res.val < max.val) {
                res = new Node(max.val, max.start, max.end);
            }
        }

        int i = res.start;
        int j = res.end;
        int ret = nums[i];
        System.out.println(i+":"+j);
        for (int k = i+1; k <= j; k++) {
            ret *= nums[k];
        }

        return ret;
    }

    static class Node {
        int val;
        int start;
        int end;
        public Node(int val, int start, int end) {
            this.val = val;
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        int[] list = {-3, -4, -2};
        System.out.print(maxProduct(list));
    }
}

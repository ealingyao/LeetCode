/**
 * Created by Ealing on 3/28/18.
 */
import java.util.*;

public class rangeSum {
    int[] nums;
    int[] tree;

    public rangeSum(int[] nums) {
        this.nums = nums;
        int sum;
        tree = new int[nums.length+1];

        for (int i = 1; i < tree.length; i++) {
            int lowbit = i&(i^(i-1));
            sum = 0;
            for (int j = i; j > i-lowbit; j--) {
                sum += nums[j-1];
            }
            tree[i] = sum;
        }
    }

    public void update(int i, int val) {
        int tmp = val-nums[i];
        nums[i] = val;

        for (int j = i+1; j < tree.length; j += j&(j^(j-1))) {
            tree[j] += tmp;
        }
    }

    public int sum(int i, int j) {
        return getSum(j)-getSum(i-1);
    }

    public int getSum(int i) {
        int sum = 0;

        while (i > 0) {
            sum += tree[i];
            i  = i-(i&(i^(i-1)));
        }

        return sum;
    }
}

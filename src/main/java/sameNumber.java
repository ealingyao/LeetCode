/**
 * Created by Ealing on 4/23/18.
 */
import java.util.*;

public class sameNumber {
    public static boolean isSameNumber(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            } else {
                if (i - map.get(nums[i]) < k) {
                    return true;
                } else {
                    map.put(nums[i], i);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 6, 1, 8, 9, 2, 3, 4, 5};
        if (isSameNumber(nums, 9)) {
            System.out.print("YES");
        } else {
            System.out.print("NO");
        }
    }
}

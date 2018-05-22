/**
 * Created by Ealing on 4/6/18.
 */
import java.util.*;

public class reBuildArray {
    public static int[] originalArray(int[] height) {
        int len = height.length;
        int[] res = new int[len];
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= len; i++) {
            list.add(i);
        }

        for (int i = len-1; i >= 0; i--) {
            res[i] = list.remove(i-height[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] test = {0,1,2,1,0};
        int[] res = originalArray(test);

        for (int num: res) {
            System.out.print(num);
        }
    }
}

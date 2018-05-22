import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ealing on 4/3/18.
 */
public class dpMax {
    public static int dpForMax(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 0);
        int max = 0;

        for (int i = 1; i <= n; i++) {
            int tmp = helper(i, map);
            max = Math.max(tmp, max);
        }
        return max;
    }

    private static int helper(int n, Map<Integer, Integer> map) {
        if (map.containsKey(n)) {
            return map.get(n);
        }

        int res;
        if (n%2 == 0) {
            res = helper(n/2, map)+1;
        } else {
            res = helper(n*3 +1, map)+1;
        }

        map.put(n, res);
        return res;
    }

    public static void main(String[] args) {
        System.out.print(dpForMax(3));
    }
}

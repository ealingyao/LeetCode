/**
 * Created by Ealing on 3/31/18.
 */
import java.util.*;

public class topFreqWord {
    public static String findOne(String[] strs) {
        Map<String, Integer> map = new HashMap<>();
        String res = strs[0];

        for (String s: strs) {
            if (!map.containsKey(s)) {
                map.put(s, 1);
            } else {
                map.put(s, map.get(s)+1);
                if (map.get(s) > map.get(res)) {
                    res = s;
                }
            }
        }

        return res;
    }
}

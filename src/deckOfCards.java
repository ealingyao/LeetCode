/**
 * Created by Ealing on 4/19/18.
 */
import java.util.*;

public class deckOfCards {
    //2,1,3,4,5,4,5,6,7,8  k= 5
    //1,2,3,4,5   4,5,6,7,8
    public static boolean judgeCards(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int start = Integer.MAX_VALUE;
        for (int num: nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num)+1);
            }
            start = Math.min(num, start);
        }

        while (!map.isEmpty()) {
            int fina = start+k;
            int begin = start;
            for (int end = start; end < fina; end++) {
                if (map.size() == 0 || !map.containsKey(end)) {
                    return false;
                }

                int number = map.get(end);
                if (number == 1) {
                    map.remove(end);
                } else {
                    map.put(end, number-1);
                    if (start == begin) {
                        start = end;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] test = {4,4,3,3,3,2,2,1};
        if (judgeCards(test, 3)) {
            System.out.print("true");
        } else {
            System.out.print("false");
        }
    }
}

/**
 * Created by Ealing on 4/1/18.
 */

import java.util.*;

public class canRect {
    public boolean isRect(int[][] nums) {
        int row = nums.length;
        int col = nums[0].length;
        List<Set<Integer>> sets = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            sets.add(new HashSet<>());
            int[] count = new int[col];
            for (int j = 0; j < col; j++) {
                if (nums[i][j] == 1) {
                    sets.get(i).add(j);
                    for (int k = i-1; k >= 0; k--) {
                        if (sets.get(k).contains(j)) {
                            count[k]++;
                            if (count[k] == 2) {
                                return true;
                            }
                        }
                    }
                }
            }
        }

        return false;
    }
}

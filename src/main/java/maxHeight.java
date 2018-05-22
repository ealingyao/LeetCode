/**
 * Created by Ealing on 4/9/18.
 */
import java.util.*;

public class maxHeight {
    public static int maxAlt(int[][] matrix) {
        int rtn = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dir = new int[][]{{0, 1}, {0, -1},
                {1, 0}, {1, 1}, {1, -1},
                {-1, 0}, {-1, 1}, {-1, -1}};

        int[][] res = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new int[]{i, j});
                } else {
                    res[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            for (int k = 0; k < 8; k++) {
                int dirI = cur[0]+dir[k][0];
                int dirJ = cur[1]+dir[k][1];

                if (dirI >= 0 && dirI < matrix.length && dirJ >= 0 && dirJ < matrix[0].length
                        && res[cur[0]][cur[1]]+1 < res[dirI][dirJ]) {
                    res[dirI][dirJ] = res[cur[0]][cur[1]]+1;
                    queue.add(new int[]{dirI, dirJ});
                }
            }
            rtn = Math.max(rtn, res[cur[0]][cur[1]]);
        }

        return rtn;
    }

    public static void main(String[] args) {
        int[][] test1 = new int[][]{{0,0,0,0},{1,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,0,0}};
        System.out.print(maxAlt(test1));
    }
}

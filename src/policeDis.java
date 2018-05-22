/**
 * Created by Ealing on 4/23/18.
 */

import java.util.*;

public class policeDis {
    public int[][] policeDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m][n];
        int[] dir = {1, 0, -1, 0, 1};

        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = Integer.MAX_VALUE;
                if (grid[i][j] == 1) {
                    queue.offer(new Node(i, j, 0));
                    res[i][j] = 0;
                } else if (grid[i][j] == -1) {
                    res[i][j] = -1;
                }
            }
        }

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = cur._x+dir[k];
                int ny = cur._y+dir[k+1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n
                        && grid[nx][ny] != -1 && cur._dis+1 < res[nx][ny]) {
                    res[nx][ny] = cur._dis+1;
                    queue.offer(new Node(nx, ny, cur._dis+1));
                }
            }
        }

        return res;
    }

    class Node {
        int _x;
        int _y;
        int _dis;
        Node (int x, int y, int dis) {
            _x = x;
            _y = y;
            _dis = dis;
        }
    }
}

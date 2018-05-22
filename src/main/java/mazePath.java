/**
 * Created by Ealing on 4/28/18.
 */
import java.util.*;

public class mazePath {
    private static final int[] dir = {1, 0, -1, 0, 1};
    public static List<int[]> getPath(int[][] grid, int[] start, int[] end) {
        List<List<int[]>> res = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        List<int[]> path = new ArrayList<>();

        dfs(res, path, grid, visited, start, end, 0);

        int minLen = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < res.size(); i++) {
            List<int[]> list = res.get(i);
            if (list.get(list.size() - 1)[2] < minLen) {
                index = i;
                minLen = list.get(list.size() - 1)[2];
            }
        }

        return res.get(index);
    }

    private static void dfs(List<List<int[]>> res, List<int[]> path, int[][] grid, boolean[][] visited, int[] start, int[] end, int len) {
        visited[start[0]][start[1]] = true;
        int[] node = new int[]{start[0], start[1], len};
        path.add(node);

        if (start[0] == end[0] && start[1] == end[1]) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int k = 0; k < 4; k++) {
            int nx = start[0];
            int ny = start[1];
            int curLen = -1;
            while (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] != 1) {
                nx += dir[k];
                ny += dir[k+1];
                curLen++;
            }

            nx -= dir[k];
            ny -= dir[k+1];

            if (visited[nx][ny]) {
                continue;
            }

            int[] cur = new int[]{nx, ny};
            dfs(res, path, grid, visited, cur, end, len + curLen);
            visited[nx][ny] = false;
            path.remove(path.size() - 1);

        }

    }

    public static void main(String[] args) {
        int[][] grid = {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
        List<int[]> res = getPath(grid, new int[]{0,0}, new int[]{4,4});

        int minLen = Integer.MAX_VALUE;
        int index = -1;
        for (int[] point : res) {
            System.out.print(point[0]+","+point[1]+"  ");
        }

    }
}

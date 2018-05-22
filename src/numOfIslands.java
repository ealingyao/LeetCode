/**
 * Created by Ealing on 4/7/18.
 */
import java.util.*;

public class numOfIslands {
    private static int[] dir = {1, 0, -1, 0, 1};
    public static int[] numOfIsland(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int minCount = -1;
        int maxCount = -1;
        int[] res = new int[2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    int count = dfs(grid, i, j);
                    minCount = (minCount == -1)? count: Math.min(count, minCount);
                    maxCount = (maxCount == -1)? count: Math.max(count, maxCount);
                }
            }
        }
        res[0] = minCount;
        res[1] = maxCount;

        return res;
    }

    private static int dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return 0;
        }

        grid[i][j] = '0';
        int count = 1;
        for (int k = 0; k < 4; k++) {
            count += dfs(grid, i+dir[k], j+dir[k+1]);
        }

        return count;
    }

    private int unionFind(char[][] grid) {
        UnionFind uf = new UnionFind(grid);
        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    for (int k = 0; k < 4; k++) {
                        int x = i+dir[k];
                        int y = j+dir[k+1];
                        if (x >= 0 && x < row && y >= 0 && y < col && grid[x][y] == '1') {
                            int id1 = i*col+j;
                            int id2 = x*col+y;
                            uf.union(id1, id2);
                        }
                    }
                }
            }
        }

        return uf.count;
    }

    class UnionFind {
        int[] roots;
        int m;
        int n;
        int count = 0;

        UnionFind(char[][] grid) {
            m = grid.length;
            n = grid[0].length;
            roots = new int[m*n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        int index = i*n+j;
                        roots[index] = index;
                        count++;
                    }
                }
            }
        }

        public void union(int n1, int n2) {
            int find1 = find(n1);
            int find2 = find(n2);

            if (find1 != find2) {
                roots[find1] = find2;
                count--;
            }
        }

        private int find(int id) {
            if (roots[id] == id) {
                return id;
            }
            roots[id] = find(roots[id]);

            return roots[id];
        }
    }

    public static void main(String[] args) {
        char[][] test1 = {{'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}};
        int[] res = numOfIsland(test1);
        System.out.print(res[0]+","+res[1]);

    }
}

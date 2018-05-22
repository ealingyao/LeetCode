/**
 * Created by Ealing on 4/20/18.
 */

import java.util.*;
public class MazeI {
    private static final int[] dir = {1, 0, -1, 0, 1};
    public static boolean hasPath(int[][] maze, int[] start, int[] destination) {
        Set<int[]> visited = new HashSet<>();
        return helper(maze, start, destination, visited);
    }

    private static boolean helper(int[][] maze, int[] start, int[] dest, Set<int[]> visited) {
        int m = maze.length;
        int n = maze[0].length;
        int i = start[0];
        int j = start[1];

        for (int k = 0; k < 4; k++) {
            int x = i;
            int y = j;
            while (x >= 0 && x < m && y >= 0 && y < n
                    && !visited.contains(new int[]{x,y}) && maze[x][y] != 1) {
                x += dir[k];
                y += dir[k+1];
            }
            x -= dir[k];
            y -= dir[k+1];

            if (x == dest[0] && y == dest[1]) {
                return true;
            }
            visited.add(new int[]{x, y});

            if (helper(maze, new int[]{x,y}, dest, visited)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] test = {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        if (hasPath(test, new int[]{0,4}, new int[]{4,0})) {
            System.out.print("true");
        } else {
            System.out.print("false");
        }
    }
}

/**
 * Created by Ealing on 3/31/18.
 */
import java.util.*;
public class candyCrash {
    public static int[][] buildTable(int n) {
        int[][] table = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Set<Integer> set = new HashSet<>();
                if (i > 1) {
                    set.add(table[i-2][j]);
                }

                if (j > 1) {
                    set.add(table[i][j-2]);
                }

                int num = (int)(Math.random()*3);
                while (set.contains(num)) {
                    num = (int)(Math.random()*3);
                }

                table[i][j] = num;
            }
        }

        return table;
    }

    public static void main(String[] args) {
        int[][] table = buildTable(7);
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(table[i][j]);
                if (j == 6) {
                    System.out.print("\n");
                }
            }
        }

    }
}

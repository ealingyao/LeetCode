/**
 * Created by Ealing on 3/26/18.
 */

import java.util.*;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int row1 = 0;
        int row2 = matrix.length-1;
        int col1 = 0;
        int col2 = matrix[0].length-1;

        while (row1 <= row2 && col1 <= col2) {
            for (int j = col1; j <= col2; j++) {
                res.add(matrix[row1][j]);
            }
            row1++;

            for (int i = row1; i <= row2; i++) {
                res.add(matrix[i][col2]);
            }
            col2--;

            if (row1 <= row2) {
                for (int j = col2; j >= col1; j--) {
                    res.add(matrix[row2][j]);
                }
                row2--;
            }

            if (col1 <= col2) {
                for (int i = row2; i >= row1; i--) {
                    res.add(matrix[i][col1]);
                }
                col1++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2}};
        List<Integer> ret = spiralOrder(matrix);

        for (int num: ret) {
            System.out.print(num);
        }
    }
}

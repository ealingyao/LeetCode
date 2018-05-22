/**
 * Created by Ealing on 3/27/18.
 */
import java.util.*;

public class DungeonGame {
    public static int calculateMinimumHP(int[][] nums) {
        int m = nums.length;
        int n = nums[0].length;
        int[][] dp = new int[m][n];

        dp[m-1][n-1] = (nums[m-1][n-1] <= 0)? (1-nums[m-1][n-1]):1;
        for (int i = m-2; i >= 0; i--) {
            dp[i][n-1] = (dp[i+1][n-1]-nums[i][n-1] <= 0)? 1: dp[i+1][n-1]-nums[i][n-1];
        }

        for (int j = n-2; j >= 0; j--) {
            dp[m-1][j] = (dp[m-1][j+1]-nums[m-1][j] <= 0)? 1: dp[m-1][j+1]-nums[m-1][j];
        }

        for (int i = m-3; i >= 0; i--) {
            for (int j = n-3; j >= 0; j--) {
                int tmpR = (dp[i][j+1]-nums[i][j] <= 0)? 1: dp[i][j+1]-nums[i][j];
                int tmpD = (dp[i+1][j]-nums[i][j] <= 0)? 1: dp[i+1][j]-nums[i][j];
                dp[i][j] = Math.min(tmpR, tmpD);
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] test1 = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        System.out.println(calculateMinimumHP(test1));
    }
}

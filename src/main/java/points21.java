/**
 * Created by Ealing on 4/3/18.
 */
public class points21 {
    public double calPoss(int n) {
        double[] dp = new double[30];
        for (int i = 29; i >= 0; i--) {
            if (i >= 21) {
                dp[i] = 1;
            } else if (i >= 16) {
                dp[i] = 0;
            } else {
                for (int j = i + 1; j < i + 11; j++) {
                    dp[i] += 0.1 * dp[j];
                }
            }
        }
        return dp[n-1];
    }
}

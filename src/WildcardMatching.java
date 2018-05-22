/**
 * Created by Ealing on 3/26/18.
 */
public class WildcardMatching {
    public static boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;

        for (int j = 1; j <= p.length(); j++) {
            if (p.charAt(j-1) == '*') {
                dp[0][j] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                char chs = s.charAt(i-1);
                char chp = p.charAt(j-1);

                if (chs == chp || chp == '?') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (chp == '*') {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b";

        if (isMatch(s, p)) {
            System.out.print("True");
        } else {
            System.out.print("False");
        }
    }
}

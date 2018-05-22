/**
 * Created by Ealing on 4/7/18.
 */
import java.util.*;

public class encodeString {
    public static String encode(String s) {
        int len = s.length();
        String[][] dp = new String[len][len];

        for (int l = 0; l < len; l++) {
            for (int i = 0; i < len-l; i++) {
                int j = i+l;
                String substr = s.substring(i, j+1);
                if (j-i < 4) {
                    dp[i][j] = substr;
                } else {
                    dp[i][j] = substr;
                    for (int k = i; k < j; k++) {
                        if ((dp[i][k]+dp[k+1][j]).length() < dp[i][j].length()) {
                            dp[i][j] = dp[i][k]+dp[k+1][j];
                        }
                    }

                    for (int k = 0; k < substr.length(); k++) {
                        String repeatStr = substr.substring(0, k+1);
                        if (repeatStr != null
                                && substr.length()%repeatStr.length() == 0
                                && substr.replaceAll(repeatStr, "").length() == 0) {
                            String ss = substr.length()/repeatStr.length()+"["+dp[i][i+k]+"]";

                            if (ss.length() < dp[i][j].length()) {
                                dp[i][j] = ss;
                            }
                        }
                    }
                }
            }
        }

        return dp[0][s.length()-1];
    }

    public static void main(String[] args) {
        String s = "aaaaa";
        System.out.print(encode(s));
    }
}

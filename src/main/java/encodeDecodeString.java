/**
 * Created by Ealing on 4/30/18.
 */
public class encodeDecodeString {
    public static String encode(String s) {
        int len = s.length();
        String[][] dp = new String[len][len];

        for (int l = 0; l < len; l++) {
            for (int i = 0; i < len-l; i++) {
                int j = i+l;
                String substr = s.substring(i, j+1);

                dp[i][j] = substr;
                if (j-i >= 4) {
                    for (int k = i; k < j; k++) {
                        if ((dp[i][k]+dp[k+1][j]).length() < dp[i][j].length()) {
                            dp[i][j] = dp[i][k]+dp[k+1][j];
                        }
                    }

                    for (int k = 0; k < substr.length(); k++) {
                        String repeatStr = substr.substring(0,k+1);
                        if (substr.length()%repeatStr.length() == 0
                                && substr.replaceAll(repeatStr, "").length() == 0) {
                            String ss = (substr.length()/repeatStr.length()) + "x" + repeatStr;
                            if (ss.length() < dp[i][j].length()) {
                                dp[i][j] = ss;
                            }
                        }
                    }
                }
            }
        }

        return dp[0][len-1];
    }

//    public String decodeString(String s) {
//        int len = s.length();
//
//    }

    public static void main(String[] args) {
        String test1 = "abbbabbbcabbbabbbc";
        System.out.print(encode(test1));
    }
}

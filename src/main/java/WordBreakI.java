/**
 * Created by Ealing on 3/26/18.
 */
import java.util.*;

public class WordBreakI {
    public static boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len+1];

        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            if (!dp[i-1]) {
                continue;
            }

            for (String str: wordDict) {
                int n = str.length();
                if (i+n <= s.length()+1 && s.substring(i-1, i+n-1).equals(str)) {
                    dp[i+n-1] = true;
                }
            }
        }

        return dp[len];
    }

    public static void main(String[] args) {
        String s = "aaaaaaa";
        List<String> list = new ArrayList<>();
        list.add("aaaa");
        list.add("aa");

        System.out.println(wordBreak(s, list));
    }
}

/**
 * 给一个string s, 找出所有包含超过连续n个元音字母（a, e, i, o, u）的substring的个数，
 * 比如(“asaab” n = 2) ->"aa", "saa", "asaa", "aab", "saab, "asaab" -> output = 6
 */
import java.util.*;

public class findRepeat {
    public static int find(String s, int n) {
        final int len = s.length();
        int res = 0;
        Set<String> set = new HashSet<>();
        Set<Character> vowel = new HashSet<>();
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');

        for (int i = 0; i < len; i++) {
            int count = 0;
            boolean valid = false;
            for (int j = i; j < len; j++) {
                if (vowel.contains(s.charAt(j))) {
                    count++;
                } else {
                    count = 0;
                }

                if (count == n) {
                    valid = true;
                }

                String str = s.substring(i, j + 1);
                if (valid && !set.contains(str)) {
                    set.add(str);
                    res++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "aasaab";
        System.out.print(find(s, 2));
    }
}

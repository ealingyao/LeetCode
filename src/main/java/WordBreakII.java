/**
 * Created by Ealing on 3/27/18.
 */
import java.util.*;

public class WordBreakII {
    public static List<String> wordBreak(String s, List<String> wordDict) {
//        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>(wordDict);
//        helper(res, set, s, "");
//
//        return res;
        return dfs(s, set, new HashMap<>());
    }

    private static void helper(List<String> res, Set<String> set, String s, String path) {
        if (s.equals("")) {
            res.add(path);
            return;
        }

        for (int i = 1; i <= s.length(); i++) {
            String tmp = s.substring(0, i);
            if (set.contains(tmp)) {
                helper(res, set, s.substring(i), path+" "+tmp);
            }
        }
    }

    private static List<String> dfs(String s, Set<String> set, Map<String, LinkedList<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }

        LinkedList<String> res = new LinkedList<>();
        if (s.equals("")) {
            res.add("");
            return res;
        }

        for (int i = 1; i <= s.length(); i++) {
            if (set.contains(s.substring(0,i))) {
                List<String> sub = dfs(s.substring(i), set, map);
                for (String str: sub) {
                    res.add(s.substring(0,i) + (str.equals("")? "" : " ") + str);
                }
            }
        }
        map.put(s, res);

        return res;
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> list = new ArrayList<>();
        list.add("cat");
        list.add("cats");
        list.add("and");
        list.add("sand");
        list.add("dog");

        List<String> res = wordBreak(s, list);
        for (String ss: res) {
            System.out.println(ss);
        }
    }
}

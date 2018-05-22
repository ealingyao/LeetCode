/**
 * Created by Ealing on 4/21/18.
 */

import java.util.*;

public class wordsAbb {
    public static List<String> wordsAbbreviation(List<String> dict) {
        List<String> res = new ArrayList<>();
        Map<String, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < dict.size(); i++) {
            if (dict.get(i).length() <= 3) {
                res.add(dict.get(i));
                continue;
            }

            String str = getAbb(dict.get(i), 0);
            res.add(str);
            if (!map.containsKey(str)) {
                map.put(str, new ArrayList<>());
                map.get(str).add(i);
            } else {
                List<Integer> same = map.get(str);
                List<String> samPre = new ArrayList<>();

                same.add(i);
                for (int n: same) {
                    samPre.add(dict.get(n));
                }

                int commonIndex = getCommon(samPre);
                for (int j = 0; j < samPre.size(); j++) {
                    if (samPre.get(j).length()-commonIndex <= 4) {
                        res.set(same.get(j), samPre.get(j));
                    } else {
                        String nStr = getAbb(samPre.get(j), commonIndex+1);
                        res.set(same.get(j), nStr);
                    }
                }
            }
        }

        return res;
    }

    private static String getAbb(String s, int index) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(0, index+1));
        sb.append(s.length()-index-2);
        sb.append(s.charAt(s.length()-1));

        return sb.toString();
    }

    private static int getCommon(List<String> list) {
        String pre = list.get(0);
        int length = pre.length();
        for (String cur: list) {
            int index = 0;
            while (index < pre.length() && index < cur.length()) {
                if (pre.charAt(index) != cur.charAt(index)) {
                    break;
                }
                index++;
            }
            pre = cur;
            length = Math.min(length, index-1);
        }

        return length;
    }

    public static void main(String[] args) {
        List<String> test = new ArrayList<>(Arrays.asList("abcdefg","abccefg","abcckkg"));
        List<String> res = wordsAbbreviation(test);
    }
}

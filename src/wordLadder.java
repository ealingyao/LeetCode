/**
 * Created by Ealing on 4/1/18.
 */
import java.util.*;

public class wordLadder {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        if (!set.contains(endWord)) {
            return 0;
        }

        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();
        int len = 1;

        begin.add(beginWord);
        end.add(endWord);

        while (!begin.isEmpty() && !end.isEmpty()) {
            for (String word: begin) {
                char[] ch = word.toCharArray();
                for (int i = 0; i < ch.length; i++) {
                    for (char j = 'a'; j <= 'z'; j++) {
                        ch[i] = j;
                        String tmp = String.valueOf(ch);

                        if (end.contains(tmp)) {
                            return len+1;
                        }

                        if (!visited.contains(tmp) && set.contains(tmp)) {
                            begin.add(tmp);
                            visited.add(tmp);
                        }
                    }
                }
            }
            len++;

            if (end.size() < begin.size()) {
                Set<String> change = begin;
                begin = end;
                end = change;
            }

        }

        return 0;
    }

    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        System.out.println(ladderLength("hit", "cog", wordList));
    }
}

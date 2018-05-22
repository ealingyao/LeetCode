/**
 * Created by Ealing on 3/28/18.
 */

import java.util.*;
public class wordSearchII {
    private static Trie root = new Trie();
    private static int[] dir = {1, 0, -1, 0, 1};

    public static List<String> findWords(char[][] board, String[] words) {
        Set<String> res = new HashSet<>();

        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];

        build(words);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dfs(res, board, i, j, visited, "");
            }
        }

        return new ArrayList<>(res);
    }

    public static void dfs(Set<String> res, char[][] board, int i, int j, boolean[][] visited, String s) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return;
        }

        if (!startWith(s)) {
            return;
        }

        if (search(s)) {
            res.add(s);
            return;
        }

        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            dfs(res, board, i+dir[k], j+dir[k+1], visited, s+board[i][j]);
        }
        visited[i][j] = false;
    }

    public static void build(String[] words) {
        for (String word: words) {
            Trie node = root;
            for (char c: word.toCharArray()) {
                if (node.children[c-'a'] == null) {
                    node.children[c-'a'] = new Trie();
                }
                node = node.children[c-'a'];
            }
            node.item = word;
        }
    }

    public static boolean search(String word) {
        Trie node = root;
        for (char c: word.toCharArray()) {
            if (node.children[c-'a'] == null) {
                return false;
            } else {
                node = node.children[c-'a'];
            }
        }

        return node.item.equals(word);
    }

    public static boolean startWith(String word) {
        Trie node = root;
        for (char c: word.toCharArray()) {
            if (node.children[c-'a'] == null) {
                return false;
            } else {
                node = node.children[c-'a'];
            }
        }

        return true;
    }



    static class Trie {
        Trie[] children = new Trie[26];
        String item = "";
        public Trie () {

        }
    }

    public static void main(String[] args) {
        char[][] ch = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] str = {"oath","pea","eat","rain"};

        List<String> res = findWords(ch, str);
        for (String s: res) {
            System.out.println(s);
        }
    }
}

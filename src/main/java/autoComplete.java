import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ealing on 4/9/18.
 */
public class autoComplete {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = "";
        public TrieNode (){}
    }

    class Trie {
        TrieNode root;
        public Trie() {
            root = new TrieNode();
        }

        public void insert(String s) {
            TrieNode node = root;
            for (char ch: s.toCharArray()) {
                if (node.children[ch-'a'] == null) {
                    node.children[ch-'a'] = new TrieNode();
                }
                node = node.children[ch-'a'];
            }
            node.word = s;
        }

        public boolean startWith(String s) {
            TrieNode node = root;
            for (char ch: s.toCharArray()) {
                if (node.children[ch-'a'] == null) {
                    return false;
                } else {
                    node = node.children[ch-'a'];
                }
            }

            return true;
        }

        public List<String> find(String s) {
            TrieNode node = root;
            List<String> res = new ArrayList<>();
            for (char ch: s.toCharArray()) {
                if (node.children[ch-'a'] == null) {
                    return new ArrayList<>();
                } else {
                    node = node.children[ch-'a'];
                }
            }
            dfs(res, node, s);

            return res;
        }

        private void dfs(List<String> res, TrieNode node, String s) {
            TrieNode cur = node;
            if (cur.word != null) {
                res.add(s+cur.word);
                return;
            }

            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (cur.children[ch-'a'] != null) {
                    dfs(res, cur.children[ch-'a'], s+ch);
                }
            }
        }
    }
}

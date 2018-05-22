/**
 * Created by Ealing on 4/21/18.
 */
import java.util.*;
public class wordSquare {
    public List<List<String>> wrdSquare(String[] words) {
        List<List<String>> res = new ArrayList<>();
        Trie trie = new Trie();
        int len = words[0].length();

        for (String word: words) {
            trie.insert(word);
        }
        dfs(res, trie, len, new ArrayList<>());

        return res;
    }

    private void dfs(List<List<String>> res, Trie trie, int len, List<String> list) {
        if (list.size() == len) {
            res.add(new ArrayList<>(list));
            return;
        }

        int index = list.size();
        StringBuilder preBuilder = new StringBuilder();
        for (String s: list) {
            preBuilder.append(s.charAt(index));
        }

        List<String> startList = trie.findStart(preBuilder.toString());
        for (String start: startList) {
            list.add(start);
            dfs(res, trie, len, list);
            list.remove(list.size()-1);
        }
    }

    class Trie {
        TrieNode root;
        Trie() {
            root = new TrieNode();
        }

        public void insert(String s) {
            root._startWith.add(s);
            TrieNode node = root;
            for (char c: s.toCharArray()) {
                if (node._children[c-'a'] == null) {
                    node._children[c-'a'] = new TrieNode();
                }
                node = node._children[c-'a'];
                node._startWith.add(s);
            }
        }

        public List<String> findStart(String prefix) {
            TrieNode node = root;
            List<String> res = new ArrayList<>();
            for (char c: prefix.toCharArray()) {
                if (node._children[c-'a'] == null) {
                    return res;
                }
                node = node._children[c-'a'];
            }
            res.addAll(node._startWith);

            return res;
        }
    }

    class TrieNode {
        List<String> _startWith;
        TrieNode[] _children;
        TrieNode() {
            _startWith = new ArrayList<>();
            _children = new TrieNode[26];
        }
    }
}

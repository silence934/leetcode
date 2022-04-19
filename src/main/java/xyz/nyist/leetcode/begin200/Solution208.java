package xyz.nyist.leetcode.begin200;

/**
 * @author: fucong
 * @Date: 2022/4/18 17:31
 * @Description:
 */
public class Solution208 {

    private Solution208[] children;

    private boolean isEnd;

    public Solution208() {
        children = new Solution208[26];
        isEnd = false;
    }

    public void insert(String word) {
        insert(word, 0);
    }

    private void insert(String word, int start) {
        if (word.length() == start) {
            isEnd = true;
            return;
        }
        char c = word.charAt(start);
        Solution208 node;
        if ((node = children[c - 'a']) == null) {
            node = new Solution208();
            children[c - 'a'] = node;
        }
        node.insert(word, start + 1);
    }

    public boolean search(String word) {
        return search(word, 0);
    }

    private boolean search(String prefix, int index) {
        if (prefix.length() == index) {
            return isEnd;
        }
        Solution208 node = children[prefix.charAt(index) - 'a'];
        return node != null && node.search(prefix, index + 1);
    }

    public boolean startsWith(String prefix) {
        return startsWith(prefix, 0);
    }

    private boolean startsWith(String prefix, int index) {
        if (prefix.length() == index) {
            return true;
        }
        Solution208 node = children[prefix.charAt(index) - 'a'];
        return node != null && node.startsWith(prefix, index + 1);
    }

}

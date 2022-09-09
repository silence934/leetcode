package xyz.nyist.leetcode.begin200;

/**
 * @author: silence
 * @Date: 2022/4/18 17:53
 * @Description:
 */
public class Solution211 {

    private Solution211[] children;

    private boolean isEnd;

    public Solution211() {
        isEnd = false;
        children = new Solution211[26];
    }

    public void addWord(String word) {
        addWord(word, 0);
    }

    private void addWord(String word, int index) {
        if (index == word.length()) {
            isEnd = true;
            return;
        }
        char c = word.charAt(index);
        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                Solution211 node;
                if ((node = children[i]) == null) {
                    node = new Solution211();
                    children[i] = node;
                }
                node.addWord(word, index + 1);
            }

        } else {
            Solution211 node;
            if ((node = children[c - 'a']) == null) {
                node = new Solution211();
                children[c - 'a'] = node;
            }
            node.addWord(word, index + 1);
        }
    }


    public boolean search(String word) {
        return search(word, 0);
    }

    private boolean search(String prefix, int index) {
        if (prefix.length() == index) {
            return isEnd;
        }
        char c = prefix.charAt(index);
        if (c == '.') {
            for (Solution211 child : children) {
                if (child != null && child.search(prefix, index + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            Solution211 node = children[c - 'a'];
            return node != null && node.search(prefix, index + 1);
        }
    }

}

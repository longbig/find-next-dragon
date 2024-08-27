package leetcode2021.medium;

/**
 * @author yuyunlong
 * @date 2021/1/30 3:45 下午
 * @description 前缀数进阶版
 */
public class LeetCode211 {


}

class WordDictionary {

    boolean isEnd;
    WordDictionary[] next = new WordDictionary[26];


    /** Initialize your data structure here. */
    public WordDictionary() {

    }

    public void addWord(String word) {
        char[] chars = word.toCharArray();
        WordDictionary node = this;
        for (char aword : chars) {
            if (node.next[aword - 'a'] == null) {
                node.next[aword - 'a'] = new WordDictionary();
            }
            node = node.next[aword - 'a'];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        WordDictionary node = this;
        return dfs(word, node);
    }

    public boolean dfs(String word, WordDictionary node) {
        char[] chars = word.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            //新增逻辑，深度遍历
            if (chars[i] == '.') {
                for (int j = 0; j < 26; j++) {
                    if (node.next[j] != null && dfs(word.substring(i + 1), node.next[j])) {
                        return true;
                    }
                }
                return false;
            }

            if (node.next[chars[i] - 'a'] == null) {
                return false;
            }

            node = node.next[chars[i] - 'a'];
        }

        return node.isEnd;
    }
}

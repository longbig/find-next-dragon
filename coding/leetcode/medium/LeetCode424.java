package leetcode.medium;

/**
 * @author yuyunlong
 * @date 2021/2/5 11:00 下午
 * @description
 */
public class LeetCode424 {

    public int characterReplacement(String s, int k) {
        int[] charCount = new int[26];
        int left = 0, right = 0, maxCount = 0;
        int len = s.length();

        while (right < len) {
            charCount[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, charCount[s.charAt(right) - 'A']);
            if (right - left + 1 - maxCount > k) {
                charCount[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }
        return right - left;
    }

    public static void main(String[] args) {
        LeetCode424 test = new LeetCode424();
        String s = "AABABBA";
        int k = 1;
        System.out.println(test.characterReplacement(s, k));
    }
}

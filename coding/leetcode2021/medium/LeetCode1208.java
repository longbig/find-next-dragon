package leetcode2021.medium;

/**
 * @author yuyunlong
 * @date 2021/2/5 10:24 下午
 * @description
 */
public class LeetCode1208 {

    public int equalSubstring(String s, String t, int maxCost) {
        int len = s.length();
        int[] subValues = new int[len];
        for (int i = 0; i < len; i++) {
            subValues[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }

        int left = 0, right = 0, sum = 0, maxLen = 0;
        while (right < len) {
            sum += subValues[right];
            if (sum > maxCost) {
                sum -= subValues[left];
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;

        }
        return maxLen;
    }

    public static void main(String[] args) {

        LeetCode1208 test = new LeetCode1208();
        String s = "abcd";
        String t = "bcdf";
        int maxCost = 3;
        System.out.println(test.equalSubstring(s, t, maxCost));
    }

}

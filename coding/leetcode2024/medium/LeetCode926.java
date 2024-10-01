package leetcode2024.medium;

/**
 * @author yuyunlong
 * @date 2024/9/23 22:22
 * @description 926. 将字符串翻转到单调递增
 *
 * 如果一个二进制字符串，是以一些 0（可能没有 0）后面跟着一些 1（也可能没有 1）的形式组成的，那么该字符串是 单调递增 的。
 *
 * 给你一个二进制字符串 s，你可以将任何 0 翻转为 1 或者将 1 翻转为 0 。
 *
 * 返回使 s 单调递增的最小翻转次数。
 */
public class LeetCode926 {

    public int minFlipsMonoIncr(String s) {
        if (s == null) {
            return 0;
        }
        //全1
        int count1 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                count1++;
            }
        }
        int countLeft = 0, countRight = count1;
        int min = countRight;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                countRight--;
            } else {
                countLeft++;
            }
            min = Math.min(min, countLeft + countRight);
        }
        return min;
    }
}

package leetcode.medium;

import java.util.Arrays;

/**
 * @author yuyunlong
 * @date 2021/3/20 6:56 下午
 * @description https://leetcode-cn.com/leetbook/read/high-frequency-algorithm-exercise/5ux4ys/
 */
public class LeetCode455 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int indexG = 0, indexS = 0, count = 0;
        while (indexG < g.length && indexS < s.length) {
            if (s[indexS] >= g[indexG]) {
                indexS++;
                indexG++;
                count++;
            } else {
                indexS++;
            }
        }
        return count;
    }
}

package leetcode2021.easy;

/**
 * @author yuyunlong
 * @date 2021/3/22 11:46 下午
 * @description
 */
public class LeetCode191 {

    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                res++;
            }
        }
        return res;
    }
}

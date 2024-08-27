package leetcode2021.easy;

/**
 * @author yuyunlong
 * @date 2021/7/6 2:39 下午
 * @description
 */
public class LeetCode070 {

    //滚动数组的方法
    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}

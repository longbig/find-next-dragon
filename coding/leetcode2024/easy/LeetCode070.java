package leetcode2024.easy;

/**
 * @author Administrator
 * @date 2024/8/14 8:57
 * @description 爬楼梯
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class LeetCode070 {

    /**
     * 递归会超时，重复计算太多
     * 用滚动数组的方式
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        int pre = 1, curr = 2, r = 0;
        for (int i = 2; i < n; i++) {
            r = pre + curr;
            pre = curr;
            curr = r;
        }
        return r;
    }



    public int climbStairsForDigui(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        return climbStairsForDigui(n - 1) +  climbStairsForDigui(n - 2);
    }

    public static void main(String[] args) {
        LeetCode070 leetCode070 = new LeetCode070();
        int result = leetCode070.climbStairs(6);
        System.out.println(result);
    }
}

package leetcode2024.medium;

import java.util.Arrays;

/**
 * @author yuyunlong
 * @date 2024/10/6 11:52
 * @description 322. 零钱兑换
 *
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 */
public class LeetCode322 {

    //动态规划，f(i) = 1 + min(f(i - coins[j]))
    //注意初始化时，填充一个较大的数
    public int coinChange(int[] coins, int amount) {
        int[] f = new int[amount + 1];
        Arrays.fill(f, amount + 1);
        f[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    f[i] = Math.min(f[i], f[i - coins[j]] + 1);
                }
            }
        }

        if (f[amount] > amount) {
            return -1;
        }
        return f[amount];
    }
}

package leetcode2024.compitetion.week411;

/**
 * @author yuyunlong
 * @date 2024/8/18 10:53
 * @description Q2. 超级饮料的最大强化能量
 *
 * 来自未来的体育科学家给你两个整数数组 energyDrinkA 和 energyDrinkB，数组长度都等于 n。这两个数组分别代表 A、B 两种不同能量饮料每小时所能提供的强化能量。
 *
 * 你需要每小时饮用一种能量饮料来 最大化 你的总强化能量。然而，如果从一种能量饮料切换到另一种，你需要等待一小时来梳理身体的能量体系（在那个小时里你将不会获得任何强化能量）。
 *
 * 返回在接下来的 n 小时内你能获得的 最大 总强化能量。
 *
 * 注意 你可以选择从饮用任意一种能量饮料开始。
 * fA(i) = Math.max(fA(i - 1), fB(i - 2)) + arrayA[i]
 */
public class Competition411Q2 {

    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        int n = energyDrinkA.length;
        long[] fA = new long[n];
        long[] fB = new long[n];
        fA[0] = energyDrinkA[0];
        fB[0] = energyDrinkB[0];
        fA[1] = Math.max(fA[0] + energyDrinkA[1], fB[0]);
        fB[1] = Math.max(fB[0] + energyDrinkB[1], fA[0]);
        for (int i = 2; i < n; i++) {
            fA[i] = Math.max(fA[i - 1], fB[i - 2]) + energyDrinkA[i];
            fB[i] = Math.max(fB[i - 1], fA[i - 2]) + energyDrinkB[i];
        }
        return Math.max(fA[n - 1], fB[n - 1]);
    }
}

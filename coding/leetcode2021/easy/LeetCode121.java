package leetcode2021.easy;

/**
 * @author yuyunlong
 * @date 2021/3/14 11:58 下午
 * @description
 */
public class LeetCode121 {

    //双指针法
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            //某一日期前的最低价格
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                profit = Math.max(prices[i] - minPrice, profit);
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        LeetCode121 test = new LeetCode121();
        int[] array = new int[]{7,1,5,3,6,4};
        System.out.println(test.maxProfit(array));
    }
}

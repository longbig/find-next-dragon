package leetcode2021.medium;

/**
 * @author yuyunlong
 * @date 2021/2/6 9:14 下午
 * @description
 */
public class LeetCode1423 {

    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        int maxSum = 0;

        for (int i = 0; i < k; i++) {
            maxSum += cardPoints[i];
        }
        //其他
        int left = len - 1, right = k - 1, sum = maxSum;
        while (right >= 0) {
            sum += (cardPoints[left] - cardPoints[right]);
            left--;
            right--;
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}

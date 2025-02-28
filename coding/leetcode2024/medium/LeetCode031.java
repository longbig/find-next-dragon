package leetcode2024.medium;

public class LeetCode031 {

    /**
     * 根据题目意思想出奇妙的解法：
     * https://leetcode.cn/problems/next-permutation/?envType=study-plan-v2&envId=top-100-liked
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        //从后往前，找第一个升序的相邻两个数
        int len = nums.length;
        int i = len - 2, j = len - 1, k = len - 1;
        while (i >= 0 && nums[i] >= nums[j]) {
            i--;
            j--;
        }
        //需要判断
        if (i >= 0) {
            //找j 到 end 间第一个比i大的元素
            while (nums[k] <= nums[i]) {
                k--;
            }
            //交换i，k
            int temp = nums[k];
            nums[k] = nums[i];
            nums[i] = temp;
        }
        //此时注意交换完后，j到end仍然是降序的，改为升序的
        for (int left = j, right = len - 1; left < right; left++, right--) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
    }
}

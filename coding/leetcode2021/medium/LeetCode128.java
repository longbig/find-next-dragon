package leetcode2021.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yuyunlong
 * @date 2021/5/27 9:23 上午
 * @description 最长连续序列
 */
public class LeetCode128 {

    //思路：从x开始,x+1, x+2, ,,, x+y 依次判定是否存在，存在则是连续序列，记录最长值
    //优化，因为已经知道一个连续序列，如果是从连续序列中的一个中间位置开始， x前面会存在x-1的，因此只需要对于存在x-1的情况，跳过即可
    public int longestConsecutive(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        int ans = 0;
        for (int num : nums) {
            numsSet.add(num);
        }

        for (int n : numsSet) {
            if (!numsSet.contains(n - 1)) {
                int temp = n, curr = 1;
                while (numsSet.contains(temp + 1)) {
                    curr += 1;
                    temp += 1;
                }
                ans = Math.max(ans, curr);
            }
        }
        return ans;
    }
}

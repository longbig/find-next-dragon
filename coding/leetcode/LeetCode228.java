package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuyunlong
 * @date 2021/1/10 12:49 下午
 * @description
 */
public class LeetCode228 {

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int low = 0, i = 0, len = nums.length;
        while (i < len) {
            low = i;
            i++;
            while(i < len && (nums[i] == nums[i - 1] + 1)) {
                i++;
            }
            int high = i - 1;
            String startStr = String.valueOf(nums[low]);
            if (low < high) {
                startStr = startStr + "->" + nums[high];
            }
            result.add(startStr);
        }
        return result;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{0,2,3,4,6,8,9};
        LeetCode228 test = new LeetCode228();
        System.out.println(test.summaryRanges(nums));
    }
}

package leetcode2021;

/**
 * @author yuyunlong
 * @date 2020/8/16 3:56 下午
 * @description
 */
public class LeetCode35 {

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 2;
        LeetCode35 test = new LeetCode35();
        System.out.println(test.searchInsert(nums, target));
    }

    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        //特殊
        if (nums[len - 1] < target) {
            return len;
        }
        //二分
        int left = 0, right = len - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}

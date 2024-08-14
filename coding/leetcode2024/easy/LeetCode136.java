package leetcode2024.easy;

/**
 * @author yuyunlong
 * @date 2024/8/15 00:38
 * @description
 */
public class LeetCode136 {

    public int singleNumber(int[] nums) {
        //异或操作解决
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int a = 2, b = 2, c = 1;
        System.out.println(a ^ c ^ b);
    }
}

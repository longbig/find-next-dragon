package leetcode.easy;

import leetcode.medium.LeetCode073;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author yuyunlong
 * @date 2021/3/21 4:21 下午
 * @description
 */
public class LeetCode136 {

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] test = {4, 1, 2, 1, 2};
        LeetCode136 tt = new LeetCode136();
        System.out.println(tt.singleNumber(test));

    }
}

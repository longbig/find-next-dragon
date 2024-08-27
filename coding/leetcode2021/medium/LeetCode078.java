package leetcode2021.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuyunlong
 * @date 2021/5/21 7:13 下午
 * @description 子集
 */
public class LeetCode078 {

    //方法一，迭代法，二进制的1正好表示取的数
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int n = nums.length;
        //总共2^n种可能
        for (int i = 0; i < (1 << n); i++) {
            temp.clear();
            //内部取i的二进制表示，1的位置取数
            for (int j = 0; j < n; j++) {
                if (((1 << j) & i) != 0) {
                    temp.add(nums[j]);
                }
            }
            result.add(new ArrayList<>(temp));
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(2 & 4);
    }
}

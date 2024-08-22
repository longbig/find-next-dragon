package leetcode2024.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @date 2024/8/22 9:08
 * @description 118. 杨辉三角
 *
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 */
public class LeetCode118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows <= 0) {
            return result;
        }
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    Integer num = result.get(i - 1).get(j - 1) + result.get(i - 1).get(j);
                    row.add(num);
                }
            }
            result.add(row);
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode118 leetCode118 = new LeetCode118();
        List<List<Integer>> result = leetCode118.generate(5);
        for (List<Integer> integers : result) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}

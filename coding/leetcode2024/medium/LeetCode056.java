package leetcode2024.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author yuyunlong
 * @date 2024/8/7 23:51
 * @description 合并区间
 *
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 */
public class LeetCode056 {

    public int[][] merge(int[][] intervals) {
        //先排序，然后搞个新的数组List，存合并后的区间，先存入第一个，然后遍历区间集合，判断是合并，还是加入到List里
        if (intervals == null || intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> newMergeList = new ArrayList<>();
        newMergeList.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int left = intervals[i][0];

            if (left > newMergeList.get(newMergeList.size() - 1)[1]) {
                //不相交
                newMergeList.add(intervals[i]);
            } else {
                //合并
                newMergeList.get(newMergeList.size() - 1)[1] = Math.max(newMergeList.get(newMergeList.size() - 1)[1], intervals[i][1]);
            }
        }
        int[][] result = newMergeList.toArray(new int[newMergeList.size()][]);
        return result;
    }

    public static void main(String[] args) {
        LeetCode056 leetCode056 = new LeetCode056();
        int[][] intervals = new int[][]{
                {1,3},{2,6},{8,10},{15,18}
        };
        int[][] result = leetCode056.merge(intervals);
    }
}

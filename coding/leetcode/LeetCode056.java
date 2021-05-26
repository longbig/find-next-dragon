package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author yuyunlong
 * @date 2021/5/20 1:10 下午
 * @description 合并区间
 */
public class LeetCode056 {

    /**
     * 思路：先按左端节点排序，排序之后，顺序合并即可
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int L = intervals[i][0], R = intervals[i][1];
            if (result.size() == 0 || result.get(result.size() - 1)[1] < L) {
                result.add(new int[]{L, R});
            } else {
                //合并
                result.get(result.size() - 1)[1] = Math.max(intervals[i][1], result.get(result.size() - 1)[1]);
            }
        }
        int[][] output = result.toArray(new int[result.size()][]);
        return output;
    }
}

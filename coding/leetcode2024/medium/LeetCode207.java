package leetcode2024.medium;

import java.util.*;

/**
 * @author yuyunlong
 * @date 2025/3/15 10:09
 * @description 课程表
 *
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 *
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 *
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 */
public class LeetCode207 {

    /**
     * 图论，用拓扑排序的思路 + BFS遍历解决
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //入度数组，如果为0，则对应下标的数字是图的入点
        int[] inDegrees = new int[numCourses];
        //定义每个节点依赖的，入度数组，比如0, 下游是1，2
        //初始化
        Map<Integer, List<Integer>> numDepencys = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            inDegrees[prerequisites[i][0]]++;
            numDepencys.putIfAbsent(prerequisites[i][1], new ArrayList<>());
            //再插入数据
            numDepencys.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        //BFS
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer currentNode = queue.poll();
            numCourses--;
            List<Integer> downs = numDepencys.getOrDefault(currentNode, new ArrayList<>());
            //下游节点入度都减1
            for (Integer down : downs) {
                inDegrees[down]--;
                if (inDegrees[down] == 0) {
                    queue.offer(down);
                }
            }
        }
        return numCourses == 0;
    }
}

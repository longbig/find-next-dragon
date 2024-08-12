package leetcode2024.compitetion.week410;

import java.util.List;

/**
 * @author yuyunlong
 * @date 2024/8/11 11:02
 * @description
 * 大小为 n x n 的矩阵 grid 中有一条蛇。蛇可以朝 四个可能的方向 移动。矩阵中的每个单元格都使用位置进行标识： grid[i][j] = (i * n) + j。
 *
 * 蛇从单元格 0 开始，并遵循一系列命令移动。
 *
 * 给你一个整数 n 表示 grid 的大小，另给你一个字符串数组 commands，其中包括
 * "UP"、"RIGHT"、"DOWN" 和 "LEFT"。题目测评数据保证蛇在整个移动过程中将始终位于 grid 边界内。
 *
 * 返回执行 commands 后蛇所停留的最终单元格的位置。
 */
public class CompitetionQ1 {

    public int finalPositionOfSnake(int n, List<String> commands) {
        int i = 0, j = 0;
        for (String command : commands) {
            if (command.equals("UP")) i--;
            if (command.equals("DOWN")) i++;
            if (command.equals("LEFT")) j--;
            if (command.equals("RIGHT")) j++;
        }
        return (i * n) + j;

    }
}

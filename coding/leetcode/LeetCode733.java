package leetcode;

/**
 * @author yuyunlong
 * @date 2020/8/16 1:16 下午
 * @description
 */
public class LeetCode733 {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int initColor = image[sr][sc];
        //只有颜色不同时才操作
        if (initColor != newColor) {
            dfs(image, sr, sc, initColor, newColor);
        }
        return image;
    }

    private void dfs(int[][] image, int x, int y, int initColor, int newColor) {
        //边界值处理
        if (x < 0 || x >= image.length || y < 0 || y >= image[0].length) {
            return;
        }
        if (image[x][y] == initColor) {
            image[x][y] = newColor;
            //深度优先遍历
            dfs(image, x - 1, y, initColor, newColor);
            dfs(image, x + 1, y, initColor, newColor);
            dfs(image, x, y - 1, initColor, newColor);
            dfs(image, x, y + 1, initColor, newColor);
        }
        return;
    }
}

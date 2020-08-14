package leetCode.ClassicalThinking.BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author:choumei
 * @date:2020/4/15 23:21
 * @Description: 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 *
 * 两个相邻元素间的距离为 1 。
 *
 * 示例 1:
 * 输入:
 *
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 输出:
 *
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 示例 2:
 * 输入:
 *
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * 输出:
 *
 * 0 0 0
 * 0 1 0
 * 1 2 1
 * 注意:
 *
 * 给定矩阵的元素个数不超过 10000。
 * 给定矩阵中至少有一个元素是 0。
 * 矩阵中的元素只在四个方向上相邻: 上、下、左、右。
 *
 */
public class Matrix01_542 {
    public int[][] updateMatrix(int[][] matrix) {
        // 首先将 0 边上的 1 入队
        int[] dx = new int[] {-1, 1, 0, 0};
        int[] dy = new int[] {0, 0, -1, 1};
        Queue<int[]> queue = new LinkedList<>();
        int m = matrix.length, n = matrix[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if (x >= 0 && x < m && y >= 0 && y < n
                                && matrix[x][y] == 1 && res[x][y] == 0) {
                            // 这是在 0 边上的1。需要加上 res[x][y] == 0 的判断防止重复入队
                            res[x][y] = 1;
                            queue.offer(new int[] {x, y});
                        }
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0], y = point[1];
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n
                        && matrix[newX][newY] == 1 && res[newX][newY] == 0) {
                    res[newX][newY] = res[x][y] + 1;
                    queue.offer(new int[] {newX, newY});
                }
            }
        }

        return res;
    }
}

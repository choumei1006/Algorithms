package leetCode.ClassicalThinking.Dp;

import org.junit.Test;

/**
 * @author:choumei
 * @date:2020/5/8 16:14
 * @Description: 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 *
 */
public class MaximalSquare_221 {
    @Test
    public void test(){
        System.out.println( maximalSquare1(new char[][]{{'1','0','1','0','0'},
                                                        {'1','0','1','1','1'},
                                                        {'1','1','1','1','1'},
                                                        {'1','0','0','1','0'}}));
    }

    /**
     * 方法一：暴力法
     * @param matrix
     * @return
     */
    public int maximalSquare1(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        int rows = matrix.length, columns = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    // 遇到一个 1 作为正方形的左上角
                    maxSide = Math.max(maxSide, 1);
                    // 计算可能的最大正方形边长
                    int currentMaxSide = Math.min(rows - i, columns - j);
                    for (int k = 1; k < currentMaxSide; k++) {
                        // 判断新增的一行一列是否均为 1
                        boolean flag = true;
                        if (matrix[i + k][j + k] == '0') {
                            break;
                        }
                        for (int m = 0; m < k; m++) {
                            if (matrix[i + k][j + m] == '0' || matrix[i + m][j + k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            maxSide = Math.max(maxSide, k + 1);
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        int maxSquare = maxSide * maxSide;
        return maxSquare;
    }

    public int maximalSquare2(char[][] matrix){
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int[][] dp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        int maxSquare = maxSide * maxSide;
        return maxSquare;
    }

    /**
     * 方法一_自解
     * @param matrix
     * @return
     */
    public int maximalSquare1_self(char[][] matrix){
        if(null == matrix || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int maxSide = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //遇到值为1的元素，将其作为代求正方形的左上角，计算以该元素为左上角的正方形的最大边长
                if(matrix[i][j] == '1'){
                    maxSide = Math.max(maxSide, 1);
                    int currMaxSide = Math.min(row - i, col - j);
                    for (int k = 1; k < currMaxSide; k++) {
                        boolean isAllOne = true;
                        if(matrix[i + k][j + k] == '1'){
                            break;
                        }
                        for (int l = 0; l < k; l++) {
                            if(matrix[i + k][j + l] == '0' || matrix[i + l][j + k] == '0'){
                                isAllOne = false;
                                break;
                            }
                        }
                        if(isAllOne){
                            maxSide = Math.max(maxSide, k + 1);
                        }else{
                            break;
                        }
                    }

                }
            }
        }
        int maxArea = maxSide * maxSide;
        return maxArea;
    }

    /**
     * 方法二：动态规划
     * @param matrix
     * @return
     */
    public int maximalSquare2_self(char[][] matrix){
        if(null == matrix || matrix.length == 0 || matrix[0].length == 0){
            return  0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        int maxSide = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(matrix[i][j] == '1'){
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j - 1]),dp[i - 1][j]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        int maxArea = maxSide * maxSide;
        return maxArea;
    }
}

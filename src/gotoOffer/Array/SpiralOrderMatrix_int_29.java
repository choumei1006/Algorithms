package gotoOffer.Array;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author:choumei
 * @date:2020/6/5 10:12
 * @Description:  【顺时针打印矩阵】
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *  
 *
 * 限制：
 *
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 * 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/
 *
 */
public class SpiralOrderMatrix_int_29 {
    @Test
    public void test(){
        System.out.println(Arrays.toString(spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}})));
    }

    /**
     * 顺时针打印矩阵
     * @param matrix
     * @return
     */
    public int[] spiralOrder(int[][] matrix){
        //特判
        if(null == matrix || matrix.length == 0 || matrix[0].length == 0){
            return new int[0];
        }

        int row = matrix.length;
        int col = matrix[0].length;

        int mini = 0, maxi = row - 1;   //i边界
        int minj = 0, maxj = col - 1;   //j边界

        int[] res = new int[row * col];   //结果集
        int resIdx = 0;

        //旋转
        while(mini <= maxi && minj <= maxj){

            //最上方
            for(int j = minj; j <= maxj; j++){
                res[resIdx++] = matrix[mini][j];
            }
            mini++;

            //最右方
            for(int i = mini; i <= maxi; i++){
                res[resIdx++] = matrix[i][maxj];
            }
            maxj--;

            //此时边界有可能越界
            if(mini <= maxi && minj <= maxj){
                //最下方
                for(int j = maxj; j >= minj; j--){
                    res[resIdx++] = matrix[maxi][j];
                }
                maxi--;
                //最左方
                for(int i = maxi; i >= mini; i--){
                    res[resIdx++] = matrix[i][minj];
                }
                minj++;
            }
        }
        return res;
    }
}

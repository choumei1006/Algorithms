package LeetCode.DataStructures.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:choumei
 * @date:2020/3/15 11:09
 * @Description: 给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。
 *
 * 幸运数是指矩阵中满足同时下列两个条件的元素：
 *
 * 在同一行的所有元素中最小
 * 在同一列的所有元素中最大
 *
 *
 * 示例 1：
 *
 * 输入：matrix = [[3,7,8],[9,11,13],[15,16,17]]
 * 输出：[15]
 * 解释：15 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
 * 示例 2：
 *
 * 输入：matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
 * 输出：[12]
 * 解释：12 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
 * 示例 3：
 *
 * 输入：matrix = [[7,8],[1,2]]
 * 输出：[7]
 *
 *
 * 提示：
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= n, m <= 50
 * 1 <= matrix[i][j] <= 10^5
 * 矩阵中的所有元素都是不同的
 *
 * [[3,7,8],[9,11,13],[15,16,17]]
 */
public class LuckyNumber_5356 {
    public static void main(String[] args) {
        List<Integer> rst = luckyNumbers(new int[][]{{3,7,8},{9,11,13},{15,16,17}});
        //List<Integer> rst = luckyNumbers(new int[][]{});
        for (int temp : rst){
            System.out.println(temp);
        }
    }
    public static List<Integer> luckyNumbers (int[][] matrix) {
        if(null == matrix || matrix.length == 0 ){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        int[] minColIdx = new int[matrix.length];
        //计算所有行的最小值
        for(int i = 0;i < matrix.length;i++){
            int tempIdx = 0;
            for(int j = 0;j<matrix[i].length;j++){
                if(matrix[i][j] < matrix[i][tempIdx]){
                    tempIdx = j;
                }
            }
            minColIdx[i] = tempIdx;
            //map.put(tempIdx,matrix[i][tempIdx] > map.getOrDefault(tempIdx,Integer.MIN_VALUE) ? i : map.get(tempIdx));
        }
        //遍历所有行的最小值所在列是否为最大值
         
        for(int m = 0;m < minColIdx.length;m++){
            int n = 0;
            while(n < matrix.length && matrix[n][minColIdx[m]] <= matrix[m][minColIdx[m]] ){
                n++;
            }
            if(n == matrix.length){
                list.add(matrix[m][minColIdx[m]]);
            }
        }
        return list;
    }
}

package LeetCode.DataStructures.Array;

/**
 * @author:choumei
 * @date:2020/2/3 22:49
 * @Description: 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false
 *
 */
public class SearchA2DMatrixII_240 {
    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{1,   4,  7, 11, 15},
                                                    {2,   5,  8, 12, 19},
                                                    {3,   6,  9, 16, 22},
                                                    {10, 13, 14, 17, 24},
                                                    {18, 21, 23, 26, 30}},20));
    }

    public static boolean searchMatrix(int[][] matrix,int target){
        if(null == matrix || matrix.length == 0 || matrix.length == 0){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int i = m-1,j = 0;
        while(i >= 0 && j < n){
            if(matrix[i][j] == target){
                return true;
            }
            if(matrix[i][j] > target){
                i--;
            }else{
                j++;
            }
        }
        return false;
    }
}

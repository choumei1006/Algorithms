package LeetCode.DataStructures.Array;

/**
 * @author:choumei
 * @date:2020/2/3 22:52
 * @Description: 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 *
 */
public class SearchA2DMatrixI_74 {
    public static void main(String[] args) {
        System.out.println(searchMatrix2(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}},23));
    }

    /**
     * 方法一：暴力查找
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix1(int[][] matrix,int target){
        if(matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m ; i++) {
            if(matrix[i][n-1] >= target){
                for (int j = n-1; j >=0 ; j--) {
                    if(matrix[i][j] < target){
                        return false;
                    }
                    if(matrix[i][j] == target){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 方法二：两次二分法
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix2(int[][] matrix,int target){
        if(null == matrix || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        //第一次二分
        int l = 0,r = m-1;
        int res = -1;
        while(l <= r){
            int mid = (l+r)/2;
            if(matrix[mid][n-1] >= target){
                res = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        if( res == -1){
            return false;
        }
        //第二次二分
        l = 0;
        r = n-1;
        while( l <= r){
            int mid = (l+r)/2;
            if(matrix[res][mid] == target){
                return true;
            }else if(matrix[res][mid] < target){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return false;
    }
}

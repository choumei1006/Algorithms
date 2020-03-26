package LeetCode.ClassicalThinking.DFS;

import org.junit.Test;

/**
 * @author:choumei
 * @date:2020/3/26 12:26
 * @Description: n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 *
 *
 * 上图为 8 皇后问题的一种解法。
 *
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: 2
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 *
 */
public class NQueensII_52 {
    @Test
    public void test(){
        System.out.println(totalsNQueens(8));
    }
    int cnt = 0;
    public int totalsNQueens(int n){
        int[][] board = new int[n][n];
        backTrack(board,0);
        return cnt;
    }

    /**
     * 回溯访问棋盘
     * @param board
     * @param rowIdx
     */
    public void backTrack(int[][] board,int rowIdx){
        int queenSize = board.length;
        if(rowIdx == queenSize){
            cnt++;
            return ;
        }
        for(int col = 0; col < queenSize; col++){
            if(!(isValid(board,rowIdx,col))){
                continue;
            }
            //决策
            board[rowIdx][col] = 1;
            //回溯访问下一行
            backTrack(board,rowIdx+1);
            //插销决策
            board[rowIdx][col] = 0;
        }
    }

    /**
     * 判断坐标位置是否适合放置皇后
     * @param board
     * @param rowIdx
     * @param colIdx
     * @return
     */
    public boolean isValid(int[][] board, int rowIdx, int colIdx){
        int queenSize = board.length;
        //同一列
        for(int i = 0; i < rowIdx; i++){
            if(board[i][colIdx] == 1){
                return false;
            }
        }
        //左上方
        for(int i = rowIdx-1,j = colIdx-1; i >= 0 && j >= 0; i--,j--){
            if(board[i][j] == 1){
                return false;
            }
        }
        //右上方
        for(int i = rowIdx-1,j=colIdx+1; i >= 0 && j < queenSize; i--,j++){
            if(board[i][j] == 1){
                return false;
            }
        }
        return true;
    }
}

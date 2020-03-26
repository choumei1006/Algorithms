package LeetCode.ClassicalThinking.DFS;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author:choumei
 * @date:2020/3/26 12:05
 * @Description: n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 *
 *
 * 上图为 8 皇后问题的一种解法。
 *
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 *
 */
public class NQueens_51 {
    @Test
    public void test(){
        List<List<String>> res = solveNQueens(8);
        int idx = 0;
        for(List<String> list : res){
            System.out.println("方案"+ ++idx);
            for(String s : list){
                System.out.println("["+s+"]");
            }
        }
    }

    List<List<String>> res = new LinkedList<>();
    public List<List<String>> solveNQueens(int n){
        int[][] board = new int[n][n];
        backTrack(board,0);
        return res;
    }

    /**
     * 回溯访问棋盘
     * @param board
     * @param rowIdx
     */
    public void backTrack(int[][] board,int rowIdx){
        int queenSize = board.length;
        if(rowIdx == queenSize){
            res.add(format(board));
            return;
        }
        for(int col = 0; col < queenSize; col++){
            if(!(isValid(board,rowIdx,col))){
                continue;
            }
            board[rowIdx][col] = 1;
            backTrack(board,rowIdx+1);
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
    public boolean isValid(int[][] board,int rowIdx,int colIdx){
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
        for(int i = rowIdx-1,j = colIdx+1; i >= 0 && j < queenSize; i--,j++){
            if(board[i][j] == 1){
                return false;
            }
        }
        return true;
    }

    /**
     * 将二维数组转换为字符串集合表示的棋盘
     * @param board
     * @return
     */
    public List<String> format(int[][] board){
        List<String> res = new LinkedList<>();
        for(int[] list : board){
            StringBuilder sb = new StringBuilder();
            for(int i : list){
                if(i == 1){
                    sb.append('Q');
                }else{
                    sb.append('.');
                }
            }
            res.add(sb.toString());
        }
        return res;
    }
}

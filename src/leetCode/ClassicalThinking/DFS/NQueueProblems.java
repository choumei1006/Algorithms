package leetCode.ClassicalThinking.DFS;

import org.junit.Test;

import java.util.*;

/**
 * @author:choumei
 * @date:2020/3/25 14:40
 * @Description:
 */
public class NQueueProblems {
    @Test
    public void testNQueues(){
        List<List<String>> res = solveNQueues(8);
        int idx = 1;
        for(List<String> list : res){
            System.out.println("方案："+ idx++);
            for(String str : list){
                System.out.println("["+str+"]");
            }
        }
    }

    //结果集
    List<List<String>> res = new LinkedList<>();
    //N皇后问题
    public List<List<String>> solveNQueues(int n){
        int[][] board = new int[n][n];
        backTrack(board,0);
        return res;
    }


    /**
     * 回溯
     * @param board
     * @param rowIdx
     */
    public void backTrack(int[][] board, int rowIdx){
        int queenSize = board.length;
        if(rowIdx == queenSize){
            res.add(format(board));
            return;
        }

        for(int col = 0; col < queenSize; col++){
            if(!isValid(board,rowIdx,col)){
                continue;
            }
            //决策
            board[rowIdx][col] = 1;
            //进入下一行决策
            backTrack(board, rowIdx + 1);
            //撤销本次决策
            board[rowIdx][col] = 0;
        }
    }

    /**
     * 判断当前坐标是否适合放置皇后
     * @param board
     * @param rowIdx
     * @param colIdx
     * @return
     */
    public boolean isValid(int[][] board, int rowIdx, int colIdx){
        int queenSize = board.length;
        //检查所在列是否有皇后冲突
        for(int i = 0; i < rowIdx; i++){
            if(board[i][colIdx] == 1){
                return false;
            }
        }
        //判断左上方是否有皇后冲突
        for(int i = rowIdx-1, j = colIdx-1; i >= 0 && j >= 0; i--,j--){
            if(board[i][j] == 1){
                return false;
            }
        }
        //判断右上方是否有皇后冲突
        for(int i = rowIdx-1, j = colIdx+1; i >= 0 && j < queenSize; i--,j++){
            if(board[i][j] == 1){
                return false;
            }
        }
        return true;
    }

    /**
     * 将棋盘数据转换为‘Q’‘.’组成的集合
     * @param nums
     * @return
     */
    public List<String> format(int[][] nums){
        int n = nums.length;
        List<String> res = new LinkedList<>();
        for(int i = 0; i < n; i++){
            StringBuilder curStr = new StringBuilder();
            for(int j = 0; j < n; j++){
                if(nums[i][j] == 1){
                    curStr.append('Q');
                }else{
                    curStr.append('.');
                }
            }
            res.add(curStr.toString());
        }
        return res;
    }
}

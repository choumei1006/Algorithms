package leetCode.DataStructures.Array;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author:choumei
 * @date:2020/3/6 13:51
 * @Description: 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *
 */
public class FindContinuousSequencesII_intview57 {
    @Test
    public void test(){
        int[][] rst = findContinuousSequence(15);
        for (int i = 0; i < rst.length; i++) {
            for (int j = 0; j < rst[i].length; j++) {
                System.out.print(rst[i][j]+"\t");
            }
            System.out.println();
        }
    }
    public int[][] findContinuousSequence(int target) {
        ArrayList<int[]> rst = new ArrayList<>();
        int i = 1,j = 1;
        int sum = 0;
        while( i <= target/2){
            if(sum < target){
                sum += j;
                j++;
            }else if(sum > target){
                sum -= i;
                i++;
            }else{
                int[] tempRst = new int[j-i];
                for (int k = i; k < j; k++) {
                    tempRst[k-i] = k;
                }
                rst.add(tempRst);
                sum -= i;
                i++;
            }
        }
        return rst.toArray(new int[rst.size()][]);
    }
}

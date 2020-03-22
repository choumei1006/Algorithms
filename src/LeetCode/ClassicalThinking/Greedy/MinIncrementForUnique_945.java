package LeetCode.ClassicalThinking.Greedy;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author:choumei
 * @date:2020/3/22 22:08
 * @Description: 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
 *
 * 返回使 A 中的每个值都是唯一的最少操作次数。
 *
 * 示例 1:
 *
 * 输入：[1,2,2]
 * 输出：1
 * 解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
 * 示例 2:
 *
 * 输入：[3,2,1,2,1,7]
 * 输出：6
 * 解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
 * 可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。
 * 提示：
 *
 * 0 <= A.length <= 40000
 * 0 <= A[i] < 40000
 *
 */
public class MinIncrementForUnique_945 {
    @Test
    public void test(){
        int[] A = new int[]{1, 2, 2, 2, 2, 2};
        // int[] A = new int[]{3, 2, 1, 2, 1, 7};
        int res = minIncrementForUnique(A);
        System.out.println(res);
    }

    /**
     * 方法一：贪心算法
     * @param A
     * @return
     */
    public int minIncrementForUnique(int[] A){
        //特判
        if(null == A || A.length == 0){
            return 0;
        }
        Arrays.sort(A);
        int preNum = A[0];
        int res = 0;
        for (int i = 1; i < A.length; i++) {
            if(A[i] >= preNum+1){
                preNum = A[i];
            }else{
                res += preNum+1-A[i];
                preNum = preNum + 1;
            }
        }
        return res;
    }

    public int minIncrementForUnique2(int[] A) {
        int len = A.length;
        if (len == 0) {
            return 0;
        }

        Arrays.sort(A);
        // 打开调试
        // System.out.println(Arrays.toString(A));

        int preNum = A[0];
        int res = 0;
        for (int i = 1; i < len; i++) {
            // preNum + 1 表示当前数「最好」是这个值

            if (A[i] == preNum + 1) {
                preNum = A[i];
            } else if (A[i] > preNum + 1) {
                // 当前这个数已经足够大，这种情况可以合并到上一个分支
                preNum = A[i];
            } else {
                // A[i] < preNum + 1
                res += (preNum + 1 - A[i]);
                preNum++;
            }
        }
        return res;
    }



}

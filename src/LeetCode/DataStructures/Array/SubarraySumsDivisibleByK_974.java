package LeetCode.DataStructures.Array;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:choumei
 * @date:2020/5/27 8:25
 * @Description: 【和可被K整除的子数组】
 * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
 *
 *  
 *
 * 示例：
 *
 * 输入：A = [4,5,0,-2,-3,1], K = 5
 * 输出：7
 * 解释：
 * 有 7 个子数组满足其元素之和可被 K = 5 整除：
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 30000
 * -10000 <= A[i] <= 10000
 * 2 <= K <= 10000
 *
 */
public class SubarraySumsDivisibleByK_974 {
    @Test
    public void test(){
        System.out.println(subarraysDivByK2(new int[]{4,5,0,-2,-3,1}, 5));
    }

    /**
     * 方法一：暴力法
     * @param A
     * @param K
     * @return
     */
    public int subarraysDivByK1(int[] A, int K){
        //特判
        if(null == A){
            return 0;
        }
        int len = A.length;
        int cnt= 0;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            //以i为尾，从后往前加
            for (int j = i; j >= 0 ; j--) {
                sum += A[j];
                if(sum % K == 0){
                    cnt++;
                }
            }

        }
        return cnt;
    }

    /**
     * 方法二：前缀和+哈希表
     * ( preSum[j] - PreSum[i - 1] ) %  K == 0
     * ( preSum[j] % K ) == preSum[i - 1] % K
     * @param A
     * @param K
     * @return
     */
    public int subarraysDivByK2(int[] A, int K){
        if(null == A || A.length == 0){
            return 0;
        }
        int len = A.length;
        int preSum = 0;
        int resCnt = 0;
        Map<Integer,Integer> map = new HashMap<>();   //前缀和%K-次数
        map.put(0,1);
        for (int i = 0; i < len; i++) {
            if(A[i] < 0){
                A[i] = (A[i] % K) + K;
            }
            preSum += A[i];

            if(map.containsKey(preSum % K)){
                resCnt += map.getOrDefault(preSum % K, 0);
            }
            map.put(preSum % K, map.getOrDefault(preSum % K, 0) + 1);
        }
        return resCnt;
    }

}

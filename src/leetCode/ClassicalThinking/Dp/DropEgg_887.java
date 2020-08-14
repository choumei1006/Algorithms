package leetCode.ClassicalThinking.Dp;

import publicClasses.Logarithm;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:choumei
 * @date:2020/4/11 13:03
 * @Description: 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
 *
 * 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
 *
 * 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
 *
 * 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
 *
 * 你的目标是确切地知道 F 的值是多少。
 *
 * 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
 *
 *  
 *
 * 示例 1：
 *
 * 输入：K = 1, N = 2
 * 输出：2
 * 解释：
 * 鸡蛋从 1 楼掉落。如果它碎了，我们肯定知道 F = 0 。
 * 否则，鸡蛋从 2 楼掉落。如果它碎了，我们肯定知道 F = 1 。
 * 如果它没碎，那么我们肯定知道 F = 2 。
 * 因此，在最坏的情况下我们需要移动 2 次以确定 F 是多少。
 * 示例 2：
 *
 * 输入：K = 2, N = 6
 * 输出：3
 * 示例 3：
 *
 * 输入：K = 3, N = 14
 * 输出：4
 *  
 * 1 4
 * 4
 *
 * 1 1
 * 1
 * 提示：
 *
 * 1 <= K <= 100
 * 1 <= N <= 10000
 *
 */
public class DropEgg_887 {
    @Test
    public void test(){
        System.out.println(superEggDrop3(3,14));
    }
    public int superEggDrop1(int K, int N){
        double logTemp = Logarithm.log(N+1,2);
        int tempint = (int) Math.floor(logTemp);
        return tempint + (N > 1 ? 1 : 0);
    }
    public int superEggDrop2(int K, int N) {
        return dp(K, N);
    }

    Map<Integer, Integer> memo = new HashMap();
    public int dp(int K, int N) {
        // N * 100 + K：将N，K组合之后的值作为键值，避免自定义pair<N,K>带来的代码冗余;
        // 利用 N * 100 + K 组合后的值作为Key,就产生了避免hash冲突的问题；
        // 如何避免？
        // 假设dp二维数组的含义是：【N层楼，k个蛋】，
        // 因为K的取值在【1，100】之间，因此每一个【N,K】在一维数组中的索引就是：N * 100 + K,
        //
        // bingo!!!
        if (!memo.containsKey(N * 100 + K)) {
            int ans;
            if (N == 0)
                ans = 0;
            else if (K == 1)
                ans = N;
            else {
                int lo = 1, hi = N;
                while (lo + 1 < hi) {
                    int x = (lo + hi) / 2;
                    int t1 = dpHelper(K-1, x-1);
                    int t2 = dpHelper(K, N-x);

                    if (t1 < t2)
                        lo = x;
                    else if (t1 > t2)
                        hi = x;
                    else
                        lo = hi = x;
                }

                ans = 1 + Math.min(Math.max(dp(K-1, lo-1), dp(K, N-lo)),
                        Math.max(dp(K-1, hi-1), dp(K, N-hi)));
            }

            memo.put(N * 100 + K, ans);
        }

        return memo.get(N * 100 + K);
    }

    /**
     * 自测
     * @param K
     * @param N
     * @return
     */
    public int superEggDrop3(int K, int N){
        return dpHelper(K,N);
    }
    Map<Integer,Integer> map = new HashMap<>();
    public int dpHelper(int K, int N){
        if(!map.containsKey(N * 100 + K)){
            int ans = 0;
            if(N == 0){
                ans = 0;
            }else if(K == 1){
                ans = N;
            }else{
                int low = 1, high = N;
                while(low + 1 < high){
                    int x = (low + high)/2;
                    int T1 = dpHelper(K-1,x-1);
                    int T2 = dpHelper(K,N-x);

                    if(T1 > T2){
                        high = x;
                    }else if(T1 < T2){
                        low = x;
                    }else{
                        low = high = x;
                    }
                }
                ans = 1 + Math.min(Math.max(dpHelper(K-1,low-1),dpHelper(K,N-low)),
                                   Math.max(dpHelper(K-1,high-1),dpHelper(K,N-high)));
            }
            map.put(N * 100 + K, ans);
        }
        return map.get(N * 100 + K);
    }


}

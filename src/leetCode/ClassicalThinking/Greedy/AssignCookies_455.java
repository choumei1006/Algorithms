package leetCode.ClassicalThinking.Greedy;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author:choumei
 * @date:2020/5/24 9:13
 * @Description: 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 *
 * 注意：
 *
 * 你可以假设胃口值为正。
 * 一个小朋友最多只能拥有一块饼干。
 *
 * 示例 1:
 *
 * 输入: [1,2,3], [1,1]
 *
 * 输出: 1
 *
 * 解释:
 * 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
 * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
 * 所以你应该输出1。
 * 示例 2:
 *
 * 输入: [1,2], [1,2,3]
 *
 * 输出: 2
 *
 * 解释:
 * 你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
 * 你拥有的饼干数量和尺寸都足以让所有孩子满足。
 * 所以你应该输出2.
 *
 */
public class AssignCookies_455 {
    @Test
    public void test(){
        System.out.println(findContentChildren(new int[]{1,2}, new int[]{1,2,3}));
    }

    /**
     * 方法一：贪心算法
     * 思路:从最小的小孩、最小的饼干开始分配，这样可以选择一种当前看起来最优的分配方案；
     * Q:如何保证这样的贪心策略市全局最优的？
     * A:反证法证明；假设存在一种分配策略不满足贪心当前最优，而且可以保证满足孩子数更多；
     *  【证明】
     *  假设在某次选择中，贪心策略选择给当前满足度最小的孩子分配第 m 个饼干，
     *  第 m 个饼干为可以满足该孩子的最小饼干。
     *  假设存在一种最优策略，可以给该孩子分配第 n 个饼干，并且 m < n。
     *  我们可以发现，经过这一轮分配，贪心策略分配后剩下的饼干一定有一个比最优策略来得大。
     *  因此在后续的分配中，贪心策略一定能满足更多的孩子。
     *  也就是说不存在比贪心策略更优的策略，即贪心策略就是最优策略。
     *
     * @param grid
     * @param size
     * @return
     */
    public int findContentChildren(int[] grid, int[] size){
        //特判
        if(null == grid || null == size){
            return -1;
        }

        Arrays.sort(grid);   //胃口值排序
        Arrays.sort(size);   //饼干大小排序

        int gi = 0, si = 0;    //数组下标
        while(gi < grid.length && si < size.length){
            if(grid[gi] <= size[si]){
                gi++;
            }
            si++;
        }
        return gi;
    }

    /**
     * 自测：贪心策略
     *
     * @param grid
     * @param size
     * @return
     */
    public int findContentChild2(int[] grid, int[] size) {
        //特判
        if (null == grid || null == size) {
            return 0;
        }

        //1、将胃口值、饼干大小排序
        Arrays.sort(grid);
        Arrays.sort(size);
        //2、升序遍历两个数组，逐个判断满足当前胃口的孩子的最小饼干
        int cnt = 0;
        int gi = 0, si = 0;
        while (gi < grid.length && si < size.length) {
            if(grid[gi] <= size[si]){
                gi++;
            }
            si++;
        }

        return gi;
    }

}

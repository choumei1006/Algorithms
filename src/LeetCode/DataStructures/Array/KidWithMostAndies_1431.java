package LeetCode.DataStructures.Array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:choumei
 * @date:2020/6/1 8:16
 * @Description:  【拥有最多糖果的数量】
 * 给你一个数组 candies 和一个整数 extraCandies ，其中 candies[i] 代表第 i 个孩子拥有的糖果数目。
 *
 * 对每一个孩子，检查是否存在一种方案，将额外的 extraCandies 个糖果分配给孩子们之后，此孩子有 最多 的糖果。注意，允许有多个孩子同时拥有 最多 的糖果数目。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：candies = [2,3,5,1,3], extraCandies = 3
 * 输出：[true,true,true,false,true]
 * 解释：
 * 孩子 1 有 2 个糖果，如果他得到所有额外的糖果（3个），那么他总共有 5 个糖果，他将成为拥有最多糖果的孩子。
 * 孩子 2 有 3 个糖果，如果他得到至少 2 个额外糖果，那么他将成为拥有最多糖果的孩子。
 * 孩子 3 有 5 个糖果，他已经是拥有最多糖果的孩子。
 * 孩子 4 有 1 个糖果，即使他得到所有额外的糖果，他也只有 4 个糖果，无法成为拥有糖果最多的孩子。
 * 孩子 5 有 3 个糖果，如果他得到至少 2 个额外糖果，那么他将成为拥有最多糖果的孩子。
 * 示例 2：
 *
 * 输入：candies = [4,2,1,1,2], extraCandies = 1
 * 输出：[true,false,false,false,false]
 * 解释：只有 1 个额外糖果，所以不管额外糖果给谁，只有孩子 1 可以成为拥有糖果最多的孩子。
 * 示例 3：
 *
 * 输入：candies = [12,1,12], extraCandies = 10
 * 输出：[true,false,true]
 *  
 *
 * 提示：
 *
 * 2 <= candies.length <= 100
 * 1 <= candies[i] <= 100
 * 1 <= extraCandies <= 50
 *
 */
public class KidWithMostAndies_1431 {
    @Test
    public void test(){
        System.out.println(kidsWithCandies(new int[]{12,1,12}, 10).toString());
    }

    /**
     * 方法一：最大值
     * @param candies
     * @param extraCandies
     * @return
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies){
        //特判
        if(null == candies || candies.length == 0){
            return null;
        }
        //是否有可能成为糖果最多的孩子
        List<Boolean> res = new ArrayList<>();

        //获得分配糖果之前最多的糖果数
        int mostCandies = 0;
        for(int c : candies){
            mostCandies = Math.max(mostCandies, c);
        }

        //遍历判断将所有剩余糖果分给这个孩子之后，会不会成为糖果最多的孩子
        for(int c : candies){
            res.add((c + extraCandies) >=mostCandies);
        }

        return res;
    }

}

package LeetCode.ClassicalThinking.Recall;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:choumei
 * @date:2020/4/25 12:08
 * @Description:   【全排列】
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 */
public class PermutationI_46 {
    @Test
    public void test(){
        System.out.println(permute(new int[]{1,2,3}).toString());
    }

    /**
     * 全排列
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums){
        if(null == nums || nums.length == 0){
            return null;
        }
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();  //结果集：全排列集合
        List<Integer> curPath = new ArrayList<>();   //当前路径组合
        boolean[] used = new boolean[len];
        dfs(nums,len,0,curPath,used,res);
        return res;
    }

    /**
     * 回溯（深度优先遍历）：获取所有可能的排列
     * @param nums
     * @param len
     * @param depth
     * @param curPath
     * @param res
     */
    public void dfs(int[] nums, int len, int depth, List<Integer> curPath, boolean[] used, List<List<Integer>> res){
        //边界:符合一个组合的长度
        if(depth == len){
            res.add(new ArrayList<>(curPath));
            return;
        }
        for (int i = 0; i < len; i++) {
            if(!used[i]){
                //访问
                curPath.add(nums[i]);
                used[i] = true;

                //递归
                dfs(nums,len,depth+1,curPath,used,res);

                //撤销操作
                used[i] = false;
                curPath.remove(curPath.size() - 1);
            }
        }
    }
}

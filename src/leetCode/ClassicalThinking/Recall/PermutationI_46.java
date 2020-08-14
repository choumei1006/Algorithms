package leetCode.ClassicalThinking.Recall;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
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
     * 全排列:适用于重复元素数组
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

    //==================================2020-08-14自测==========================

    @Test
    public void test2(){
        System.out.println(permute3(new int[]{1, 2, 3}));
    }

    /**
     * 全排列
     * 缺点：不适用于重复元素的数组
     * @param nums
     * @return
     */
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute2(int[] nums) {
        //特判
        if (null == nums || nums.length == 0) {
            return null;
        }
        backTrack(nums, new ArrayList<>());
        return res;
    }

    /**
     * 回溯
     *
     * @param nums
     * @param track 当前已访问路径记录
     */
    public void backTrack(int[] nums, List<Integer> track) {
        //边界
        if (track.size() == nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(!track.contains(nums[i])){   //此处需要改进：contains耗时O(n)
                //访问下一个节点
                track.add(nums[i]);
                backTrack(nums, track);   //回溯

                //撤销操作
                track.remove(track.size() - 1);   //移除最后一个加入的元素
            }
        }
    }

    /**
     * 全排列
     * 适用于包含重复元素的数组
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute3(int[] nums) {
        //特判
        if (null == nums || nums.length == 0) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();   //结果集
        List<Integer> curPath = new ArrayList<>();    //当前已访问路径

        boolean[] used = new boolean[nums.length];    //元素是否被当前路径访问过

        backTrack2(nums, curPath, used, res);
        return res;
    }

    /**
     *
     * @param nums
     * @param curPath
     * @param used
     * @param res
     */
    public void backTrack2(int[] nums, List<Integer> curPath, boolean[] used, List<List<Integer>> res){
        //边界
        if(curPath.size() == nums.length){
            res.add(new ArrayList<>(curPath));
            return;
        }

        //循环未被访问过的nums
        for (int i = 0; i < nums.length; i++) {
            if(!used[i]){
                //访问当前节点
                used[i] = true;
                curPath.add(nums[i]);

                //向下回溯
                backTrack2(nums, curPath, used, res);

                //撤销选择
                used[i] = false;
                curPath.remove(curPath.size() - 1);
            }
        }
    }


}

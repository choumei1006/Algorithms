package leetCode.DataStructures.Array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:choumei
 * @date:2020/8/6 10:44
 * @Description:  给定一个不包含相同元素的整数集合，nums,返回所有可能的子集集合。解答中不包含重复的子集
 */
public class SubSets_P178 {
    @Test
    public void test(){

    }


    /**
     * 获取数组nums的所有子集集合
     *
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> getSubSets(int[] nums) {
        //特判
        if (null == nums || nums.length == 0) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> item = new ArrayList<Integer>();

        dfs(nums, 0, item, res);

        res.add(new ArrayList<>());   //加入空集
        return res;
    }

    /**
     * 深度优先遍历，过程中保存所有子集
     * @param nums
     * @param start
     * @param item
     * @param res
     */
    public void dfs(int[] nums, int start, List<Integer> item, List<List<Integer>> res){
        for (int i = start; i < nums.length; i++) {
            item.add(nums[i]);
            res.add(new ArrayList<>(item));   //复制内容
            dfs(nums, i, item, res);
            item.remove(item.size() - 1);    //移除最后一个，撤销上述操作
        }
    }
}

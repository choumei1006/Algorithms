package leetCode.ClassicalThinking.Recall;

import org.junit.Test;

import java.util.*;

/**
 * @author:choumei
 * @date:2020/4/25 17:30
 * @Description: 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 */
public class PermutationII_47 {
    @Test
    public void test(){
        System.out.println(permute(new int[]{3,3,0,3}).toString());
    }
    //全排列（有重复元素）
    public List<List<Integer>> permute(int[] nums){
        //特判
        if(null == nums || nums.length == 0){
            return null;
        }
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();  //结果集
        Deque<Integer> curPath = new ArrayDeque<>(len);   //当前排列状态
        boolean[] used = new boolean[len];   //使用状态

        Arrays.sort(nums);   // 必须！！！！   （剪枝的基础就是有序）

        dfs(nums, len, 0, curPath, used, res);

        return res;
    }

    //回溯（深度优先遍历）
    public void dfs(int[] nums, int len, int depth, Deque<Integer> curPath, boolean[] used, List<List<Integer>> res){
        //边界
        if(depth == len){
            res.add(new ArrayList<>(curPath));
            return;
        }

        for (int i = 0; i < len; i++) {
            if(used[i]){
                continue;
            }
            //判断前一个刚刚撤销的元素是否和当前元素相等
            if(i > 0 && nums[i] == nums[i-1] && !used[i-1]){
                continue;
            }
            //执行操作
            curPath.addLast(nums[i]);
            used[i] = true;

            //回溯
            dfs(nums, len, depth+1, curPath, used, res);

            //撤销操作
            used[i] = false;
            curPath.removeLast();
        }
    }
}

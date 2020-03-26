package LeetCode.ClassicalThinking.DFS;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author:choumei
 * @date:2020/3/25 13:02
 * @Description: 数组全排列问题
 */
public class PermuteTest {
    @Test
    public void test(){
        List<List<Integer>> lists = permute(new int[]{1, 2, 3});
        for(List tempList : lists){
            System.out.println(tempList.toString());
        }
    }
    //所有排列集合

    private List<List<Integer>> res = new LinkedList<>();
    //全排列
    public List<List<Integer>> permute(int[] nums){
        //已访问路径
        LinkedList<Integer> track = new LinkedList<>();
        //访问
        backTrack(nums,track);
        return res;
    }
    //回溯函数
    public void backTrack(int[] nums, LinkedList<Integer> track){
        //是否满足一个排列
        if(track.size() == nums.length){
            res.add(new LinkedList<>(track));
            return;

        }
        for(int i = 0; i < nums.length; i++){
            int curr = nums[i];
            if(track.contains(curr)){
                continue;
            }
            track.add(curr);
            backTrack(nums,track);
            track.removeLast();
        }
    }
}

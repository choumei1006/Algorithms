package exam.Nova.LiZhiJie;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author:choumei
 * @date:2020/9/11 14:56
 * @Description:  用1，2，3，4，5这6个数组，紫萼一个main函数，打印出所有不同的排列，如52431，421253，
 * 要求：“5”不能在第三位，“2”，“3”不能相连；
 */
public class Permutation_5 {
    public static void main(String[] args) {
        Set<List<Integer>> rst = permute(new int[]{1,2,2,3,4,5});
        for(List list  : rst){
            for(Object i : list){
                System.out.print((Integer)i);
            }
            System.out.println();
        }
    }

    /**
     * 获取数组全排列（满足特殊要求）
     * @return
     */
    public static Set<List<Integer>> permute(int[] nums){
        //结果集
        Set<List<Integer>> rst = new HashSet<>();
        //记录每一趟访问
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        permuteHelper(nums, track, visited, rst);
        return rst;
    }

    /**
     * 辅助类：回溯法
     *
     * @param nums
     * @param track
     * @param rst
     */
    public static void permuteHelper(int[] nums, LinkedList<Integer> track, boolean[] visited, Set<List<Integer>> rst) {
        //特判
        if (null == nums || nums.length == 0){
            return;
        }
        //判断是否满足一个排列
        if(track.size() == nums.length){
            rst.add(new LinkedList<>(track));
        }

        //回溯
        for (int i = 0; i < visited.length; i++) {
            //已访问
            if (visited[i]) {
                continue;
            }
            //未访问
            if(track.size() == 2 && nums[i] == 5){
                continue;
            }
            if(track.size() > 0){
                int lastTrack = track.get(track.size() - 1);
                if( (lastTrack == 2 || lastTrack == 3) && (lastTrack + nums[i] == 5)){
                    continue;
                }
            }

            //访问
            track.add(nums[i]);
            visited[i] = true;
            permuteHelper(nums, track, visited, rst);


            //撤销
            track.removeLast();
            visited[i] = false;
        }

    }
}

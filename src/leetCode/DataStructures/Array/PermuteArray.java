package leetCode.DataStructures.Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author:choumei
 * @date:2020/10/15 20:50
 * @Description:
 */
public class PermuteArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //n
        int m = sc.nextInt();   //m

        String nStr = n + "";

        List<String> rstList = permute(nStr.toCharArray(), m);
        System.out.println(rstList.size());
    }

    /**
     * 全排列
     * @param nums
     * @return
     */
    public static List<String> permute(char[] nums, int m){
        if(null == nums || nums.length == 0){
            return null;
        }
        int len = nums.length;
        List<String> res = new ArrayList<>();  //结果集：全排列集合
        List<Character> curPath = new ArrayList<>();   //当前路径组合
        boolean[] used = new boolean[len];
        dfs(nums,len,0,curPath,used,res,m);
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
    public static void dfs(char[] nums, int len, int depth, List<Character> curPath, boolean[] used, List<String> res, int m){
        //边界:符合一个组合的长度
        if(depth == len){
            StringBuilder tempRst = new StringBuilder();
            for(Character c : curPath){
                tempRst.append(c);
            }
            if(Integer.parseInt(tempRst.toString()) % m == 0) {
                res.add(String.valueOf(curPath));
            }
            return;
        }
        for (int i = 0; i < len; i++) {
            if(!used[i]){
                //访问
                curPath.add(nums[i]);
                used[i] = true;

                //递归
                dfs(nums,len,depth+1,curPath,used,res,m);

                //撤销操作
                used[i] = false;
                curPath.remove(curPath.size() - 1);
            }
        }
    }


}

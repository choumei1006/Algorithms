package LeetCode.DataStructures.Tree.BST;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:choumei
 * @date:2020/5/24 11:59
 * @Description: 【二叉树中伪回文路径数】
 *
 * 给你一棵二叉树，每个节点的值为 1 到 9 。我们称二叉树中的一条路径是 「伪回文」的，
 * 当它满足：路径经过的所有节点值的排列中，存在一个回文序列。
 *
 * 请你返回从根到叶子节点的所有路径中 伪回文 路径的数目。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [2,3,1,3,1,null,1]
 * 输出：2
 * 解释：上图为给定的二叉树。总共有 3 条从根到叶子的路径：红色路径 [2,3,3] ，
 * 绿色路径 [2,1,1] 和路径 [2,3,1] 。
 *      在这些路径中，只有红色和绿色的路径是伪回文路径，因为红色路径 [2,3,3]
 *      存在回文排列 [3,2,3] ，绿色路径 [2,1,1] 存在回文排列 [1,2,1] 。
 * 示例 2：
 *
 *
 *
 * 输入：root = [2,1,1,1,3,null,null,null,null,null,1]
 * 输出：1
 * 解释：上图为给定二叉树。总共有 3 条从根到叶子的路径：绿色路径 [2,1,1] ，
 * 路径 [2,1,3,1] 和路径 [2,1] 。
 *      这些路径中只有绿色路径是伪回文路径，因为 [2,1,1] 存在回文排列 [1,2,1] 。
 * 示例 3：
 *
 * 输入：root = [9]
 * 输出：1
 *
 *
 * 提示：
 *
 * 给定二叉树的节点数目在 1 到 10^5 之间。
 * 节点值在 1 到 9 之间。
 */
public class PeseudoPalindromePaths_5418 {
    @Test
    public void test(){
        //TreeNode root = TreeNode.initTree(TreeNode.initTreeNodeList(new Integer[]{2,1,1,1,3,null,null,null,null,null,1,null,null,null,null}));
        TreeNode root = TreeNode.initTree(TreeNode.initTreeNodeList(new Integer[]{9}));
        System.out.println(peseudoPalindromicPaths(root));
    }

    /**
     * 回溯法
     * @param root
     * @return
     */
    public  int resCnt = 0;
    public int peseudoPalindromicPaths(TreeNode root){
        if(null == root){
            throw new IllegalArgumentException("参数不合法！");
        }
        Map<Integer,Integer> tmpMap = new HashMap<>();  //已访问的节点集合
        pathHelper(root, tmpMap);
        return resCnt;
    }

    /**
     * 回溯得到root中以tmpList为 已有路径 的 伪回文路径 个数
     * @param root
     * @param tmpMap
     * @return
     */
    public void pathHelper(TreeNode root, Map<Integer,Integer> tmpMap){
        if(null == root){
            return;
        }

        tmpMap.put(root.val, tmpMap.getOrDefault(root.val, 0) + 1); //访问当前节点

        //边界条件
        if(null == root.left && null == root.right){
            int oddCnt = 0;
            for(Map.Entry entry : tmpMap.entrySet()){
                if((int)entry.getValue() > 0 && (int)entry.getValue() % 2 != 0){
                    oddCnt++;
                }
            }
            if(oddCnt <= 1){
                resCnt++;
            }
            /*tmpMap.put(root.val, tmpMap.getOrDefault(root.val, 0) - 1);
            return oddCnt <= 1 ? 1 : 0;*/
        }

        pathHelper(root.left, tmpMap);
        pathHelper(root.right, tmpMap);

        tmpMap.put(root.val, tmpMap.getOrDefault(root.val, 0) - 1);
    }
}

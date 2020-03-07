package LeetCode.DataStructures.Tree.BST;

import jdk.jfr.StackTrace;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:choumei
 * @date:2020/3/7 22:42
 * @Description: 给你一棵以 root 为根的二叉树，二叉树中的交错路径定义如下：
 *
 * 选择二叉树中 任意 节点和一个方向（左或者右）。
 * 如果前进方向为右，那么移动到当前节点的的右子节点，否则移动到它的左子节点。
 * 改变前进方向：左变右或者右变左。
 * 重复第二步和第三步，直到你在树中无法继续移动。
 * 交错路径的长度定义为：访问过的节点数目 - 1（单个节点的路径长度为 0 ）。
 *
 * 请你返回给定树中最长 交错路径 的长度。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1]
 * 输出：3
 * 解释：蓝色节点为树中最长交错路径（右 -> 左 -> 右）。
 * 示例 2：
 *
 *
 *
 * 输入：root = [1,1,1,null,1,null,null,1,1,null,1]
 * 输出：4
 * 解释：蓝色节点为树中最长交错路径（左 -> 右 -> 左 -> 右）。
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：0
 *
 *
 * 提示：
 *
 * 每棵树最多有 50000 个节点。
 * 每个节点的值在 [1, 100] 之间。
 */
public class LongestZigzagPathLength_5338 {
    @Test
    public void test(){
        TreeNode root = TreeNode.initTree(TreeNode.initTreeNodeList(new Integer[]{1,1,1,null,1,null,null,null,null,1,1,null,null,null,null,null,null,null,null,null,1}));
        System.out.println(longestZigZag(root));
    }
    Map<TreeNode,Map<Integer,Integer>> map = new HashMap<>();
    public int longestZigZag(TreeNode root) {
        if(null == root){
            return 0;
        }
        return helper1(root);

    }
    public int helper1(TreeNode root){
        if(null == root){
            return 0;
        }
        return Math.max(Math.max(Math.max(helper2(root.left,1)+1,helper2(root.right,0)+1),helper1(root.left)),helper1(root.right));
    }
    public int helper2(TreeNode root,int dir){
        if(null == root){
            return -1;
        }
        TreeNode nextRoot = dir == 0 ? root.left : root.right;
        if(null == nextRoot){
            return 0;
        }
        int tempDir = dir==0 ? 1 : 0;
        Map<Integer,Integer> m = map.get(root);
        Integer mapRst = null == m ? null:m.get(tempDir);

        if(null != mapRst){
            return mapRst;
        }else {
            int rst = helper2(nextRoot, tempDir) + 1;
            Map<Integer, Integer> tempMap = map.getOrDefault(nextRoot, new HashMap<>());
            tempMap.put(tempDir, rst);
            map.put(nextRoot, tempMap);
            return rst;
        }
    }
}

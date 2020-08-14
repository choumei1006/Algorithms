package leetCode.DataStructures.Tree.LevelFind;

import publicClasses.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * @author:choumei
 * @date:2020/5/13 21:29
 * @Description: 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 *  
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 */
public class LevelOrder_102 {
    @Test
    public void test(){
        TreeNode root = TreeNode.initTree(TreeNode.initTreeNodeList(new Integer[]{3,9,20,null,null,15,7}));
        System.out.println(levelOrder(root).toString());
    }
    public List<List<Integer>> levelOrder(TreeNode root){
        if(null == root){
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();   //结果集
        Queue<Map<TreeNode,Integer>> queue = new LinkedList<>();   //队列

        queue.offer(Map.of(root,1));  //将root加入队列
        int curLevel = 1;
        List<Integer> curList = new ArrayList<>();   //存放临时list

        while(!queue.isEmpty()){

            Map<TreeNode,Integer> curMap = queue.poll();
            TreeNode node = curMap.entrySet().iterator().next().getKey();
            Integer level = curMap.entrySet().iterator().next().getValue();
            if(level > curLevel){
                res.add(new ArrayList<>(curList));
                curList = new ArrayList<>();
                curLevel = level;
            }
            curList.add(node.val);
            if(null != node.left){
                queue.offer(Map.of(node.left, level + 1));
            }
            if(null != node.right){
                queue.offer(Map.of(node.right, level + 1));
            }
        }
        res.add(new ArrayList<>(curList));
        return res;
    }
}

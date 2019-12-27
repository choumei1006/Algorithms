package LeetCode.DataStructures.Tree.LevelFind;

import PublicClasses.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author:choumei
 * @date:2019/12/27 17:17
 * @Description: 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.
 *
 * 示例 1:
 *
 * 输入:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出: [3, 14.5, 11]
 * 解释:
 * 第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].
 * 注意：
 *
 * 节点值的范围在32位有符号整数范围内。
 *
 */
public class AverageOfLevelsInBinaryTree_637 {
    public static void main(String[] args) {
        Integer[] list = {3,9,20,null,null,15,7};
        TreeNode tree = TreeNode.initTree(TreeNode.initTreeNodeList(list));
        List<Double> result = averageOfLevels(tree);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i)+"\t");
        }
    }

    public static List<Double> averageOfLevels(TreeNode root){
        List<Double> result = new ArrayList<>();
        if(null == root) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            double sum = 0;
            for (int i = 0; i < size ; i++) {
                TreeNode node = q.poll();
                sum += node.val;
                if(null != node.left) q.add(node.left);
                if(null != node.right) q.add(node.right);
            }
            result.add(sum/size);
        }
        return result;
    }


}


package leetCode.DataStructures.Tree.Recurrence;

import publicClasses.TreeNode;

/**
 * @author:choumei
 * @date:2019/12/24 19:15
 * @Description: 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 *
 */
public class MinimumDepthOfBinaryTree_111 {
    public static void main(String[] args) {
        Integer[] list = {3,9,20,null,null,15,7};
        TreeNode tree = TreeNode.initTree(TreeNode.initTreeNodeList(list));
        System.out.println(minDepth(tree));
    }
    public static int minDepth(TreeNode root){
        if(null == root) return 0;
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        if(leftDepth == 0 || rightDepth == 0){
            //一边深度等于0说明某一边没有叶子节点
            return leftDepth + rightDepth +1;
        }
        return Math.min(leftDepth,rightDepth)+1;
    }
}

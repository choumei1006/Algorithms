package LeetCode.DataStructures.Tree.BST;

import PublicClasses.TreeNode;

/**
 * @author:choumei
 * @date:2020/1/1 11:02
 * @Description: 给定一个所有节点为非负值的二叉搜索树，求树中任意两节点的差的绝对值的最小值。
 *
 * 示例 :
 *
 * 输入:
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * 输出:
 * 1
 *
 * 解释:
 * 最小绝对差为1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 * 注意: 树中至少有2个节点。
 *
 */
public class MinimumAbsoluteDifferenceInBST_530 {
    private static int minDiff  = Integer.MAX_VALUE;
    private static TreeNode preNode;
    public static void main(String[] args) {
        Integer[] list = {1,null,3,null,null,2,null};
        TreeNode tree = TreeNode.initTree(TreeNode.initTreeNodeList(list));
        System.out.println(getMinimumDifference(tree));
    }
    public static int getMinimumDifference(TreeNode root){
        inOrder(root);
        return minDiff;
    }
    private static void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        if (preNode != null) minDiff = Math.min(minDiff, node.val - preNode.val);
        preNode = node;
        inOrder(node.right);
    }
}

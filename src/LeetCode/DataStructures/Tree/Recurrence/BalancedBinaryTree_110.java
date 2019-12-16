package LeetCode.DataStructures.Tree.Recurrence;

import PublicClasses.TreeNode;

/**
 * @author:choumei
 * @date:2019/12/16 8:46
 * @Description: 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 *
 */
public class BalancedBinaryTree_110 {
    private static  boolean result = true;
    public static void main(String[] args) {
        TreeNode l2_1 =  new TreeNode(2);
        TreeNode l2_2 = new TreeNode(3);
        TreeNode l3_1 = new TreeNode(4);
        TreeNode l3_2 = new TreeNode(5);
        TreeNode l4_1 = new TreeNode(5);
        TreeNode l4_2 = new TreeNode(5);

        TreeNode l1 = new TreeNode(1);
        l1.left = l2_1;
        l1.right = l2_2;
        l2_1.left = l3_1;
        l2_1.right = l3_2;
        l3_1.left = l4_1;
        l3_1.right = l4_2;

        System.out.println(isBalanced(null));
    }

    //纯递归，时间复杂度超过100%
    public static boolean isBalanced1(TreeNode root){
        if(null == root) return true;
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(maxDepth1(root.left)-maxDepth1(root.right)) <=1;
    }
    public static int maxDepth1(TreeNode root){
        if(null == root) return 0;
        return Math.max(maxDepth1(root.left),maxDepth1(root.right))+1;
    }

    //考虑空间利用率
    public static boolean isBalanced(TreeNode root){
        findMaxDepth(root);
        return result;
    }
    public static int findMaxDepth(TreeNode root){
        if(null == root) return 0;
        int lLen = findMaxDepth(root.left);
        int rLen = findMaxDepth(root.right);
        if(Math.abs(lLen-rLen) > 1) result = false;
        return Math.max(lLen,rLen)+1;
    }

}

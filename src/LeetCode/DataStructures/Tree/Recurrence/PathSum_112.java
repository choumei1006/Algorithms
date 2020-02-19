package LeetCode.DataStructures.Tree.Recurrence;

import PublicClasses.TreeNode;

/**
 * @author:choumei
 * @date:2019/12/20 21:56
 * @Description: 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，
 * 这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 *
 */
public class PathSum_112 {
    public static void main(String[] args) {
        TreeNode l1_1 = new TreeNode(5);
        TreeNode l2_1 = new TreeNode(4);
        TreeNode l2_2 = new TreeNode(8);
        TreeNode l3_1 = new TreeNode(11);
        TreeNode l3_2 = new TreeNode(13);
        TreeNode l3_3 = new TreeNode(4);
        TreeNode l4_1 = new TreeNode(7);
        TreeNode l4_2 = new TreeNode(2);
        TreeNode l4_3 = new TreeNode(1);

        l1_1.left = l2_1;
        l1_1.right = l2_2;
        l2_1.left = l3_1;
        l2_2.left = l3_2;
        l2_2.right = l3_3;
        l3_1.left = l4_1;
        l3_1.right = l4_2;
        l3_3.right = l4_3;

        System.out.println(hasPathSum(l1_1,22));
    }
    public static boolean hasPathSum(TreeNode root,int sum){
        if(null == root) return false;  //边界条件1：sum还没递减结束
        if( null == root.left && null == root.right){   //边界条件2：到叶子节点：左右子节点均为null，此时sum可能为负
            return root.val == sum ? true : false;
        }
        return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
    }

    //时间效率高
    public static boolean hasPathSum2(TreeNode root,int sum){
        if (root == null) return false;
        if (root.left == null && root.right == null && root.val == sum) return true;
        return hasPathSum2(root.left, sum - root.val) || hasPathSum2(root.right, sum - root.val);
    }
}

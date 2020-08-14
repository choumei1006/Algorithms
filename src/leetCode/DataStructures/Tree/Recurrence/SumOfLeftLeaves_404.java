package leetCode.DataStructures.Tree.Recurrence;

import publicClasses.TreeNode;

/**
 * @author:choumei
 * @date:2019/12/25 18:45
 * @Description: 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 */
public class SumOfLeftLeaves_404 {
    public static void main(String[] args) {
        Integer[] list = {3,9,20,null,null,15,7};
        TreeNode tree = TreeNode.initTree(TreeNode.initTreeNodeList(list));
        System.out.println(sumOfLeftLeaves(tree));
    }

    /**
     * 求二叉树的左叶子节点的和
     * @param root
     * @return
     */
    public static int sumOfLeftLeaves(TreeNode root){
        if(null == root) return 0;
        if(isLeaf(root.left)){
            return root.left.val+sumOfLeftLeaves(root.right);
        }
        return sumOfLeftLeaves(root.left)+sumOfLeftLeaves(root.right);
    }

    /**
     * 判断某个节点是不是叶子节点
     * @param root
     * @return
     */
    public static boolean isLeaf(TreeNode root){
        if(null == root) return false;
        return (null == root.left) && (null == root.right);
    }
}

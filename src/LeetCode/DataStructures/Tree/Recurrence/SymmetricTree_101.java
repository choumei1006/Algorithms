package LeetCode.DataStructures.Tree.Recurrence;

import PublicClasses.TreeNode;
import org.w3c.dom.ls.LSOutput;

/**
 * @author:choumei
 * @date:2019/12/23 21:57
 * @Description: 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * 说明:
 *
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 *
 */
public class SymmetricTree_101 {
    public static void main(String[] args) {
        Integer[] list = new Integer[]{1,2,2,null,3,null,3};
        TreeNode tree = TreeNode.initTree(TreeNode.initTreeNodeList(list));

        System.out.println(isSymmetric(tree));
    }

    /**
     * 判断一个二叉树是不是左右对称
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root){
        if(null == root) return true;
        return isSymmetric(root.left,root.right);
    }

    /**
     * 判断两个是不是对称
     * @param root1
     * @param root2
     * @return
     */
    public static boolean isSymmetric(TreeNode root1,TreeNode root2){
        if(null == root1 && null == root2) return true;
        if(null == root1 || null == root2 || root1.val != root2.val) return false;
        return isSymmetric(root1.left,root2.right) && isSymmetric(root1.right,root2.left);
    }

}

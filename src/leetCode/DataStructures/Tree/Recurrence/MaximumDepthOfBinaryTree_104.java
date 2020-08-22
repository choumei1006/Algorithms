package leetCode.DataStructures.Tree.Recurrence;

import org.junit.Test;
import publicClasses.TreeNode;

/**
 * @author:choumei
 * @date:2019/12/15 16:29
 * @Description: 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 */
public class MaximumDepthOfBinaryTree_104 {
    public static void main(String[] args) {
        TreeNode l2_1 = new TreeNode(2);
        TreeNode l2_2 = new TreeNode(3);
        TreeNode l3_1 = new TreeNode(4);
        TreeNode l3_2 = new TreeNode(5);

        TreeNode l1 = new TreeNode(1);
        l1.left = l2_1;
        l1.right = l2_2;
        l2_2.left = l3_1;
        l2_2.right = l3_2;

        System.out.println(maxDepth(l1));
    }
    public static int maxDepth(TreeNode root){
        if(null == root){
            return 0;
        }else{
            return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
        }
    }

    @Test
    public void test(){

    }

    /**
     * 返回当前根节点树高
     *
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        //特判
        if (null == root) {
            return 0;
        }
        //递归
        return Math.max(maxDepth2(root.left), maxDepth2(root.right)) + 1;
    }
}

package LeetCode.DataStructures.Tree.Recurrence;

import PublicClasses.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author:choumei
 * @date:2019/12/19 19:44
 * @Description: 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 *
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 *
 * 示例 1:
 *
 * 输入:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * 输出:
 * 合并后的树:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 * 注意: 合并必须从两个树的根节点开始。
 *
 */
public class MergeTwoBineryTrees_617 {
    public static void main(String[] args) {
        TreeNode t1_2_1 = new TreeNode(2);
        TreeNode t1_2_2 = new TreeNode(3);
        TreeNode t1_3_1 = new TreeNode(4);;
        TreeNode t1_3_2 = new TreeNode(5);
        TreeNode t1_4_1 = new TreeNode(6);

        TreeNode t1_1 = new TreeNode(1);
        t1_1.left = t1_2_1;
        t1_1.right = t1_2_2;
        t1_2_1.left = t1_3_1;
        t1_2_2.right = t1_3_2;
        t1_3_1.left = t1_4_1;

        TreeNode t2_2_1 = new TreeNode(2);;
        TreeNode t2_2_2 = new TreeNode(3);;
        TreeNode t2_3_1 = new TreeNode(4);;
        TreeNode t2_3_2 = new TreeNode(5);;
        TreeNode t2_4_1 = new TreeNode(6);

        TreeNode t2_1 = new TreeNode(1);
        t2_1.left = t2_2_1;
        t2_1.right = t2_2_2;
        t2_2_1.right = t2_3_1;
        t2_2_2.left = t2_3_2;
        t2_3_1.right = t2_4_1;

        TreeNode mergeRst = mergeTrees(t1_1,t2_1);
        printTree(mergeRst);
    }
    public static TreeNode mergeTrees(TreeNode t1,TreeNode t2){
        if(null == t1 && null == t2) return null;
        if(null == t1) return t2;
        if(null == t2) return t1;
        TreeNode newNode = new TreeNode(t1.val+t2.val);
        newNode.left = mergeTrees(t1.left,t2.left);
        newNode.right = mergeTrees(t1.right,t2.right);
        return newNode;
    }

    /**
     * 输出树形节点
     * @param root
     */
    public static void printTree(TreeNode root){
        Queue<TreeNode>  q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            System.out.print(node.val);
            if(null != node.left) q.offer(node.left);
            if(null != node.right) q.offer(node.right);
        }
    }
}

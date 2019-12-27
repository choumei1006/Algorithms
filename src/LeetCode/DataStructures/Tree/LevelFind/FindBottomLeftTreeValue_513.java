package LeetCode.DataStructures.Tree.LevelFind;

import LeetCode.ClassicalThinking.DoublePointer.LinkedListCycle_141;
import PublicClasses.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author:choumei
 * @date:2019/12/27 17:44
 * @Description: 给定一个二叉树，在树的最后一行找到最左边的值。
 *
 * 示例 1:
 *
 * 输入:
 *
 *     2
 *    / \
 *   1   3
 *
 * 输出:
 * 1
 *  
 *
 * 示例 2:
 *
 * 输入:
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   5   6
 *        /
 *       7
 *
 * 输出:
 * 7
 *  
 *
 * 注意: 您可以假设树（即给定的根节点）不为 NULL。
 *
 */
public class FindBottomLeftTreeValue_513 {
    public static void main(String[] args) {
        Integer[] list = {1,2,3,4,null,5,6,null,null,null,null,7,null,null,null};
        TreeNode tree = TreeNode.initTree(TreeNode.initTreeNodeList(list));
        System.out.println(findBottomLeftValue(tree));
    }
    public static int findBottomLeftValue(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            root = q.poll();
            if(null != root.right) q.add(root.right);
            if(null != root.left) q.add(root.left);
        }
        return root.val;
    }
}

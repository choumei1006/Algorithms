package leetCode.DataStructures.Tree.Recurrence;

import org.junit.Test;
import publicClasses.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author:choumei
 * @date:2020/8/23 23:47
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
public class MinDepth_111 {
    @Test
    public void test(){
        TreeNode root = TreeNode.initTree(TreeNode.initTreeNodeList(new Integer[]{3, 9, 20, null, null, 15, 7}));
        System.out.println(minDepth2(root));
    }

    /**
     * 方法一：递归
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        //特判
        if (null == root) {
            return 0;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        //一边没有叶子节点
        if(leftDepth == 0 || rightDepth == 0){
            return leftDepth + rightDepth + 1;
        }

        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    /**
     * 方法二：BFS
     *
     * @param root
     */
    public int minDepth2(TreeNode root) {
        //特判
        if (null == root) {
            return 0;
        }

        //BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;

        while (!queue.isEmpty()) {
            int tmpSize = queue.size();
            for (int i = 0; i < tmpSize; i++) {
                TreeNode tmpNode = queue.poll();
                if(null == tmpNode.left && null == tmpNode.right){
                    return depth;
                }
                if(null != tmpNode.left){
                    queue.offer(tmpNode.left);
                }
                if(null != tmpNode.right){
                    queue.offer(tmpNode.right);
                }
            }
            depth ++;
        }
        return depth;
    }
}

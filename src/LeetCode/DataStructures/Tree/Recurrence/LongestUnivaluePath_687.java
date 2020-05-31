package LeetCode.DataStructures.Tree.Recurrence;

import PublicClasses.TreeNode;

/**
 * @author:choumei
 * @date:2019/12/25 19:18
 * @Description:
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。
 * 这条路径可以经过也可以不经过根节点。
 *
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 *
 * 示例 1:
 *
 * 输入:
 *
 *               5
 *              / \
 *             4   5
 *            / \   \
 *           1   1   5
 * 输出:
 *
 * 2
 * 示例 2:
 *
 * 输入:
 *
 *               1
 *              / \
 *             4   5
 *            / \   \
 *           4   4   5
 * 输出:
 *
 * 2
 * 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。
 *
 */
public class LongestUnivaluePath_687 {
    private static  int path = 0;
    public static void main(String[] args) {

        Integer[] list = {1,4,5,4,4,null,5};
        TreeNode tree = TreeNode.initTree(TreeNode.initTreeNodeList(list));
        System.out.println(longestUnivaluePath(tree));
    }

    /**
     * 返回最长相同节点值路径长度
     * @param root
     * @return
     */
    public static int longestUnivaluePath(TreeNode root){
        dfs(root);
        return path;
    }
    public static int dfs(TreeNode root){
        if(null == root) return 0;
        int tempLeft = dfs(root.left);
        int tempRight = dfs(root.right);

        //只扩展与根节点值相同的最长路径值
        int leftPath = (null != root.left && root.val == root.left.val) ? (tempLeft+1):0;
        int rightPath = (null != root.right && root.val == root.right.val) ? (tempRight+1) : 0;

        path = Math.max(path,leftPath+rightPath);
        return Math.max(leftPath,rightPath);
    }
}

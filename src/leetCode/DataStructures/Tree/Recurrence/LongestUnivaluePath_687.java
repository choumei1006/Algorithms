package leetCode.DataStructures.Tree.Recurrence;

import org.junit.Test;
import publicClasses.TreeNode;

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

    /**
     * 返回向上贡献的路径长度（根节点值）
     * @param root
     * @return
     */
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


    //++++++++++++++++++++++++++++++2020-08-13自测+++++++++++++++++++++++++++++++++++++++++++++++

    @Test
    public void test(){
        TreeNode node = TreeNode.initTree(TreeNode.initTreeNodeList(new Integer[]{1, 4, 5, 4, 4, null, 5}));
        System.out.println(longestUnivaluePath2(node));
    }

    /**
     * 返回树中具有相同节点值得最长路径长度
     * @param root
     * @return
     */
    private int maxLen = 0;
    public int longestUnivaluePath2(TreeNode root){
        dfs2(root);
        return maxLen;
    }

    /**
     * 深度优先遍历，期间记录当前根节点值在当前子树中对应的最长路径长度
     *
     * @param root
     */
    public int dfs2(TreeNode root) {
        //边界
        if (null == root) {
            return 0;
        }
        int tmpLeft = dfs2(root.left);
        int tmpRight = dfs2(root.right);

        int rstLeft = null != root.left && root.left.val == root.val ? tmpLeft + 1 : 0;
        int rstRight = null != root.right && root.right.val == root.val ? tmpRight + 1 : 0;

        maxLen =  Math.max(maxLen, rstLeft + rstRight);    //更新最长路径
        return Math.max(rstLeft, rstRight);    //向上传递最长的路径长度


    }

}

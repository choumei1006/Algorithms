package leetCode.DataStructures.Tree.Recurrence;

import org.junit.Test;
import publicClasses.TreeNode;

/**
 * @author:choumei
 * @date:2020/8/13 17:20
 * @Description: 给定一个非空二叉树，返回其最大路径和。
 *
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * 输出: 6
 * 示例?2:
 *
 * 输入: [-10,9,20,null,null,15,7]
 *
 * ?  -10
 * ? ?/ \
 * ? 9 ?20
 * ? ? / ?\
 * ? ?15 ? 7
 *
 * 输出: 42
 *
 */
public class MaxPathSum_124 {
    @Test
    public void test(){
//        TreeNode root = TreeNode.initTree(TreeNode.initTreeNodeList(new Integer[]{-10, 9, 20,null, null, 15,7}));
        TreeNode root = TreeNode.initTree(TreeNode.initTreeNodeList(new Integer[]{2, -1}));
        System.out.println(maxPathSum(root));
    }

    /**
     * 计算
     * @param root
     * @return
     */
    private int maxPath = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root){
        //特判
        if(null == root){
            return 0;
        }
        dfs(root);
        return maxPath;
    }

    /**
     * 深度优先遍历
     * （1）更新最大路径节点之和
     * （2）返回当前子树向上贡献的最大节点值之和
     *
     * @param root
     * @return
     */
    public int dfs(TreeNode root) {
        //特判
        if (null == root) {
            return 0;
        }

        int tmpLeftSum = Math.max(dfs(root.left), 0);    //左子树向当前根节点提供的 单边最长路径长度
        int tmpRightSum = Math.max(dfs(root.right), 0);     //右子树向当前根节点提供的  最长单边路径长度


        maxPath = Math.max(maxPath, tmpLeftSum + tmpRightSum + root.val);    //更新最长路径长度

        return Math.max(tmpLeftSum ,tmpRightSum) + root.val;
    }
}

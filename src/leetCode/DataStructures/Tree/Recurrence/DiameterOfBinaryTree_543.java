package leetCode.DataStructures.Tree.Recurrence;

import org.junit.Test;
import publicClasses.TreeNode;

/**
 * @author:choumei
 * @date:2019/12/17 8:05
 * @Description: 【二叉树的直径】
 * 给定一棵二叉树，你需要计算它的直径长度。
 * 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 *
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 *
 */
public class DiameterOfBinaryTree_543 {
    private static int maxPath = 0;

    public static void main(String[] args) {
        TreeNode l2_1 = new TreeNode(2);
        TreeNode l2_2 = new TreeNode(3);
        TreeNode l3_1 = new TreeNode(4);;
        TreeNode l3_2 = new TreeNode(5);

        TreeNode l1 = new TreeNode(1);
        l1.left = l2_1;
        l1.right = l2_2;
        l2_1.left = l3_1;
        l2_1.right = l3_2;

        System.out.println(diameterOfBinaryTree(l1));
    }
    public static int diameterOfBinaryTree(TreeNode root){
        maxDepth(root);
        return maxPath;
    }
    public static  int maxDepth(TreeNode root){
        if(null == root) return 0;
        int maxl = maxDepth(root.left);
        int maxr = maxDepth(root.right);
        maxPath = Math.max(maxPath,maxl+maxr);
        return Math.max(maxl,maxr)+1;
    }

    @Test
    public void test(){
        TreeNode root = TreeNode.initTree(TreeNode.initTreeNodeList(new Integer[]{1,2,3,4,5}));
        System.out.println(diameterOfBinaryTree2(root));
    }

    /**
     * 计算二叉树的直径:二叉树种任意两个节点之间的路径长度最大值
     *
     * @param root
     * @return
     */
    private int maxDiameter = 0;
    public int diameterOfBinaryTree2(TreeNode root) {
        //特判
        if (null == root) {
            return 0;
        }
        calDepthHelper(root);
        return maxDiameter;
    }

    /**
     * 计算子树向上层贡献的最长单边 /路径/ 长度，期间更新最长直径
     * @param root
     * @return
     */
    public int calDepthHelper(TreeNode root){
        //特判
        if(null == root){
            return 0;
        }
        //递归计算
        int dl = calDepthHelper(root.left);
        int dr = calDepthHelper(root.right);

        //更新最长直径
        maxDiameter = Math.max(maxDiameter, dl + dr);

        return Math.max(dl, dr) + 1;
    }
}

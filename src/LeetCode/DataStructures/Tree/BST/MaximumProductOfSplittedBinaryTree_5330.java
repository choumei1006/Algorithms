package LeetCode.DataStructures.Tree.BST;
import PublicClasses.TreeNode;
/**
 * @author:choumei
 * @date:2020/2/2 13:42
 * @Description: 给你一棵二叉树，它的根为 root 。请你删除 1 条边，使二叉树分裂成两棵子树，且它们子树和的乘积尽可能大。
 *
 * 由于答案可能会很大，请你将结果对 10^9 + 7 取模后再返回。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [1,2,3,4,5,6]
 * 输出：110
 * 解释：删除红色的边，得到 2 棵子树，和分别为 11 和 10 。它们的乘积是 110 （11*10）
 * 示例 2：
 *
 *
 *
 * 输入：root = [1,null,2,3,4,null,null,5,6]
 * 输出：90
 * 解释：移除红色的边，得到 2 棵子树，和分别是 15 和 6 。它们的乘积为 90 （15*6）
 * 示例 3：
 *
 * 输入：root = [2,3,9,10,7,8,6,5,4,11,1]
 * 输出：1025
 * 示例 4：
 *
 * 输入：root = [1,1]
 * 输出：1
 *
 *
 * 提示：
 *
 * 每棵树最多有 50000 个节点，且至少有 2 个节点。
 * 每个节点的值在 [1, 10000] 之间。
 *
 * [3434,4223,2441,6764,5911,7094,1827,9223,3580,6615,8446,2770,5112,718,3292,4092,3269,377,7407,4515,4512,6098,282,2197,9833,528
 */
public class MaximumProductOfSplittedBinaryTree_5330 {
    public static void main(String[] args) {
        /*System.out.println(Long.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println((long)(Math.pow(10,9)+7));*/
        TreeNode root = TreeNode.initTree(TreeNode.initTreeNodeList(new Integer[]{3434,4223,2441,6764,5911,7094,1827,9223,3580,6615,8446,2770,5112,718,3292,4092,3269,377,7407,4515,4512,6098,282,2197,9833,528}));
        System.out.println(maxProduct(root));
    }
    //定义tempProduct
    private static  long tempProduct = 0;
    public static  int maxProduct(TreeNode root) {

        //获取root的size
        long rootSize = subtreeSize(root);
        //遍历整棵树，更新tempProduct,以每一个节点为子树根节点

        //方法一：超时
        searchTree(root,rootSize);
        //方法二：精简
        dfs(root,rootSize);

        //返回tempProduct
        return (int)(tempProduct % 1000000007);

    }
    public static long dfs(TreeNode root,long rootSize){
        if(null == root){
            return 0;
        }
        long tempSize = root.val;
        tempSize += dfs(root.left,rootSize);
        tempSize += dfs(root.right,rootSize);

        tempProduct = Math.max(tempProduct,(tempSize*(rootSize-tempSize)));
        return tempSize;
    }

    public static void searchTree(TreeNode root,long rootSize){
        if(null == root){
            return;
        }
        long currSize = subtreeSize(root);
        tempProduct = Math.max(tempProduct,currSize*(rootSize-currSize));
        if(null != root.left){
            searchTree(root.left,rootSize);
        }
        if(null != root.right){
            searchTree(root.right,rootSize);
        }
    }

    /**
     * 获取子树节点值之和
     * @param root
     * @return
     */
    public static int subtreeSize(TreeNode root){
        if(root == null){
            return 0;
        }else{
            return root.val + subtreeSize(root.left)+subtreeSize(root.right);
        }
    }
}

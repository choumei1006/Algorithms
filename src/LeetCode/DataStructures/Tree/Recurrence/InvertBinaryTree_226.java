package LeetCode.DataStructures.Tree.Recurrence;

import PublicClasses.TreeNode;

/**
 * @author:choumei
 * @date:2019/12/18 18:36
 * @Description: 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * 备注:
 * 这个问题是受到 Max Howell 的 原问题 启发的 ：
 *
 * 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
 *`
 */
public class InvertBinaryTree_226 {
    public static void main(String[] args) {

        TreeNode l2_1 = new TreeNode(2);
        TreeNode l2_2 = new TreeNode(3);
        TreeNode l3_1 = new TreeNode(4);
        TreeNode l3_2 = new TreeNode(5);

        TreeNode l1 = new TreeNode(1);
        l1.left = l2_1;
        l1.right = l2_2;
        l2_1.left = l3_1;
        l2_1.right = l3_2;

        TreeNode invertRst = invertTree(l1);
        printTree(invertRst);
    }
    public static TreeNode invertTree(TreeNode root){
        if(null == root) return root;
        TreeNode invertLeft = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = invertLeft;
        return root;
    }
    public static void printTree(TreeNode root){
        if(null != root){
            System.out.println(root.val);
            printTree(root.left);
            printTree(root.right);
        }
    }


}

package leetCode.DataStructures.Tree.Recurrence;

import publicClasses.TreeNode;
import org.junit.Test;

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

    @Test
    public void test(){
        TreeNode root = TreeNode.initTree(TreeNode.initTreeNodeList(new Integer[]{4,2,7,1,3,6,9}));
        TreeNode.printTree(invertTree2(root));
    }

    /**
     * 左右翻转二叉树
     * @param root
     * @return
     */
    public TreeNode invertTree2(TreeNode root){
        if(null == root){
            return root;
        }
        TreeNode leftInvert = invertTree2(root.left);
        root.left = invertTree2(root.right);
        root.right = leftInvert;
        return root;
    }

    //=========================2020-08-22===============================

    /**
     * 反转二叉树【递归】
     *
     * @param root
     */
    public TreeNode invertTree3(TreeNode root) {
        //特判
        if (null == root || (null == root.left && null == root.right)) {
            return root;
        }
        //递归反转
        TreeNode ivtLeft = invertTree3(root.left);
        root.left = invertTree3(root.right);
        root.right = ivtLeft;

        return root;
    }


}

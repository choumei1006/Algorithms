package leetCode.DataStructures.Tree.OrderTraversal;

import publicClasses.TreeNode;
import org.junit.Test;

/**
 * @author:choumei
 * @date:2020/5/22 8:13
 * @Description:  【从前序遍历和中序遍历构造一棵二叉树】
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 */
public class ConstructTreeWithPreorderAndInorderTraversal_105 {
    @Test
    public void test(){
        TreeNode root = buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        TreeNode.printTree(root);
    }

    /**
     * 方法一：递归
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder){
        if(null == preorder || null == inorder){
            return null;
        }
        return buildHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    /**
     * 用前序遍历和中序遍历的某子序列构造子树，用于递归
     * @param preorder  前序遍历完整序列
     * @param preStart  前序遍历子序列起始索引
     * @param preEnd    前序遍历子序列结束索引
     * @param inorder   中序遍历完整序列
     * @param inStart   中序遍历子序列起始索引
     * @param inEnd     中序遍历子序列结束索引
     * @return
     */
    public TreeNode buildHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
        if(null == preorder || null == inorder || preStart > preEnd || inStart > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);   //二叉树根节点
        int tmpInEnd = inStart;
        while(inorder[tmpInEnd] != root.val){
            tmpInEnd ++;     //注意：此处最终会多加一次
        }
        int leftArrayLen = tmpInEnd - inStart ;   //(tmpInEnd - 1) - inStart + 1
        root.left = buildHelper(preorder, preStart + 1, preStart + leftArrayLen, inorder, inStart, tmpInEnd - 1);
        root.right = buildHelper(preorder, preStart + leftArrayLen + 1, preEnd, inorder, tmpInEnd + 1, inEnd);
        return root;
    }


    //=============================2020-08-13自测==========================
    @Test
    public void test2(){
        TreeNode root = buildTree2(new int[]{3,9,20,15,7}, new int[]{9, 3, 15, 20, 7});
        TreeNode.printTree(root);
    }

    /**
     * 根据前序遍历与中序遍历序列构造一棵二叉树
     *
     * @param preOrder 前序遍历
     * @param inOrder  中序遍历
     * @return
     */
    public TreeNode buildTree2(int[] preOrder, int[] inOrder) {
        //特判
        if (null == preOrder || null == inOrder) {
            return null;
        }
        return builderHelper(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
    }

    /**
     * 根据前序遍历、中序遍历 的 子序列构造子树
     * @param preOrder
     * @param preStart
     * @param preEnd
     * @param inOrder
     * @param inStart
     * @param inEnd
     * @return
     */
    public TreeNode builderHelper(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd){
        //特判
        if(null == preOrder || null == inOrder || preStart > preEnd ||  inStart > inEnd ){
            return null;
        }

        //以preStart节点值创建根节点
        TreeNode subRoot = new TreeNode(preOrder[preStart]);

        int leftEnd = inStart;    //记录左子树节点个数
        while(inOrder[leftEnd] != subRoot.val){
            leftEnd++;      //注意：此处最终多加一次
        }

        int preDistance = leftEnd - inStart;    //(leftEnd - 1) - instart + 1

        subRoot.left = builderHelper(preOrder, preStart + 1, preStart + preDistance, inOrder, inStart, inStart + preDistance - 1);
        subRoot.right = builderHelper(preOrder, preStart + preDistance + 1, preEnd, inOrder, inStart + preDistance + 1, inEnd);

        return subRoot;
    }
}

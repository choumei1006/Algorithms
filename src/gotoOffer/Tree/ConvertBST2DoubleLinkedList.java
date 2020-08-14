package gotoOffer.Tree;

import publicClasses.TreeNode;

import java.util.ArrayList;

/**
 * @author:choumei
 * @date:2020/2/20 13:10
 * @Description: 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class ConvertBST2DoubleLinkedList {
    public static void main(String[] args) {
        TreeNode root = TreeNode.initTree(TreeNode.initTreeNodeList(new Integer[]{6,4,8,2,5,7,9,1,3}));
        TreeNode rst = Convert(root);
    }
    public static TreeNode Convert(TreeNode pRootOfTree) {
        ArrayList<TreeNode> headTail = convertHelper(pRootOfTree);
        return headTail.get(0);
    }
    public static ArrayList<TreeNode>  convertHelper(TreeNode root){
        ArrayList<TreeNode> list = new ArrayList<>();
        TreeNode head = null;
        TreeNode tail = null;
        if(null == root || (null == root.left && null == root.right)){
            head  = root;
            tail = root;
        }else{
            ArrayList<TreeNode> cvtLeft = convertHelper(root.left);
            ArrayList<TreeNode> cvtRight = convertHelper(root.right);

            //判断左子树可能为空
            if(cvtLeft.get(1) != null){
                cvtLeft.get(1).right = root;
                root.left = cvtLeft.get(1);
                head = cvtLeft.get(0);
            }else{
                head = root;
            }
            //判断右子树可能为空
            if(cvtRight.get(0)!= null){
                cvtRight.get(0).left = root;
                root.right = cvtRight.get(0);
                tail = cvtRight.get(1);
            }else{
                tail = root;
            }
        }

        list.add(head);
        list.add(tail);
        return list;
    }
}

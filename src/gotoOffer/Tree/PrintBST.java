package gotoOffer.Tree;

import publicClasses.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author:choumei
 * @date:2020/2/19 13:14
 * @Description:
 */
public class PrintBST {
    public static void main(String[] args) {
        TreeNode tree = TreeNode.initTree(TreeNode.initTreeNodeList(new Integer[]{1,2,3,4,5,6,7}));
        System.out.println(PrintFromTopToBottom(tree));
    }
    public static  ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(null == root){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            list.add(temp.val);
            if(null != temp.left){
                queue.add(temp.left);
            }
            if(null != temp.right){
                queue.add(temp.right);
            }
        }
        return list;
    }
}

package PublicClasses;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author:choumei
 * @date:2019/12/15 16:33
 * @Description: Definition for a binary tree node.
 */
public class TreeNode {
    public Integer val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(Integer x){
        if(null == x) return;
        this.val = x;
    }

    /**
     * 生成一棵二叉树
     * @param list：组成二叉树的二叉树节点数组，按照欲求的二叉树结构层次排列
     * @return
     */
    public static TreeNode initTree(TreeNode[] list){
        if(null == list) return null;
        if(list.length <= 1) return list[0];
        int i = 0,j = 1;
        while(j+1<list.length){
            if(null != list[i]){
                list[i].left = list[j];
                list[i].right = list[j+1];
            }

            i++;
            j+=2;
        }
        if(j+1 == list.length){
            list[i].left = list[j];
        }
        return list[0];
    }

    /**
     * 生成二叉树节点数组
     * @param list：整型数组：按照欲求的二叉树结构层次排列
     * @return
     */
    public static TreeNode[] initTreeNodeList(Integer[] list){
        TreeNode[] nodeList = new TreeNode[list.length];
        for (int i = 0; i < list.length ; i++) {
            if(null == list[i]){
                nodeList[i] = null;
            }else {
                nodeList[i] = new TreeNode(list[i]);
            }
        }
        return nodeList;
    }

    /**
     * 层次遍历二叉树节点值
     * @param root
     */
    public static void printTree(TreeNode root){

        if(null == root) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            System.out.print(cur.val+"\t");
            if(null != cur.left) q.add(cur.left);
            if(null != cur.right) q.add(cur.right);
        }
    }
}

package gotoOffer.Tree;

import publicClasses.TreeNode;

import java.util.ArrayList;

/**
 * @author:choumei
 * @date:2020/2/19 16:59
 * @Description: 输入一颗二叉树的根节点和一个整数，
 * 打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class FindPathWithTargetSum {
    private static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public static void main(String[] args) {
        Integer[] list = {10,5,-3,3,2,null,11,3,-2,null,1};
        TreeNode tree = TreeNode.initTree(TreeNode.initTreeNodeList(list));
        System.out.println(FindPath(tree,18));
    }
    public static  ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<Integer> path = new ArrayList<>();
        findHelper(root,target,path);
        return list;
    }
    public static void findHelper(TreeNode root,int target,ArrayList<Integer> path){
        if(null == root){
            return;
        }
        path.add(root.val);
        if(null == root.left && null == root.right ){
            if(target == root.val){
                list.add(new ArrayList<Integer>(path));
            }
        }else{
            findHelper(root.left,target-root.val,path);
            findHelper(root.right,target-root.val,path);
        }
        path.remove(path.size()-1);
    }
}

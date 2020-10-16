package exam.WuBa.TreePrint_2;


import publicClasses.TreeNode;

import java.util.*;

/**
 * @author:choumei
 * @date:2020/9/14 20:31
 * @Description:
 */
public class TreePrint_2 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.initTree(TreeNode.initTreeNodeList(new Integer[]{1,2,3,4,5,6,7,8,9,10}));
        ArrayList<ArrayList<Integer>> res = printNode(root);
        for (ArrayList<Integer> r : res) {
            for(Integer i : r){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    /**
     *
     * @param node
     * @return
     */
    public static ArrayList<ArrayList<Integer>> printNode (TreeNode node) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(null != node){
            dfs(res, node, 0);
        }
        return res;
    }

    private static  void dfs(ArrayList<ArrayList<Integer>> res, TreeNode node, int level){
        if(res.size() - 1 < level){
            res.add(new ArrayList<>());
        }
        res.get(level).add(node.val);
        if(node.left != null){
            dfs(res, node.left, level + 1);
        }
        if(node.right != null){
            dfs(res, node.right, level + 1);
        }
    }


}
/*
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
}*/

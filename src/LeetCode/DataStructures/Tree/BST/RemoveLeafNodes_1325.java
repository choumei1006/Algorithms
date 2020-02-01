package LeetCode.DataStructures.Tree.BST;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author:choumei
 * @date:2020/2/1 12:09
 * @Description: 给你一棵以 root 为根的二叉树和一个整数 target ，请你删除所有值为 target 的 叶子节点 。
 *
 * 注意，一旦删除值为 target 的叶子节点，它的父节点就可能变成叶子节点；如果新叶子节点的值恰好也是 target ，那么这个节点也应该被删除。
 *
 * 也就是说，你需要重复此过程直到不能继续删除。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [1,2,3,2,null,2,4], target = 2
 * 输出：[1,null,3,null,4]
 * 解释：
 * 上面左边的图中，绿色节点为叶子节点，且它们的值与 target 相同（同为 2 ），它们会被删除，得到中间的图。
 * 有一个新的节点变成了叶子节点且它的值与 target 相同，所以将再次进行删除，从而得到最右边的图。
 * 示例 2：
 *
 *
 *
 * 输入：root = [1,3,3,3,2], target = 3
 * 输出：[1,3,null,null,2]
 * 示例 3：
 *
 *
 *
 * 输入：root = [1,2,null,2,null,2], target = 2
 * 输出：[1]
 * 解释：每一步都删除一个绿色的叶子节点（值为 2）。
 * 示例 4：
 *
 * 输入：root = [1,1,1], target = 1
 * 输出：[]
 * 示例 5：
 *
 * 输入：root = [1,2,3], target = 1
 * 输出：[1,2,3]
 *
 *
 * 提示：
 *
 * 1 <= target <= 1000
 * 每一棵树最多有 3000 个节点。
 * 每一个节点值的范围是 [1, 1000] 。
 *
 * * Definition for a binary tree node.
 *  * public class TreeNode {
 *  *     int val;
 *  *     TreeNode left;
 *  *     TreeNode right;
 *  *     TreeNode(int x) { val = x; }
 *  * }
 *
 */
public class RemoveLeafNodes_1325 {
    public static void main(String[] args) {
        Integer[] nodeList = {1,2,3,2,null,2,4};
        TreeNode root = TreeNode.initTree(TreeNode.initTreeNodeList(nodeList));
        TreeNode rst = removeLeafNodes(root,2);
        TreeNode.printTree(rst);
    }

    private static  boolean removeFlag = true;
    public static TreeNode removeLeafNodes(TreeNode root,int target){
        if(null == root) return root;
        //重复删除，直到某一次没有删除操作
        while(removeFlag){
            removeFlag = false;
            root = removeLeafHelper(root,target);
        }
        return root;
    }

    /**
     * 一次性删除val==target的叶子节点
     * @param root
     * @param target
     * @return
     */
    public static TreeNode removeLeafHelper(TreeNode root,int target){
        if(null == root) return root;
        if(null != root.left || null != root.right){
            root.left = removeLeafHelper(root.left,target);
            root.right = removeLeafHelper(root.right,target);
        }else{
            if(root.val == target){
                root = null;
                removeFlag = true;
            }
        }
        return root;
    }
}

class TreeNode {
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

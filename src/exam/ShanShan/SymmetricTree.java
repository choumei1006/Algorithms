package exam.ShanShan;

import java.util.Stack;

/**
 * @author:choumei
 * @date:2020/9/28 11:11
 * @Description: 镜像转换
 */
public class SymmetricTree {
    //镜像转换-方法一：递归
    public void mirror1(TreeNode root) {

        if(root==null)//递归的终点
            return;
        TreeNode tempNode=root.left;
        root.left=root.right;
        root.right=tempNode;
        mirror1(root.left);//递归左右子树
        mirror1(root.right);
    }

    //镜像转换-方法二：循环
    public void mirror2(TreeNode root) {
        if(root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode  parent = stack.pop();
            TreeNode temp = parent.left;
            parent.left = parent.right;
            parent.right = temp;
            if(parent.left!=null){
                stack.push(parent.left);
            }
            if(parent.right!=null){
                stack.push(parent.right);
            }
        }
    }
}
//自定义树节点类
class TreeNode {
    public Integer val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(Integer x){
        if(null == x) return;
        this.val = x;
    }
}

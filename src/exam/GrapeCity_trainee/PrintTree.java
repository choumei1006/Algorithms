package exam.GrapeCity_trainee;

import org.junit.Test;
import publicClasses.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author:choumei
 * @date:2020/8/15 10:15
 * @Description:  写一个函数，输出某二叉树的某一层元素
 */
public class PrintTree {
    @Test
    public void test(){
        TreeNode root = TreeNode.initTree(TreeNode.initTreeNodeList(new Integer[]{1, 2, 3, 4, 5, 6, 7}));
        print(root, 3);
    }

    public void print(TreeNode root, int n){
        //特判
        if(null == root){
            return;
        }
        //层次遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int depth = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean ifTargetLevel = depth == n;
            for (int i = 0; i < size; i++) {
                TreeNode tmpNode = queue.poll();
                if(null != tmpNode.left){
                    queue.offer(tmpNode.left);
                }
                if(null != tmpNode.right){
                    queue.offer(tmpNode.right);
                }
                //输出节点值
                if(ifTargetLevel){
                    System.out.print(tmpNode.val + "\t");
                }
            }
            depth++;
        }
    }
}

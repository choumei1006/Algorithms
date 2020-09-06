package exam.GrapeCity_trainee;

import org.junit.Test;
import publicClasses.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author:choumei
 * @date:2020/8/15 10:15
 * @Description:  дһ�����������ĳ��������ĳһ��Ԫ��
 */
public class PrintTree {
    @Test
    public void test(){
        TreeNode root = TreeNode.initTree(TreeNode.initTreeNodeList(new Integer[]{1, 2, 3, 4, 5, 6, 7}));
        print(root, 3);
    }

    public void print(TreeNode root, int n){
        //����
        if(null == root){
            return;
        }
        //��α���
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
                //����ڵ�ֵ
                if(ifTargetLevel){
                    System.out.print(tmpNode.val + "\t");
                }
            }
            depth++;
        }
    }
}

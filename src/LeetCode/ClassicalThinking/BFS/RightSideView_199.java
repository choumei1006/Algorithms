package LeetCode.ClassicalThinking.BFS;

import PublicClasses.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author:choumei
 * @date:2020/4/22 10:40
 * @Description: 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 */
public class RightSideView_199 {
    @Test
    public void test(){
        TreeNode root = TreeNode.initTree(TreeNode.initTreeNodeList(new Integer[]{1,2,3,null,5,null,4}));
        System.out.println(rightSideView(root).toString());
    }

    /**
     * BFS
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(null == root){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if(null != curNode.left){
                    queue.offer(curNode.left);
                }
                if(null != curNode.right){
                    queue.offer(curNode.right);
                }
                if(i == size - 1){
                    res.add(curNode.val);
                }
            }
        }
        return res;
    }

}

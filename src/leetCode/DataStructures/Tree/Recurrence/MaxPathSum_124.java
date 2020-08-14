package leetCode.DataStructures.Tree.Recurrence;

import org.junit.Test;
import publicClasses.TreeNode;

/**
 * @author:choumei
 * @date:2020/8/13 17:20
 * @Description: ����һ���ǿն����������������·���͡�
 *
 * �����У�·��������Ϊһ������������ڵ�������ﵽ����ڵ�����С���·�����ٰ���һ���ڵ㣬�Ҳ�һ���������ڵ㡣
 *
 * ʾ�� 1:
 *
 * ����: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * ���: 6
 * ʾ��?2:
 *
 * ����: [-10,9,20,null,null,15,7]
 *
 * ?  -10
 * ? ?/ \
 * ? 9 ?20
 * ? ? / ?\
 * ? ?15 ? 7
 *
 * ���: 42
 *
 */
public class MaxPathSum_124 {
    @Test
    public void test(){
//        TreeNode root = TreeNode.initTree(TreeNode.initTreeNodeList(new Integer[]{-10, 9, 20,null, null, 15,7}));
        TreeNode root = TreeNode.initTree(TreeNode.initTreeNodeList(new Integer[]{2, -1}));
        System.out.println(maxPathSum(root));
    }

    /**
     * ����
     * @param root
     * @return
     */
    private int maxPath = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root){
        //����
        if(null == root){
            return 0;
        }
        dfs(root);
        return maxPath;
    }

    /**
     * ������ȱ���
     * ��1���������·���ڵ�֮��
     * ��2�����ص�ǰ�������Ϲ��׵����ڵ�ֵ֮��
     *
     * @param root
     * @return
     */
    public int dfs(TreeNode root) {
        //����
        if (null == root) {
            return 0;
        }

        int tmpLeftSum = Math.max(dfs(root.left), 0);    //��������ǰ���ڵ��ṩ�� �����·������
        int tmpRightSum = Math.max(dfs(root.right), 0);     //��������ǰ���ڵ��ṩ��  �����·������


        maxPath = Math.max(maxPath, tmpLeftSum + tmpRightSum + root.val);    //�����·������

        return Math.max(tmpLeftSum ,tmpRightSum) + root.val;
    }
}

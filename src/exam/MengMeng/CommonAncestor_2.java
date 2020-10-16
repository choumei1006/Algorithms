package exam.MengMeng;


import java.util.Scanner;
import java.util.Stack;

/**
 * @author:choumei
 * @date:2020/9/16 19:55
 * @Description:
 */
public class CommonAncestor_2 {
    public static void main(String[] args) {
        //接收输入
        Scanner sc = new Scanner(System.in);
        String[] nodeStrArr = sc.nextLine().trim().split("\\s+");
        int len = nodeStrArr.length;
        int[] nodesVal = new int[len];   //节点值数组
        for (int i = 0; i < len; i++) {
            nodesVal[i] = Integer.parseInt(nodeStrArr[i]);
        }

        //构造树
        TreeNode root = TreeNode.initTreeNode(nodesVal);

        //病毒节点编号
        int val_1 = sc.nextInt();
        int val_2 = sc.nextInt();

        //在树中寻找病毒编号对应的节点
        TreeNode virus_1 = root.findSubTree(root, val_1);
        TreeNode virus_2 = root.findSubTree(root, val_2);


        TreeNode ancestor = lowestCommonAncestor(root, virus_1, virus_2);

        System.out.println(ancestor.val);

    }

    /**
     * 获取树中的两个节点的最近公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(null == root || root.val == p.val || root.val == q.val)
            return root;
        TreeNode leftRst = lowestCommonAncestor(root.left,p,q);
        TreeNode rightRst = lowestCommonAncestor(root.right,p,q);
        return null == leftRst ? rightRst : null == rightRst ? leftRst : root;
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
     * 根据节点值数组构建树
     *
     * @param nums
     * @return
     */
    public static TreeNode initTreeNode(int[] nums) {
        //用栈存储节点
        Stack<TreeNode> stack = new Stack<>();

        //根节点入堆
        TreeNode root = new TreeNode(nums[0]);
        stack.add(root);

        for (int i = 1; i < nums.length; i++) {
            TreeNode cur = /*nums[i] == -1 ? null : */new TreeNode(nums[i]);
            TreeNode peekNode = stack.peek();

            //链接父节点
            if(null == peekNode.left){
                peekNode.left = cur;
            } else if(null == peekNode.right){
                peekNode.right = cur;
            }

            //非叶子节点入栈
            if(-1 != nums[i]){
                stack.push(cur);
            }else{
                //左右节点不为空-出栈
                TreeNode peek = stack.peek();
                while(null != peek && null != peek.left  && null != peek.right){
                    stack.pop();
                    peek = stack.isEmpty() ? null : stack.peek();
                }
            }
        }

        return root;
    }

    /**
     * 根据节点值寻找树中的节点
     * @param val
     * @return
     */
    public static TreeNode findSubTree(TreeNode root, int val){
        //边界
        if(null == root){
            return null;
        }
        if(root.val == val){
            return root;
        }else {
            //递归寻找
            TreeNode leftRst = findSubTree(root.left, val);
            TreeNode rightRst = findSubTree(root.right, val);
            return null == leftRst ? rightRst : leftRst;
        }
    }
}
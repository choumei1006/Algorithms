package exam.JD.Autumn;

import publicClasses.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author:choumei
 * @date:2020/8/27 19:51
 * @Description:
 */
public class Tree235 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  //第n个

        //1、求树高
        int minHeight = (int) Math.ceil(Math.log(2 * (n + 1) + 1) / Math.log(3));

        //2、构建3叉树
        Tree3Node root = new Tree3Node(null, 0);
        Queue<Tree3Node> queue = new LinkedList<>();
        queue.offer(root);

        int height = 1;
        int idx = 0;
        Tree3Node target = null;
        while (height < minHeight) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Tree3Node tmpNode = queue.poll();
                Tree3Node tmp2 = new Tree3Node(tmpNode, 2);
                tmpNode.val2 = tmp2;
                idx++;
                if(idx == n){
                    target = tmp2;
                }
                queue.offer(tmp2);

                Tree3Node tmp3 = new Tree3Node(tmpNode, 3);
                tmpNode.val3 = tmp3;
                idx++;
                if(idx == n){
                    target = tmpNode.val3;
                }
                queue.offer(tmp3);

                Tree3Node tmp5 = new Tree3Node(tmpNode, 5);
                tmpNode.val5 = tmp5;
                idx++;
                if(idx == n){
                    target = tmpNode.val5;
                }
                queue.offer(tmp5);
            }
            height++;
        }

        //3、层次遍历查询第n个
        StringBuilder sb = new StringBuilder(target.val + "");
        if(null != target){
            Tree3Node flag = target;
            while(flag.parent.val != 0){
                sb.append(flag.parent.val);
                flag = flag.parent;
            }
        }

        //4、返回字符串代表的数字
        System.out.println(Integer.parseInt(sb.reverse().toString()));
    }
}

class Tree3Node {
    public Integer val;

    public Tree3Node parent;
    public Tree3Node val2;
    public Tree3Node val3;
    public Tree3Node val5;

    public Tree3Node(Tree3Node parent, Integer x) {
        if (null == x) return;
        this.parent = parent;
        this.val = x;
    }
}

package exam.YiSheng;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author:choumei
 * @date:2020/10/8 17:24
 * @Description: 寻找完全二叉树上两个节点的最近公共祖先节点
 */
public class CommonParent {
    public static void main(String[] args) {
        //接收输入x,y
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        int rst = getCommonParent(x,y);
        System.out.println(rst);

    }

    /**
     * 寻找完全二叉树中两个节点的最近公共祖先
     * @param x
     * @param y
     * @return
     */
    public static int getCommonParent(int x, int y){
        //特判
        if(x == y){
            return x;
        }

        int temp_x = x;
        int temp_y = y;

        //逐渐逼近公共节点
        while(temp_x != temp_y){
            if(temp_x > temp_y){
                temp_x = (int) Math.floor(temp_x / 2);
            }else{
                temp_y = (int) Math.floor(temp_y / 2);
            }
        }
        return temp_x;
    }
}

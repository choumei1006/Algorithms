package exam.Tencent.Autumn;

import java.util.Scanner;

/**
 * @author:choumei
 * @date:2020/9/6 8:19
 * @Description: 给一个长度为n的链表，挖掉第k个元素，问挖掉元素后的序列。
 */
public class DeleteKFromLinkedList_Test1 {
    public static void main(String[] args) {
        //接收输入
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  //链表长度
        int k = sc.nextInt();   //待删除元素
        sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            if(i != k - 1){
                sb.append(tmp + " ");
            }
        }
        System.out.println(sb.toString());
    }
}

package exam.Tencent.Autumn;

import publicClasses.ListNode;

import java.util.*;

/**
 * @author:choumei
 * @date:2020/9/6 20:20
 * @Description: 【链表的公共部分】
 * 小Q给你两个降序排序好的链表，小Q希望你能求出两个链表的公共部分。
 * 公共部分是指在两个链表中均出现过的子序列。
 * 注：需要子集处理输入输出，请根据题意自己定义，链表节点，相关函数。
 *
 * 输入描述：
 * 输入第一行为第一个链表的长度 n;
 * 第二行为第一个链表的每个节点值val;
 * 第三行为第二个链表的长度m;
 * 第四行为第二个链表的每个节点值val;
 * 1 <= n, m<= 1000000. -10^9 <= val <= 10^9;
 *
 * 【输出描述】：
 * 降序输出一行整数，表示两个升序链表的公共部分的值。
 *
 * 【实例1】：输入输出示例仅供调试，后台判题数据一般不包含示例。
 *
 * 输入：
 * 6
 * 6 5 4 3 2 1
 * 5
 *
 * 输出：
 * 6 5 3 2 1
 *
 */
public class LinkedList_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int len1 = in.nextInt();
        int[] arr1 = new int[len1];
        in.nextLine();
        String[] arrStr1 = in.nextLine().trim().split("\\s+");
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = Integer.parseInt(arrStr1[i]);
        }

        int len2 = in.nextInt();
        int[] arr2 = new int[len2];
        in.nextLine();
        String[] arrStr2 = in.nextLine().trim().split("\\s+");
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = Integer.parseInt(arrStr2[i]);
        }

        if(len1 <= 0 || len2 <= 0){
            return;
        }
        ListNode head1 = ListNode.initListByArray(arr1);
        ListNode head2 = ListNode.initListByArray(arr2);
        ListNode  rst = getCommonList(head1, head2);
        ListNode.printListNode(rst);
    }

    /**
     * 获取公共串
     *
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode getCommonList(ListNode head1, ListNode head2) {
        //特判
        if (null == head1 || null == head2) {
            return null;
        }

        ListNode newHead = new ListNode(-1);
        ListNode i = head1;
        ListNode j = head2;
        ListNode newIdx = newHead;


        while(null != i && null != j){
            if(i.val == j.val){
                newIdx.next = new ListNode(i.val);
                newIdx = newIdx.next;
                i = i.next;
                j = j.next;
            }else if(i.val > j.val){
                i = i.next;
            }else{
                j = j.next;
            }
        }
        return newHead.next;
    }


    static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x) {
            val = x;
            next = null;
        }

        /**
         * 初始化一个链表
         * @param array：整型数组
         * @return
         */
        public static ListNode initListByArray(int[] array){
            ListNode head = new ListNode(-1);
            ListNode idx = head;
            for (int i = 0; i < array.length ; i++) {
                ListNode cur = new ListNode(array[i]);
                idx.next = cur;
                idx = idx.next;
            }
            return head.next;
        }

        /**
         * 顺次输出链表所有节点值
         * @param head
         */
        public static void printListNode(ListNode head){
            while(null != head){
                System.out.print(head.val + " ");
                head = head.next;
            }
        }
    }


}



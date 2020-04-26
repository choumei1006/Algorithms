package LeetCode.DataStructures.LinkedList;

import PublicClasses.ListNode;

/**
 * @author:choumei
 * @date:2019/12/7 23:34
 * @Description: 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 */
public class MergeTwoSortedLists_21 {
    public static void main(String[] args) {
        ListNode l1_2 = new ListNode(3);
        ListNode l1_3 = new ListNode(5);
        ListNode l1_4 = new ListNode(7);
        ListNode l1_5 = new ListNode(9);

        ListNode l1 = new ListNode(1);
        l1.next = l1_2;
        l1_2.next = l1_3;
        l1_3.next = l1_4;
        l1_4.next = l1_5;

        ListNode l2_2 = new ListNode(4);
        ListNode l2_3 = new ListNode(6);
        ListNode l2_4 = new ListNode(8);
        ListNode l2_5 = new ListNode(10);

        ListNode l2 = new ListNode(2);
        l2.next = l2_2;
        l2_2.next = l2_3;
        l2_3.next = l2_4;
        l2_4.next = l2_5;


        ListNode rst = mergeTwoLists2(l1,l2);
        while(null != rst){
            System.out.println(rst.val);
            rst = rst.next;
        }
    }
    public static ListNode mergeTwoLists(ListNode l1,ListNode l2){
        ListNode newHead = new ListNode(-1);
        ListNode newIdx = newHead;
        ListNode i = l1,j = l2;
        while(null != i || null != j){
            if(null == i){
                newIdx.next = j ;
                j = j.next;
            }else if(null == j){
                newIdx.next = i ;
                i = i.next;
            }else if(i.val > j.val){
                newIdx.next = j ;
                j = j.next;
            }else{
                newIdx.next = i ;
                i = i.next;
            }

            newIdx = newIdx.next;
        }
        return newHead.next;

    }

    /**
     * 递归
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists2(ListNode l1,ListNode l2){
        if(l1 == null ) return l2;
        if(l2 == null ) return l1;
        if(l1.val <= l2.val){
            l1.next = mergeTwoLists2(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoLists2(l1,l2.next);
            return l2;
        }
    }
}

package LeetCode.DataStructures.LinkedList;

import PublicClasses.ListNode;

public class MiddleOfLinkedList_876 {
    public static void main(String[] args) {
        System.out.println(middleNode(ListNode.initListByArray(new int[]{1,2,3})).val);
    }
    public static ListNode middleNode(ListNode head) {
        int len = 0;
        if(null == head){
            return null;
        }
        ListNode cur = head;
        while(cur != null){
            len++;
            cur = cur.next;
        }
        int move = len/2;
        cur = head;
        while(move > 0){
            cur = cur.next;
            move--;
        }
        return cur;
    }
}

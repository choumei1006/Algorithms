package leetCode.DataStructures.LinkedList;

import publicClasses.ListNode;

/**
 * @author:choumei
 * @date:2020/3/24 23:40
 * @Description:
 * /**
 *  * Your Cashier object will be instantiated and called as such:
 *  * Cashier obj = new Cashier(n, discount, products, prices);
 *  * double param_1 = obj.getBill(product,amount);
 *
 */

public class MiddleOfLinkedList_876 {
    public static void main(String[] args) {
        System.out.println(middleNode2(ListNode.initListByArray(new int[]{1,2,3,4,5,9})).val);
    }

    /**
     * 方法一：两次遍历
     * @param head
     * @return
     */
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

    /**
     * 方法二：快慢指针
     * @param head
     * @return
     */
    public static ListNode middleNode2(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(null != fast && null != fast.next){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

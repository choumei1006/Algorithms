package exam.FuTu.Autumn;


/**
 * @author:choumei
 * @date:2020/9/18 10:18
 * @Description:
 */
public class ReverseList_1 {
    public static void main(String[] args) {
        ListNode head = ListNode.initListNode(new int[]{1,2,3,4,5});
        ListNode rst = reverse(head);
        System.out.println(rst.val);

    }

    /**
     * 反转
     * @param node
     * @return
     */
    public static ListNode reverse(ListNode node){
        //1、特判
        if(null == node){
            return null;
        }
        //2、递归
        ListNode curNext = node.next;
        ListNode nextReverse = reverse(curNext);
        curNext.next = node;
        node.next = null;
        //3、返回
        return nextReverse;
    }
}

/**
 * 自定单链表的节点类
 */
class ListNode{
     int val;
     ListNode next;

    public ListNode(int val){
        this.val = val;
        next = null;
    }

    /**
     * 构建链表
     * @param nums
     * @return
     */
    public static ListNode initListNode(int[] nums) {
        //特判
        if (null == nums || nums.length == 0) {
            return null;
        }

        ListNode head = new ListNode(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            ListNode curAdd = new ListNode(nums[i]);
            head.next = curAdd;
        }
        return head;
    }

}

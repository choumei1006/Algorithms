package PublicClasses;

/**
 * @author:choumei
 * @date:2020/2/19 19:10
 * @Description: 链表节点：random指向链表任意节点
 */
public class RandomListNode {
    public int label;
    public RandomListNode next = null;
    public RandomListNode random = null;

    public RandomListNode(int label) {
        this.label = label;
    }
}

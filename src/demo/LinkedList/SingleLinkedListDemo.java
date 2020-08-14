package demo.LinkedList;

/**
 * @author:choumei
 * @date:2020/2/6 23:18
 * @Description:
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addByOrder(new HeroNode(3,"sxm3","no3"));
        singleLinkedList.addByOrder(new HeroNode(1,"sxm1","no1"));
        singleLinkedList.addByOrder(new HeroNode(2,"sxm2","no2"));
        singleLinkedList.addByOrder(new HeroNode(4,"sxm4","no4"));
        singleLinkedList.show();

        HeroNode newNode = new HeroNode(2,"sxm22","no22");
        singleLinkedList.update(newNode);

        System.out.println("修改之后：");
        singleLinkedList.show();

        singleLinkedList.delete(2);

        System.out.println("删除后：");
        singleLinkedList.show();

        System.out.println("链表长度="+singleLinkedList.getLength());

        System.out.println("链表倒数第2个节点是："+singleLinkedList.getLastKNode(2));

        singleLinkedList.deleteLastKNode(2);

        System.out.println("删除倒数第2个节点之后的链表：");
        singleLinkedList.show();

        System.out.println("反转后的链表");
        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
        singleLinkedList2.add(singleLinkedList.reverse());
        singleLinkedList2.show();
    }
}

class SingleLinkedList{
    HeroNode head = new HeroNode(0,"","");
    //向单链表中添加节点（不考虑节点ID的顺序）
    public void add(HeroNode node){
        HeroNode flag = head;
        while(null != flag.next){
            flag = flag.next;
        }
        flag.next = node;
    }

    public void addByOrder(HeroNode node){
        HeroNode tempNode = head;
        while(null != tempNode.next && tempNode.next.no < node.no){
            tempNode = tempNode.next;
        }
        if(tempNode.no == node.no){
            System.out.println("该节点已经存在，无法添加！");
            return;
        }
        node.next = tempNode.next;
        tempNode.next = node;
    }

    public void update(HeroNode newNode){
        HeroNode tempNode = head.next;
        while(null != tempNode && tempNode.no != newNode.no){
            tempNode = tempNode.next;
        }
        if(null == tempNode){
            System.out.println("未找到对应的节点，无法修改！");
            return;
        }
        tempNode.name = newNode.name;
        tempNode.nickName = newNode.nickName;
    }

    /**
     * 删除节点
     * @param no
     */
    public void delete(int no){
        HeroNode temp = head;
        while(temp.next != null && temp.next.no != no){
            temp = temp.next;
        }
        if(null == temp.next){
            System.out.println("未找到待删除的节点，无法删除！");
            return;
        }
        temp.next = temp.next.next;
    }

    /**
     * 输出链表各个节点
     */
    public void show(){
        HeroNode flag = head;
        while(null != flag.next){
            System.out.println(flag.next.toString());
            flag = flag.next;
        }
    }

    /**
     * 获取链表长度；
     * @return
     */
    public int getLength(){
        HeroNode temp = head;
        int len = 0;
        while(null != temp.next){
            len++;
            temp = temp.next;
        }
        return len;
    }

    /**
     * 返回倒数第k个节点
     * @param k
     * @return
     */
    public HeroNode getLastKNode(int k){
        HeroNode i = head;
        HeroNode j = head;
        while (k > 0 && null != j.next){
            k--;
            j = j.next;
        }
        if( k > 0){
            System.out.printf("不存在倒数第%d个节点",k);
            return null;
        }
        while(j != null){
            i = i.next;
            j = j.next;
        }
        return i;
    }

    /**
     * 删除倒数第k个节点
     * @param k
     */
    public void deleteLastKNode(int k){
        HeroNode i = head;
        HeroNode j = head;
        while( k >= 0 && null != j.next){
            k--;
            j = j.next;
        }
        if(k >= 0){
            System.out.println("不存在倒数第k个节点，无法删除！");
            return;
        }
        while(j != null){
            i = i.next;
            j = j.next;
        }
        i.next = i.next.next;
    }

    /**
     * 反转链表
     */
    public HeroNode reverse(){
        HeroNode newHead = new HeroNode(0,"","");
        HeroNode idx = head.next;
        while(null != idx ){
            HeroNode tempNext = idx.next;

            idx.next = newHead.next;
            newHead.next = idx;


            idx = tempNext;
        }
        return newHead.next;
    }




}
class HeroNode{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no,String name,String nickName){
        this.no = no;
        this.name = name;
        this.nickName = nickName;
        this.nickName = nickName;
    }

    /**
     * 重写toString方法
     * @return
     */
    public String toString(){
        return "HeroNode[no="+no+",name="+name+",nickName="+nickName+"]";
    }

}

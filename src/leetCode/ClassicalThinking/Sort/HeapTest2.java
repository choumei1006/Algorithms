package leetCode.ClassicalThinking.Sort;

import java.util.Arrays;

/**
 * @author:choumei
 * @date:2020/9/6 17:02
 * @Description:  堆排序 -自测2
 */
public class HeapTest2 {
    public static void main(String[] args) {
        int[] tree = new int[]{20, 12, 19, 6, 10, 5, 7, 3};
        initHeap(tree, tree.length);
        heapSort(tree, tree.length);
        System.out.println(Arrays.toString(tree));

        //插入新数据
        int[] newTree = insert(tree, tree.length, 18);
        System.out.println(Arrays.toString(newTree));

    }

    /**
     * 堆排序【大顶堆】
     *
     * @param tree
     * @param n
     */
    public static int[] heapSort(int[] tree, int n) {
        //特判
        if (null == tree || tree.length == 0) {
            return new int[0];
        }
        //int[] rst = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            swap(tree, 0, i);
            //rst[n - 1 - i] = tree[i];
            heapify(tree, i, 0);   //缩小堆规模，重新调整0位置
        }
        return tree;

        /*//从最后一个父节点向上做 ‘上浮调整’
        int lastNode = n - 1;
        int lastParent = (lastNode - 1) / 2;
        for (int i = lastParent; i >= 0; i++) {

        }*/
    }

    public static void initHeap(int[] tree, int n){
        //特判
        if(null == tree || tree.length == 0){
            return;
        }

        //从最后一个父节点向上 逐个做‘上浮操作’
        int lastNode = n - 1;
        int lastParent = (lastNode - 1) / 2;

        for (int i = lastParent; i >= 0 ; i++) {
            heapify(tree, n, i);
        }
    }

    /**
     * 交换堆中i、j索引处元素
     * @param tree
     * @param i
     * @param j
     */
    public static void  swap(int[] tree, int i, int j){
        int temp = tree[i];
        tree[i] = tree[j];
        tree[j] = temp;
    }

    /**
     * 调整tree堆中，规模n内，i位置的父节点
     *
     * @param tree
     * @param n
     * @param i
     */
    public static void heapify(int[] tree, int n, int i) {
        //特判
        if (i >= n) {
            return;
        }
        //左右子节点
        int c1 = 2 * i + 1;
        int c2 = 2 * i + 2;

        //确定根左右中的最大索引
        int max = i;
        if(c1 < n && tree[c1] > tree[max]){
            max = c1;
        }
        if(c2 < n && tree[c2] > tree[max]){
            max = c2;
        }

        //需要交换调整
        if(max != i){
            swap(tree, i, max);
            heapify(tree, n, max);
        }
    }

    /**
     * 向大顶堆中插入数据
     * @param tree
     * @param n
     * @param value
     */
    public static int[] insert(int[] tree, int n, int value){
        //将旧数组复制到新数组
        int[] newTree = new int[n + 1];
        System.arraycopy(tree, 0, newTree, 0, n);
        newTree[n] = value;

        //调整新堆
        initHeap(newTree, n + 1);
        return newTree;
    }
}

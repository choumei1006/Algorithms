package exam.YiSheng;

/**
 * @author:choumei
 * @date:2020/10/8 16:56
 * @Description:  实现一个存放整数的“有序队列类”。
 * 要求实现：
 *  1：加入元素函数；
 *  2：查找元素函数（O(logN)）；
 */

public class SortedQueue  {
    private Integer[] values;// 数组
    private Integer currentSize;
    private int capacity = 0;// 数组容量

    public SortedQueue(int capacity) {
        values = new Integer[capacity];
        this.capacity = capacity;
    }

    //添加元素
    public Boolean enqueue(Integer value) {

        if(currentSize >= capacity){
            throw new IllegalArgumentException("数组长度越界！请实现扩容机制。");
        }
        values[currentSize] = value;
        currentSize ++;   //更新实际数组长度

        for (int i = 1; i < currentSize; i++) {
            int key = values[i];
            int idx = i;
            while(idx > 0 && values[idx-1] > key){
                values[idx] = values[idx-1];
                idx--;
            }
            values[idx] = key;
        }
        return true;
    }

    //查找元素-二分查找
    public Integer find(Integer key) {
        int low = 0;
        int high = values.length - 1;
        int middle = 0;			//定义middle

        if(key < values[low] || key > values[high] || low > high){
            return -1;
        }

        while(low <= high){
            middle = (low + high) / 2;
            if(values[middle] > key){
                //比关键字大则关键字在左区域
                high = middle - 1;
            }else if(values[middle] < key){
                //比关键字小则关键字在右区域
                low = middle + 1;
            }else{
                return middle;
            }
        }

        return -1;		//最后仍然没有找到，则返回-1
    }

}


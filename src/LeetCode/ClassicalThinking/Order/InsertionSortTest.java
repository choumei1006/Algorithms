package LeetCode.ClassicalThinking.Order;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author:choumei
 * @date:2020/3/21 18:26
 * @Description: 插入排序
 */
public class InsertionSortTest {
    @Test
    public void test(){
        int[] arr = new int[]{4,6,5,7,8,9,1,2,0,3};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public void insertionSort(int[] arr){
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            int key = arr[i];
            int idx = i;
            while(idx > 0 && arr[idx-1] > key){
                arr[idx] = arr[idx-1];
                idx--;
            }
            arr[idx] = key;
        }
    }
}

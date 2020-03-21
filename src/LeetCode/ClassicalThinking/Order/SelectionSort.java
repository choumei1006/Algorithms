package LeetCode.ClassicalThinking.Order;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author:choumei
 * @date:2020/3/21 18:04
 * @Description: 选择排序
 */
public class SelectionSort {

    @Test
    public void test(){
        int[] arr = new int[]{3,4,6,5,8,7,9,1,0};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void selectionSort(int[] arr){
        if(null == arr){
            return;
        }
        int len = arr.length;
        for (int i = len; i > 1; i--) {
            int maxPos = getMaxPos(arr,i);
            int temp = arr[maxPos];
            arr[maxPos] = arr[i-1];
            arr[i-1] = temp;
        }
    }

    /**
     * 获取数组arr中前n个元素中的最大值的下标
     * @param arr
     * @param n
     * @return
     */
    public int getMaxPos(int[] arr, int n){
        int maxPos = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i] > arr[maxPos]){
                maxPos = i;
            }
        }
        return maxPos;
    }
}

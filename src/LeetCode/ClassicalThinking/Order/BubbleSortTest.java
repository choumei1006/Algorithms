package LeetCode.ClassicalThinking.Order;

import java.util.Arrays;

/**
 * @author:choumei
 * @date:2020/3/20 21:40
 * @Description: 冒泡排序
 */
public class BubbleSortTest {
    public static void main(String[] args) {
        int[] arr = new int[]{4,6,8,7,5,9,1,3,2};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void bubbleSort(int[] arr){
        int len = arr.length;
        for (int i = len; i >= 1; i--) {
            for (int j = 0; j < i-1; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }


}

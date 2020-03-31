package LeetCode.ClassicalThinking.Sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author:choumei
 * @date:2020/3/31 23:39
 * @Description: 快速排序
 */
public class QuickSortTest {
    @Test
    public void test(){
        System.out.println(Arrays.toString(quickSort(new int[]{10,9,8,7,6,5,4,3,2,1,0})));
    }
    public int[] quickSort(int[] arr){
        if(null == arr){
            return null;
        }
        int len = arr.length;
        return quickHelper(arr,0,len-1);
    }
    public int[] quickHelper(int[] arr, int low, int high){
        int len = arr.length;
        if(low < high) {
            int beginPos = getPos(arr, low, high);
            quickHelper(arr, 0, beginPos - 1);
            quickHelper(arr, beginPos + 1, high);
        }
        return arr;
    }
    //获取特定区间中头元素的位置
    public int getPos(int[] arr, int low, int high){
        int key = arr[low];
        while(low < high){
            while(low < high && arr[high] >= key){
                high--;
            }
            arr[low] = arr[high];
            while(low < high && arr[low] <= key){
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = key;
        return low;
    }

}

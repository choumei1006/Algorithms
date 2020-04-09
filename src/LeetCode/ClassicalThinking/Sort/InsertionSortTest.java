package LeetCode.ClassicalThinking.Sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author:choumei
 * @date:2020/3/21 18:26
 * @Description:  插入排序 O(n^2)
 */
public class InsertionSortTest {
    @Test
    public void test(){
        int[] arr = new int[]{4,6,5,7,8,9,1,2,0,3};
        //insertionSort(arr);
        insertSort(arr);
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

    //自测
    public void insertSort(int[] nums){
        if(null == nums){
            return;
        }
        int len = nums.length;
        for(int i = 1; i < len; i++){
            int val = nums[i];
            int idx = i;
            while(idx > 0 && nums[idx-1] > val){
                nums[idx] = nums[idx-1];
                idx--;
            }
            if(idx == i) {
                nums[idx] = val;
            }
        }
    }
}

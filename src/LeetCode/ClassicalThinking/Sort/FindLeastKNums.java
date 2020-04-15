package LeetCode.ClassicalThinking.Sort;

import org.junit.Test;

/**
 * @author:choumei
 * @date:2020/4/15 18:35
 * @Description: 输入整数数组，找出其中最小的K个数。
 * 例如：
 * 输入：{4，5，1，6，2，7，3}   4
 * 输出：1，2，3，4
 */
public class FindLeastKNums {
    @Test
    public void test(){

    }
    public int[] getLeastKNums(int[] nums, int k){
        if(k < 1){
            return new int[]{0};
        }
        int len = nums.length;
        if(k == len){
            return nums;
        }
        //对原数组的前k个数字建堆
        int[] heap = new int[k];
        System.arraycopy(nums,0,heap,0,k);
        buildHeap(heap);

        for (int i = k; i < len; i++) {
            if(nums[i] < heap[0]){
                heap[0] = nums[i];
                heapify(heap,0);
            }
        }
        return heap;
    }

    /**
     * 构建大顶堆
     * @param nums
     */
    public void buildHeap(int[] nums){
        if(null == nums){
            return;
        }
        int len = nums.length;
        int lastNode = len - 1;
        int lastParent = (lastNode - 1) / 2;
        while(lastParent >= 0){
            heapify(nums, lastParent--);
        }
    }

    public void heapify(int[] nums, int idx){
        int len = nums.length;
        if(idx >= len){
            return;
        }
        int c1 = (idx << 1)+1;
        int c2 = (idx << 1)+2;
        int max = idx;
        if(c1 < len && nums[c1] > nums[idx]){
            max = c1;
        }
        if(c2 < len && nums[c2] > nums[idx]){
            max = c2;
        }
        if(max != idx){
            swap(nums,max,idx);
            heapify(nums,max);
        }
    }

    public void swap(int[] nums, int i, int j){
        nums[i] = nums[i] + nums[j] - (nums[j] = nums[i]);
    }
}

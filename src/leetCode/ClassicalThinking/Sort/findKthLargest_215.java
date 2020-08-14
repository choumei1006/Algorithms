package leetCode.ClassicalThinking.Sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author:choumei
 * @date:2020/4/9 15:27
 * @Description: 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 */
public class findKthLargest_215 {
    @Test
    public void test(){
        System.out.println(findKthLargest3(new int[]{3,2,3,1,2,4,5,5,6},4));
    }

    /**
     * 方法一：库函数排序 O（NlogN）
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest1(int[] nums, int k){
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    /**
     * 方法二：堆排序 O(NlogK)
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest2(int[] nums, int k){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int n : nums){
            queue.offer(n);
            if(queue.size() > k){
                queue.poll();
            }
        }
        return queue.peek();
    }

    /**
     * 方法三：快速排序 O(n)
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest3(int[] nums, int k){
        int len = nums.length;
        quickHelper(nums,0,len-1);
        return nums[len-k];
    }
    public void quickHelper(int[] nums, int low, int high){
        if(low < high){
            int beginPos = getBeginPos(nums,low,high);
            quickHelper(nums,0,beginPos-1);
            quickHelper(nums,beginPos+1,high);
        }
    }
    public int getBeginPos(int[] nums, int low, int high){
        int key = nums[low];
        while(low < high){
            while(low < high && nums[high] >= key){
                high--;
            }
            nums[low] = nums[high];
            while(low < high && nums[low] <= key){
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = key;
        return low;
    }
}

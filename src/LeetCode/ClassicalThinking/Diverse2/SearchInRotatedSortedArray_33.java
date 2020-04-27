package LeetCode.ClassicalThinking.Diverse2;

import org.junit.Test;

/**
 * @author:choumei
 * @date:2020/4/27 23:28
 * @Description: 搜索旋转排序数组
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 */
public class SearchInRotatedSortedArray_33 {
    @Test
    public void test(){
        System.out.println(search(new int[]{4,5,6,7,0,1,2},0));
    }

    /**
     * 二分查找
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target){
        if(null == nums || nums.length == 0){
            return -1;
        }
        int len = nums.length;
        int l = 0;
        int r = len - 1;
        while(l <= r){
            int mid = (l + r) / 2;
            if(nums[mid] == target){
                return mid;
            }
            //左半边有序
            if(nums[0] <= nums[mid]){
                if(nums[0] <= target && target <= nums[mid]){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }
            //右半边有序
            else{
                if(nums[mid] <= target && target <= nums[len - 1]){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}

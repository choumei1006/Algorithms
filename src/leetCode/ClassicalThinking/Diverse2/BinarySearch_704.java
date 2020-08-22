package leetCode.ClassicalThinking.Diverse2;

import org.junit.Test;

/**
 * @author:choumei
 * @date:2020/8/15 0:49
 * @Description: ���ֲ���
 */
public class BinarySearch_704 {
    @Test
    public void test(){

    }

    /**
     * ���ֲ���Ŀ��ֵ�������е�����
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        //����
        if (null == nums || nums.length == 0) {
            return -1;
        }
        //����
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }
        }
        return -1;
    }
}

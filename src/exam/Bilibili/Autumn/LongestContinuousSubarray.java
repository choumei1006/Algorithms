package exam.Bilibili.Autumn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author:choumei
 * @date:2020/9/4 19:53
 * @Description:
 */
public class LongestContinuousSubarray {
    public static void main(String[] args) {
        System.out.println(longestSubArray(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
    }



    /**
     * 计算数组中最长连续子串长度（可容忍K次将0变为1）
     * @param nums
     * @param K
     * @return
     */
    public static int longestSubArray(int[] nums, int K){
        //特判
        if(null == nums || nums.length == 0){
            return 0;
        }
        //遍历
        Queue<Integer> queue = new LinkedList<>();
        int zeroCnt = 0;
        int tmpCnt = 0;
        int maxLen = 0;
        int tmpLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                if(zeroCnt >= K){
                    int tmpLeft = queue.poll();
                    tmpLen -= tmpLeft;
                    maxLen = Math.max(maxLen, tmpLen);
                }
                queue.offer(tmpCnt);
                tmpLen += tmpCnt;
                maxLen = Math.max(maxLen, tmpLen);

                tmpCnt = 0;
                zeroCnt++;
            }else if(nums[i] == 1){
                tmpCnt ++;
            }
        }

        //判断结果
        return maxLen + (zeroCnt > K ? K : zeroCnt);
    }
}

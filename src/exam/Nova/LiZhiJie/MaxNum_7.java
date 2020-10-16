package exam.Nova.LiZhiJie;

import java.util.*;

/**
 * @author:choumei
 * @date:2020/9/11 14:41
 * @Description:
 */
public class MaxNum_7 {
    public static void main(String[] args) {

    }

    public int getMaxNum(Integer[] nums) {
        //1、特判
        if (null == nums || nums.length == 0){
            return 0;
        }
        //2、排序
        Arrays.sort(nums, (o1, o2) -> o2 - o1);  //逆序排序

        //3、
        Queue<Integer> set = new LinkedList<>();
        int idx = 0;
        while(set.size() < 3){
            while(set.contains(nums[idx++]));
            set.add(nums[idx]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(set.poll());
        }
        return Integer.parseInt(sb.toString());
    }
}

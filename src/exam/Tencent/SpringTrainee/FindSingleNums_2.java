package exam.Tencent.SpringTrainee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author:choumei
 * @date:2020/4/14 23:20
 * @Description:
 */
public class
FindSingleNums_2 {
    public static void main(String[] args) {
        List<Integer> rst = findSingleNums(new int[]{1,1,2,3});
        for(int num : rst){
            System.out.println(num);
        }
    }
    public static List<Integer> findSingleNums(int[] nums){
        if(null == nums || nums.length == 0){
            return null;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> rst = new ArrayList<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int key : map.keySet()){
            if(map.get(key) == 1){
                rst.add(key);
            }
        }
        return rst;
    }
}

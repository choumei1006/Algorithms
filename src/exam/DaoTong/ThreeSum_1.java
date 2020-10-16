package exam.DaoTong;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author:choumei
 * @date:2020/9/9 10:55
 * @Description:
 */
public class ThreeSum_1 {
    public static void main(String[] args) {
        //1、接收输入
        Scanner sc = new Scanner(System.in);
        String[] numsStr = sc.nextLine().trim().split("\\s+");
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < numsStr.length; i++) {
            nums.add(Integer.parseInt(numsStr[i]));
        }
        //2、寻找其中和为0的三元组集合
        Set<List<Integer>> rst = findHelper(nums);
        for(List<Integer> lst : rst){
            for(int i : lst){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    /**
     * 获取数组中和为0的三元组集合
     *
     * @param nums
     * @return
     */
    public static Set<List<Integer>> findHelper(List<Integer> nums) {
        Set<List<Integer>> result = new HashSet<>();
        //1、特判
        if (null == nums ||  nums.isEmpty() || nums.size() < 3) {
            return result;
        }


        //2、排序
        Collections.sort(nums);

        //3、双指针
        List<Integer> innerList;
        for (int i = 0; i < nums.size() - 2; i++) {
            int j = i + 1;
            int k = nums.size() - 1;

            //固定i,j、k左右夹逼
            while(j < k){
                if(nums.get(i) + nums.get(j) + nums.get(k) < 0){
                    j++;
                }else if(nums.get(i) + nums.get(j) + nums.get(k) > 0){
                    k--;
                }else{
                    innerList = new ArrayList<>();
                    innerList.add(nums.get(i));
                    innerList.add(nums.get(j));
                    innerList.add(nums.get(k));
                    result.add(innerList);

                    k--;
                }
            }
        }
        return result;
    }
}

package leetCode.ClassicalThinking.DoublePointer;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:choumei
 * @date:2020/4/18 13:35
 * @Description: 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 *  
 *
 *
 *
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 *  
 *
 * 示例：
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 *
 */
public class ContainerWithMostWater_11 {
    @Test
    public void test(){
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        /*List<String> list = new ArrayList<>();
        list.add("d");
        list.add("b");
        list.add("e");
        list.sort((o1,o2) -> o1.compareTo(o2));
        System.out.print(list.toString());

        System.out.print(",");

        List<String> list2 = new ArrayList<>();
        list2.add("d");
        list2.add("b");
        list2.add("e");
        list2.stream().sorted((o1,o2) -> o1.compareTo(o2));
        System.out.println(list2.toString());*/

    }
    public int maxArea(int[] height){
        if(null == height || height.length == 0){
            return 0;
        }
        int L = 0, R = height.length-1;
        int res = 0;
        int curArea = 0;
        while(L < R){
            curArea = Math.min(height[L],height[R]) * (R - L);
            res = Math.max(res,curArea);
            if(height[L] < height[R]){
                L++;
            }else{
                R--;
            }
        }
        return res;
    }
}

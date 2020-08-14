package leetCode.ClassicalThinking.Dp;

import org.junit.Test;

/**
 * @author:choumei
 * @date:2020/4/4 23:23
 * @Description: 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，
 * 计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，
 * 可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 */
public class TrapWater_42 {
    @Test
    public void test(){
        System.out.println(trap2(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    /**
     * 方法一：暴力法
     * @param height
     * @return
     */
    public int trap1(int[] height){
        if(null == height || height.length == 0){
            return 0;
        }
        int res = 0;
        int minMax = 0;

        //取区间中每个柱子左右两侧比自己高的最高柱子
        for (int i = 1; i < height.length-1 ; i++) {
            //左侧
            int maxLeft = 0;
            for(int j = 0; j < i; j++){
                if(height[j] > maxLeft){
                    maxLeft = height[j];
                }
            }
            //右侧
            int maxRight = 0;
            for(int j = i+1; j < height.length; j++){
                if(height[j] > maxRight){
                    maxRight = height[j];
                }
            }

            //取左右最高的最小值
            minMax = Math.min(maxLeft,maxRight);
            //保证比自己高
            res += minMax > height[i] ? minMax - height[i] : 0;
        }
        return res;
    }

    /**
     * 方法二：动态规划
     * 备注：将上述暴力解法中的左右最大值存储起来，避免重复执行
     * @param height
     * @return
     */
    public int trap2(int[] height){
        if(null == height || height.length == 0){
            return 0;
        }
        int res = 0;
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];

        for (int i = 1; i < height.length-1; i++) {
            maxLeft[i] = Math.max(maxLeft[i-1],height[i-1]);
        }

        for (int i = height.length-2; i >= 0 ; i--) {
            maxRight[i] = Math.max(maxRight[i+1],height[i+1]);
        }
        int maxMin = 0;
        for (int i = 1; i < height.length-1 ; i++) {
            maxMin = Math.min(maxLeft[i],maxRight[i]);
            res += maxMin > height[i] ? maxMin - height[i] : 0;
        }
        return res;
    }

    /**
     * 方法三：双指针
     * @param height
     * @return
     */
    public int trap3(int[] height){
        if(null == height || height.length == 0){
            return 0;
        }
        int leftPoint = 1;
        int rightPoint = height.length-2;
        return  0;
        //TODO

    }

}

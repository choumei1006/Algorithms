package leetCode.ClassicalThinking.Dp;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author:choumei
 * @date:2020/5/30 8:31
 * @Description: 【柱状图中的最大矩形面积】
 *
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 *  
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 *
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 *
 * 示例:
 *
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 *
 */
public class LargestRectangleInHistogram_84 {
    @Test
    public void test(){
        System.out.println(largestRectangleArea2(new int[]{2,0,2}));
    }

    /**
     * 方法一：暴力法
     * @param heights
     * @return
     */
    public int largestRectangleArea1(int[] heights){
        //特判
        if(null == heights || heights.length == 0){
            return 0;
        }
        int len = heights.length;
        int tmpMaxArea = 0;
        for (int i = 0; i < len; i++) {
            int maxWidth = 1;
            for (int j = i + 1; j < len; j++) {
                if(heights[j] < heights[i]){  //i处柱子比j处高，则以heights[i]为高的矩形终止
                    break;
                }else{      //i处柱子比j处低，则以heights[i]为高的矩形继续向右延申
                    maxWidth++;
                }
            }
            tmpMaxArea = Math.max(tmpMaxArea, heights[i] * maxWidth);    //更新最大面积
        }
        return tmpMaxArea;
    }

    /**
     * 方法二：辅助栈
     * @param heights
     * @return
     */
    public int largestRectangleArea2(int[] heights){
        //特判
        if(null == heights || heights.length == 0){
            return 0;
        }
        int len = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        //元素下标入栈
        for (int i = 0; i < len; i++) {
            while(!stack.isEmpty() && heights[i] < heights[stack.peekLast()]){
                int height = heights[stack.removeLast()];    //栈顶出栈
                //特殊情况：与当前元素相等的柱子
                if(!stack.isEmpty() && height == heights[stack.peekLast()]){
                    stack.removeLast();
                }
                int width;
                if(stack.isEmpty()){
                    width = i;
                }else{
                    width = i - stack.peekLast() - 1;  //注意：当前栈顶元素是height前一个柱子下标，需要 - 1
                }

                maxArea = Math.max(maxArea, width * height);   //更新最大面积
            }
            stack.addLast(i);
        }

        //最后剩余元素出栈
        while(!stack.isEmpty()){
            int height = heights[stack.removeLast()];   //栈顶元素出栈

            //连续相等元素入栈
            while(!stack.isEmpty() && height == heights[stack.peekLast()]){   //
                stack.removeLast();
            }

            //此时栈中的柱子高度均可延申到末尾,注意!!当前栈顶元素为
            int width;
            if(stack.isEmpty()){
                width = len;
            }else{
                width = len - stack.peekLast() - 1;
            }
            maxArea = Math.max(maxArea, height * width);  //更新最大面积
        }
        return maxArea;
    }
}

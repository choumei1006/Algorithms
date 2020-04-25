package LeetCode.ClassicalThinking.Recall;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:choumei
 * @date:2020/4/9 11:08
 * @Description: 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *  
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 */
public class GenerateParentheses_22 {
    @Test
    public void test(){
        List<String> res = generateParentheses(3);
        for(String s : res){
            System.out.println(s);
        }
    }

    /**
     * 方法一：回溯（DFS）
     * @param n
     * @return
     */
    public List<String>  generateParentheses(int n){
        List<String> res = new ArrayList<>();
        if(n < 1){
            return res;
        }
        generateHelper("",n,n,res);
        return res;
    }
    public void generateHelper(String curStr, int left, int right, List<String> res){
        if(left == 0 && right == 0){
            res.add(curStr);
            return;
        }
        //（（ ）））
        if(left > right){
            return;
        }
        if(left > 0){
            generateHelper(curStr+"(",left-1,right,res);
        }
        if(right > 0){
            generateHelper(curStr+")",left,right-1,res);
        }
    }
}

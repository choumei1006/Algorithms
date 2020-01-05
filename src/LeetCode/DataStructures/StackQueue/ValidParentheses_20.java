package LeetCode.DataStructures.StackQueue;

import java.util.Stack;

/**
 * @author:choumei
 * @date:2020/1/5 20:26
 * @Description: 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 */
public class ValidParentheses_20 {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }
    public static boolean isValid(String s){
         Stack<Character> stk = new Stack<>();
         for(char c : s.toCharArray()){
             if(c == '(' || c == '{' || c == '['){
                 stk.push(c);
             }else{
                 if(stk.isEmpty()) return false;
                 char tempChar = stk.pop();
                 boolean b1 = c == ')' && tempChar != '(';
                 boolean b2 = c == '}' && tempChar != '{';
                 boolean b3 = c == ']' && tempChar != '[';
                 if(b1 || b2 || b3)
                     return false;
             }
         }
         return stk.isEmpty();
    }
}

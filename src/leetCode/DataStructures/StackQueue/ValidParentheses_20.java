package leetCode.DataStructures.StackQueue;

import java.util.HashMap;
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
    public static  HashMap<Character,Character> map;
    public ValidParentheses_20() {
        map = new HashMap<Character, Character>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
    }

    public static void main(String[] args) {
        map = new HashMap<Character, Character>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        System.out.println(isValid2("()"));
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

    /**
     * 方法2
     * @param s
     * @return
     */
    public static boolean isValid2(String s){
         if(null == s || s.length() == 0){
             return true;
         }
         Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.get(c) != null){   //闭括号
                char tempPeek = stack.isEmpty() ? '#' : stack.pop() ;
                if(map.get(c) != tempPeek){
                    return false;
                }
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

}

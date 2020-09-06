package exam.GrapeCity_trainee;

import org.junit.Test;

import java.util.Stack;

/**
 * @author:choumei
 * @date:2020/8/15 10:00
 * @Description:  写一个函数，判断一个括号字符串是否合法
 */
public class ValidCharacter {
    @Test
    public void test(){
        System.out.println(valid("{()()}{(}"));
    }


    public boolean valid(String str) {
        //特判
        if (null == str || str.length() % 2 == 1) {
            return false;
        }
        //栈操作
        Stack<Character> stack = new Stack<>();
        int len = str.length();

        char[] arr = str.toCharArray();

        for (int i = 0; i < len; i++) {
            //栈空
            if (stack.isEmpty()) {
                stack.push(arr[i]);
            }
            //栈非空,栈顶元素与当前元素匹配
            else if(stack.peek() == '{' && arr[i] == '}' || stack.peek() == '(' && arr[i] == ')'){
                stack.pop();
            }
            //不匹配
            else{
                stack.push(arr[i]);
            }
        }
        return stack.isEmpty();
    }
}

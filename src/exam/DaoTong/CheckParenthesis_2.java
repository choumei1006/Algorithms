package exam.DaoTong;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author:choumei
 * @date:2020/9/9 10:41
 * @Description:
 */
public class CheckParenthesis_2 {
    public static void main(String[] args) {
        //1、接收输入
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();
        //2、判断字符串中的括号是否合法
        System.out.println(checkHelper(input));
    }

    /**
     * 判断字符串str中的括号是否合法
     * @param str
     * @return
     */
    public static boolean checkHelper(String str){
        //1、特判
        if(null == str || str.length() == 0){
            return false;
        }

        //2、利用栈空间判断str中的括号
        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray()){
            if(c == '{' || c == '[' || c == '('){
                stack.push(c);
            }else{
                switch (c){
                    case '}':
                        if(stack.peek() == '{'){
                            stack.pop();
                        }
                        break;
                    case ']':
                        if(stack.peek() == '['){
                            stack.pop();
                        }
                        break;
                    case ')':
                        if(stack.peek() == '('){
                            stack.pop();
                        }
                        break;
                    default:
                        break;
                }
            }
        }
        return stack.isEmpty();
    }
}

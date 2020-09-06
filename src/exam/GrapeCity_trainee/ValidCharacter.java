package exam.GrapeCity_trainee;

import org.junit.Test;

import java.util.Stack;

/**
 * @author:choumei
 * @date:2020/8/15 10:00
 * @Description:  дһ���������ж�һ�������ַ����Ƿ�Ϸ�
 */
public class ValidCharacter {
    @Test
    public void test(){
        System.out.println(valid("{()()}{(}"));
    }


    public boolean valid(String str) {
        //����
        if (null == str || str.length() % 2 == 1) {
            return false;
        }
        //ջ����
        Stack<Character> stack = new Stack<>();
        int len = str.length();

        char[] arr = str.toCharArray();

        for (int i = 0; i < len; i++) {
            //ջ��
            if (stack.isEmpty()) {
                stack.push(arr[i]);
            }
            //ջ�ǿ�,ջ��Ԫ���뵱ǰԪ��ƥ��
            else if(stack.peek() == '{' && arr[i] == '}' || stack.peek() == '(' && arr[i] == ')'){
                stack.pop();
            }
            //��ƥ��
            else{
                stack.push(arr[i]);
            }
        }
        return stack.isEmpty();
    }
}

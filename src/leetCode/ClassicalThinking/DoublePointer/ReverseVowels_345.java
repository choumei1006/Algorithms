package leetCode.ClassicalThinking.DoublePointer;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author:choumei
 * @date:2019/11/30 22:18
 * @Description: 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 * 示例 1:
 * 输入: "hello"
 * 输出: "holle"
 *
 * 示例 2:
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 说明:
 * 元音字母不包含字母"y"。
 *
 */
public class ReverseVowels_345 {
    private final static HashSet<Character> VowelsList = new HashSet<Character>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));
    }
    public static String reverseVowels(String s){

        int l=0,r=s.length()-1;
        char[] curList = new char[s.length()];
        while(l <= r){
            Character lChar = s.charAt(l);
            Character rChar = s.charAt(r);
            if(!VowelsList.contains(lChar)){
                curList[l++] = lChar;
            }
            else if(!VowelsList.contains(rChar)){
                curList[r--] = rChar;
            }
            else{
                curList[l++] = rChar;
                curList[r--] = lChar;
            }
        }
        return new String(curList);

    }
}

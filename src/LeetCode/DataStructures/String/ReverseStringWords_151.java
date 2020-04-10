package LeetCode.DataStructures.String;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author:choumei
 * @date:2020/4/10 9:53
 * @Description: 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 *
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 *
 * 说明：
 *
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 *
 * 进阶：
 *
 * 请选用 C 语言的用户尝试使用 O(1) 额外空间复杂度的原地解法。
 *
 */
public class ReverseStringWords_151 {
    @Test
    public void test(){
        System.out.println(reverseWords2("  hello world!    "));
    }

    /**
     * 方法一：两次反转 + 双指针
     * @param s
     * @return
     */
    public String reverseWords1(String s){
        if(null == s || s.isEmpty()){
            return s;
        }
        char[] arr = s.toCharArray();
        int len = s.length();
        int i = 0, j = 0;
        while(j < len){
            if(j == len || arr[j] == ' '){
                reverseArr(arr,i,j-1);
                i = j+1;
            }
            j++;
        }
        reverseArr(arr,0,len-1);
        return new String(arr);
    }
    public void reverseArr(char[] arr, int l, int r){
        if(null == arr || arr.length == 0){
            return;
        }
        while(l < r){
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }

    /**
     * 方法二：双指针
     * @param s
     * @return
     */
    public  String reverseWords2(String s){
        //s = s.trim();
        String[] arr = s.trim().split("\\s+");
        int i = 0, j = arr.length-1;
        while(i < j){
            String temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return String.join(" ",arr);
    }

    /**
     * 方法三：API
     * @param s
     * @return
     */
    public String reverseWords3(String s){
        System.out.println(s.length());
        s = s.trim();
        System.out.println(s.length());
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ",wordList);
    }
}

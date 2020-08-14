package leetCode.DataStructures.String;

import java.util.Arrays;

/**
 * @author:choumei
 * @date:2020/1/6 22:29
 * @Description: 将每个单词翻转，然后将整个字符串翻转。
     * s = "I am a student"
     * Return "student a am I"
 *
 */
public class ReverseStringWords {
    public static void main(String[] args) {
        String str = "I am a student";
        System.out.println(reverseStringWords2(str));
    }

    /**
     * 方法一：双指针
     * @param str
     * @return
     */
    public static String reverseStringWords1(String str){
        if(str.isEmpty()){
            return str;
        }
        String[] strs = str.split(" ");
        int i = 0, j = strs.length-1;
        while(i < j){
            String tempStr = strs[i];
            strs[i] = strs[j];
            strs[j] = tempStr;

            i++;
            j--;
        }
        return String.join(" ",strs);
    }

    /**
     * 方法二：每个单词逐字符翻转，最后整个字符数组大翻转
     * @param str
     * @return
     */
    public static String reverseStringWords2(String str){
        if(str.isEmpty()){
            return str;
        }
        int len = str.length();
        char[] arr = str.toCharArray();
        int start = 0, end = 0;
        while(end <= len){
            if(end == len || arr[end] == ' '){
                reverseArr(arr,start,end-1);
                start = end+1;
            }
            end++;
        }
        reverseArr(arr,0,len-1);
        return new String(arr);
    }

    public static void reverseArr(char[] arr,int start,int end){
        while(start < end){
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}


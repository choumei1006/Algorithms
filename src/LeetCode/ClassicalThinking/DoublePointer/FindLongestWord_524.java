package LeetCode.ClassicalThinking.DoublePointer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:choumei
 * @date:2019/12/4 23:24
 * @Description: 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
 *
 * 示例 1:
 * 输入:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * 输出:
 * "apple"
 *
 * 示例 2:
 * 输入:
 * s = "abpcplea", d = ["a","b","c"]
 * 输出:
 * "a"
 * 说明:
 * 所有输入的字符串只包含小写字母。
 * 字典的大小不会超过 1000。
 * 所有输入的字符串长度不会超过 1000。
 *
 */
public class FindLongestWord_524 {
    public static void main(String[] args) {
        List<String> d = new ArrayList<String>();
        d.add("ba");
        d.add("ab");
        d.add("a");
        d.add("b");
        System.out.println(find("bab",d));
    }
    public static String find(String s ,List<String> d){
        String longestString = "";
        for( String target : d){
            int LenL = longestString.length();
            int LenT = target.length();
            int comrst = longestString.compareTo(target);
            if(LenL > LenT  || LenL == LenT  && comrst < 0){  //注意：此处不应为!= 0 ，注意题意中，返回长度最长，在字典顺序中考前的单词；
                continue;
            }
            if(isSubStr(s,target)){
                longestString = target;
            }
        }
        return longestString;
    }

    public static boolean isSubStr(String s,String t){
        int i = 0,j = 0;
        while(i < s.length() && j < t.length()){
            if(s.charAt(i) == t.charAt(j)){
                j++;
            }
            i++;
        }
        return j == t.length();
    }

}

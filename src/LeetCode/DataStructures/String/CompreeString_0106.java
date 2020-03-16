package LeetCode.DataStructures.String;

import javax.swing.*;

/**
 * @author:choumei
 * @date:2020/3/16 23:09
 * @Description: 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 *
 * 示例1:
 *
 *  输入："aabcccccaaa"
 *  输出："a2b1c5a3"
 * 示例2:
 *
 *  输入："abbccd"
 *  输出："abbccd"
 *  解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 * 提示：
 *
 * 字符串长度在[0, 50000]范围内。
 *"aabcccccaa"
 */
public class CompreeString_0106 {
    public static void main(String[] args) {
        System.out.println(compressString("aabcccccaa"));
    }
    public static String compressString(String S) {
        if(null == S){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int oldLen = S.length();
        Character preChar = null;
        int preLen = 0;
        for (int i = 0; i < oldLen; i++) {
            Character currChar = S.charAt(i);
            if(null != preChar && !currChar.equals(preChar)){
                sb.append(preLen);
                preLen = 1;
                sb.append(currChar);
                preChar = currChar;
            }else if(currChar.equals(preChar)){
                preLen ++;
            }else{
                preLen = 1;
                sb.append(currChar);
                preChar = currChar;
            }
        }
        sb.append(preLen);
        return sb.length() < oldLen ? sb.toString() : S;
    }
}

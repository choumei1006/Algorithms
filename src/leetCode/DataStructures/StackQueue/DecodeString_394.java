package leetCode.DataStructures.StackQueue;

import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @author:choumei
 * @date:2020/5/28 8:58
 * @Description:  【字符串解码】
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 示例:
 *
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 *
 */
public class DecodeString_394 {
    @Test
    public void test(){
        System.out.println(decodeString("3[a]2[bc]"));
    }

    /**
     * 方法一：辅助栈
     * @param s
     * @return
     */
    int idx;    //字符串下标索引
    public String decodeString(String s){
        //特判
        if(null == s || s.length() == 0){
            return "";
        }
        idx = 0;   //从0开始遍历
        LinkedList<String> stackHelper = new LinkedList<>();   //辅助不定长数组作为栈
        int len = s.length();
        //遍历访问字符串所有字符，分类判断
        while(idx < len){
            Character curChar = s.charAt(idx);
            //访问到数字
            if(Character.isDigit(curChar)){
                //获取表示数字的字符串并入栈
                String digStr = getDigitalStr(s);
                stackHelper.addLast(digStr);
            }
            //访问到字母/'['
            else if(Character.isLetter(curChar) || curChar == '['){
                //直接入栈
                stackHelper.addLast(String.valueOf(curChar));
                idx++;
            }
            //访问到']'
            else{
                idx++;  //跳过当前访问的']'
                LinkedList<String> tmpMem = new LinkedList<>();   //存储临时出栈字符串（字符）

                while(! "[".equals(stackHelper.peekLast())){
                    tmpMem.addLast(stackHelper.removeLast());  //']'之前的字符出栈并入栈tmpMem
                }

                Collections.reverse(tmpMem);   //暂存字符串反转

                stackHelper.removeLast();   //'['出栈

                int repTime = Integer.parseInt(stackHelper.removeLast());  //暂存字符串重复次数

                StringBuffer sb = new StringBuffer();
                String obj = getStringFormList(tmpMem);
                while(repTime-- > 0){
                    sb.append(obj);
                }

                //暂存字符串入栈
                stackHelper.addLast(sb.toString());
            }
        }
        return getStringFormList(stackHelper);
    }

    /**
     * 获取s串中当前idx开头的数字字符串
     * @param s
     * @return
     */
    public String getDigitalStr(String s){
        StringBuffer sb = new StringBuffer();
        while(Character.isDigit(s.charAt(idx))){
            sb.append(s.charAt(idx++));
        }
        return sb.toString();
    }

    /**
     * 根据可变字符串数组获取拼接字符串
     * @param list
     * @return
     */
    public String getStringFormList(LinkedList<String> list){
        //特判
        if(null == list || list.size() == 0){
            return "";
        }
        StringBuffer sb = new StringBuffer();
        for(String s : list){
            sb.append(s);
        }
        return sb.toString();
    }
}

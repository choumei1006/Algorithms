package LeetCode.DataStructures.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author:choumei
 * @date:2020/1/31 22:59
 * @Description: 给你一个字符串 s。请你按照单词在 s 中的出现顺序将它们全部竖直返回。
 * 单词应该以字符串列表的形式返回，必要时用空格补位，但输出尾部的空格需要删除（不允许尾随空格）。
 * 每个单词只能放在一列上，每一列中也只能有一个单词。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "HOW ARE YOU"
 * 输出：["HAY","ORO","WEU"]
 * 解释：每个单词都应该竖直打印。
 *  "HAY"
 *  "ORO"
 *  "WEU"
 * 示例 2：
 *
 * 输入：s = "TO BE OR NOT TO BE"
 * 输出：["TBONTB","OEROOE","   T"]
 * 解释：题目允许使用空格补位，但不允许输出末尾出现空格。
 * "TBONTB"
 * "OEROOE"
 * "   T"
 * 示例 3：
 *
 * 输入：s = "CONTEST IS COMING"
 * 输出：["CIC","OSO","N M","T I","E N","S G","T"]
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 200
 * s 仅含大写英文字母。
 * 题目数据保证两个单词之间只有一个空格。
 *
 */
public class PrintWordsVertically_1324 {
    public static void main(String[] args) {
        System.out.println(printVertically("CONTEST IS COMING ").toString());
    }
    public  static List<String> printVertically(String s){
        //切分字符串->单词数组
        String[] words = s.split(" ");
        //获取最长单词长度
        int maxLen = 0;
        for(String tempWord : words){
            maxLen = Math.max(maxLen,tempWord.length());
        }
        //创建List<String>
        List<String> arrList = new ArrayList<>();
        //遍历单词数组，逐个单词插入二维数组的每一列
        for (int i = 0; i < maxLen ; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < words.length ; j++) {
                if(i > words[j].length()-1){
                    sb.append(" ");
                }else{
                    sb.append(words[j].charAt(i));
                }
            }
            arrList.add(removeSuffixSpaces(sb));
        }
        return  arrList;
    }

    /**
     * 删除末尾空格
     * @param str
     * @return
     */
    public static String removeSuffixSpaces(StringBuilder str){
        if(str.length() <= 0){
            return str.toString();
        }
        str = str.reverse();
        int beginIdx = -1;
        for (int i = 0; i < str.length() ; i++) {
            if(str.charAt(i) != ' '){
                beginIdx = i;
                break;
            }
        }
        String rst = new StringBuilder(str.substring(beginIdx)).reverse().toString();
        return rst;
    }

}

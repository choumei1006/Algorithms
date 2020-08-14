package leetCode.DataStructures.String;

import org.w3c.dom.ls.LSOutput;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author:choumei
 * @date:2020/1/12 21:04
 * @Description: 给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 示例 1:
 *
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 *
 * 输入: s = "paper", t = "title"
 * 输出: true
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 *
 */
public class IsomorphicString_205 {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("122344566788","011233455677"));
    }

    /**
     * 判断两个字符串是否是等同体
     * @param s
     * @param t
     * @return
     */
    public static boolean isIsomorphic(String s,String t){

        //方法一：
        /*String modeStr_s = getModeOfStr(s);
        String modeStr_t = getModeOfStr(t);
        return modeStr_s.equals(modeStr_t);*/

        //方法二：必须双向映射，如 sdf   ddd
        return isIsomorphicHelper(s,t) && isIsomorphicHelper(t,s);
    }

    /**
     * 方法一：将两个字符串映射为一个第三方字符模板，检验该模板是否相同
     * @param str
     * @return
     */
    public static String getModeOfStr(String str){
        HashMap<Character,Character> map = new HashMap<>();
        StringBuilder result = new StringBuilder();

        char[] charArr  = str.toCharArray();
        int index = 0;
        for(char tempChar : charArr){
            map.putIfAbsent(tempChar,(char)('A'+index++));
            result.append(map.get(tempChar));
        }
        return result.toString();
    }
    //repeat
    public static String getModeOfStr_repeat(String str){
        //创建HashMap存储（字符-模式字母）映射表
        HashMap<Character,Character> map = new HashMap<>();
        //创建StringBuilder模式串
        StringBuilder sb = new StringBuilder();
        //定义模式字符的index：模式串取'A'+index的Unicode值
        int index = 0;
        //循环字符串每个字符，插入或寻找模式字母，添加到模式串
        for(char tempChar : str.toCharArray()){
            map.putIfAbsent(tempChar,(char)('A'+index++));
            sb.append(map.get(tempChar));
        }
        return sb.toString();
    }

    /**
     * 方法二：互相映射
     * @param str1
     * @param str2
     * @return
     */
    public static boolean isIsomorphicHelper(String str1,String str2){
        HashMap<Character,Character> map = new HashMap<>();
        char[] charArr1 = str1.toCharArray();
        char[] charArr2 = str2.toCharArray();
        for(int i = 0; i < charArr1.length;i++){
            if(map.keySet().contains(charArr1[i])){
                if(map.get(charArr1[i]) != charArr2[i]){
                    return  false;
                }
            }else{
                map.put(charArr1[i],charArr2[i]);
            }
        }
        return true;
    }
    public static boolean isIsomorphicHelper_repeat(String str1,String str2){
        //创建str1和str2的映射HashMap
        HashMap<Character,Character> map = new HashMap<>();
        //循环遍历str1和str2的字符数组
        char[] charArr1 = str1.toCharArray();
        char[] charArr2 = str2.toCharArray();
        for(int i = 0 ;i < str1.length();i++){
            if (map.keySet().contains(charArr1[i])){
                if(map.get(charArr1[i]) != charArr2[i]){
                    return false;
                }
            }else{
                map.put(charArr1[i],charArr2[i]);
            }
        }
        return true;
    }
}

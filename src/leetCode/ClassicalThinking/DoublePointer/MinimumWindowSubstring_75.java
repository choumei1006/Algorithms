package leetCode.ClassicalThinking.DoublePointer;

import org.junit.Test;

import javax.swing.text.AttributeSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author:choumei
 * @date:2020/5/23 8:35
 * @Description: 【最小覆盖子串】
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
 *
 * 示例：
 *
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 *
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 *
 */
public class MinimumWindowSubstring_75 {
    @Test
    public void test(){
        System.out.println(minWindow2("a","a"));
    }


    Map<Character, Integer> ori = new HashMap<Character, Integer>();  //存储t串中【字符-个数】
    Map<Character, Integer> cnt = new HashMap<Character, Integer>(); //
    /**
     * 找到S中包含T的所有字符的子串
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        int tLen = t.length();   //目标串t长度

        //存放t串中字符及其个数
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }

        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, //包含目标串中所有字符的最小窗口大小
            ansL = -1,  //标记最小窗口左边界
            ansR = -1;   //最小窗口右边界
        int sLen = s.length();
        while (r < sLen) {
            ++r;

            if (r < sLen && ori.containsKey(s.charAt(r))) {  //当前字符包含于目标串中
                //当前窗口已存在的目标串中字符及其个数
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            //若当前窗口已包含目标串中的所有字符
            while (check() && l <= r) {
                if (r - l + 1 < len) {   //当前窗口大小 小于 最小窗口大小
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                //窗口左边界右移
                if (ori.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    /**
     * 判断当前窗口中是否已包含目标串中的所有字符
     * @return
     */
    public boolean check() {
        Iterator iter = ori.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }

    /**
     * 自测
     * @param s
     * @param t
     * @return
     */
    Map<Character, Integer> tMap = new HashMap<>();   //目标串中的字符-个数
    Map<Character, Integer> sMap = new HashMap<>();   //s串中包含的目标串中的字符-个数
    public String minWindow2(String s, String t){
        if(null == s || null == t){
            return "";
        }
        int tLen = t.length();
        //存放tMap
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int sLen = s.length();

        int resL = -1, resR = -1;   //结果窗口左右指针
        int resLen = Integer.MAX_VALUE;  //结果窗口大小
        int l = 0, r = -1;  //活动窗口左右指针

        while(r < sLen){
            ++r;   //右指针右移

            //若右指针当前字符存在于目标串
            if(r < sLen && tMap.containsKey(s.charAt(r))){
                sMap.put(s.charAt(r), sMap.getOrDefault(s.charAt(r), 0) + 1);
            }

            while(isContainsAll() && l <= r){   //!!!!!!注意！！！此处的<=
                //更新最小窗口大小及其边界
                if(r - l + 1 < resLen){
                    resLen = r - l + 1;
                    resL = l;
                    resR = l + resLen;
                }
                //窗口左边界右移
                if(tMap.containsKey(s.charAt(l))){
                    sMap.put(s.charAt(l), sMap.getOrDefault(s.charAt(l), 0) - 1);
                }

                ++l;
            }
        }
        return resL == -1 ? "" : s.substring(resL, resR);
    }

    /**
     * 判断s串当前窗口是否包含全部t串字符
     * @return
     */
    public boolean isContainsAll(){
        Iterator itor = tMap.entrySet().iterator();
        while(itor.hasNext()){
            Map.Entry entry = (Map.Entry) itor.next();
            Character k = (Character) entry.getKey();
            Integer v = (Integer) entry.getValue();
            if(sMap.getOrDefault(k, 0) < v){
                return false;
            }
        }
        return true;
    }
}

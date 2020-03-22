package LeetCode.ClassicalThinking.KMP;

import org.junit.Test;

/**
 * @author:choumei
 * @date:2020/3/22 19:42
 * @Description:  KMP算法
 */
public class KMPTest {
    @Test
    public void test(){
        search("asdfdsdfghjdfghyhn","dfgh");
    }
    public void search(String s, String p){
        //特判
        if(null == s || null == p ){
            return ;
        }
        //获取字符数组
        char[] sArray = s.toCharArray();
        char[] pArray = p.toCharArray();

        //获取next数组
        int[] next = buildNext(pArray);

        int i = 0;    //主串指针
        int j = 0;    //模式串指针

        while(i < s.length()){
            if(sArray[i] == pArray[j]){
                i++;
                j++;
            }else if(j != 0){
                j = next[j-1];
            }else{
                i++;
            }

            //判断是否找到目标串
            if(j == p.length()){
                System.out.println("找到子串位置："+(i - j));
                j = next[j-1];
            }
        }
    }

    public int[] buildNext(char[] pattern){
        //初始化结果
        int[] res = new int[pattern.length];

        int i = 1;   //当前所求位置下标
        int now = res[i-1];    //当前位置之前最长公共前后缀长度

        while(i < pattern.length){
            if(pattern[i] == pattern[now]){
                res[i] = ++now;
                i++;
            }else if(now != 0){
                now = res[now-1];
            }else{
                res[i] = now;   //0
                i++;
            }
        }
        return res;
    }
}

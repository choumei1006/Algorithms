package LeetCode.DataStructures.String;

import java.util.*;

/**
 * @author:choumei
 * @date:2020/1/31 11:32
 * @Description: 给你一个字符串 s，它仅由字母 'a' 和 'b' 组成。每一次删除操作都可以从 s 中删除一个回文 子序列。
 *
 * 返回删除给定字符串中所有字符（字符串为空）的最小删除次数。
 *
 * 「子序列」定义：如果一个字符串可以通过删除原字符串某些字符而不改变原字符顺序得到，那么这个字符串就是原字符串的一个子序列。
 *
 * 「回文」定义：如果一个字符串向后和向前读是一致的，那么这个字符串就是一个回文。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "ababa"
 * 输出：1
 * 解释：字符串本身就是回文序列，只需要删除一次。
 * 示例 2：
 *
 * 输入：s = "abb"
 * 输出：2
 * 解释："abb" -> "bb" -> "".
 * 先删除回文子序列 "a"，然后再删除 "bb"。
 * 示例 3：
 *
 * 输入：s = "baabb"
 * 输出：2
 * 解释："baabb" -> "b" -> "".
 * 先删除回文子序列 "baab"，然后再删除 "b"。
 * 示例 4：
 *
 * 输入：s = ""
 * 输出：0
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 1000
 * s 仅包含字母 'a'  和 'b'
 */
public class RemovePalindromicSubsequences_R {
    public static void main(String[] args) {
        System.out.println(removePalindromeSub("ababa"));
    }

    /**
     * 返回删除回文串的次数
     * @param s
     * @return
     */
    public static int removePalindromeSub(String s){
        //方法二：
        if(s.length() <= 0){
            return 0;
        }
        int headIdx = 0,tailIdx = s.length()-1;
        while(headIdx <= tailIdx){
            if(s.charAt(headIdx) != s.charAt(tailIdx)){
                return 2;
            }
            headIdx++;
            tailIdx--;
        }
        return 1;
        //方法一：
        /*if(s.length() <= 0 ){
            return 0;
        }
        int rmTimes = 0;
        //头尾相接顺次加入队列中
        Queue<Character> queue = new LinkedList<>();
        int headIdx = 0,tailIdx = s.length()-1;
        while(headIdx <= tailIdx){
            queue.add(s.charAt(headIdx));
            if(headIdx != tailIdx){
                queue.add(s.charAt(tailIdx));
            }
            headIdx++;
            tailIdx--;
        }
        Queue<Character> tempQueue = new LinkedList<>();
        //迭代出队列
        while(!queue.isEmpty()){
            //成对出队列
            while(!queue.isEmpty()){
                Character tempChar1 = queue.poll();
                while(!queue.isEmpty() &&  tempChar1 != null ){
                    Character tempChar2 = queue.poll();
                    if(tempChar1 == tempChar2){
                        tempChar1 = null;
                    }else{
                        tempQueue.add(tempChar2);
                    }
                }
            }
            //临时队列赋值给queue
            queue = tempQueue;
            rmTimes++;
        }
        return rmTimes;*/
    }

}

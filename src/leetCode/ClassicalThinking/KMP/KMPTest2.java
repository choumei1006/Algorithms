package leetCode.ClassicalThinking.KMP;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * @author:choumei
 * @date:2020/9/6 10:53
 * @Description: 自测 KMP算法
 */
public class KMPTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();   //母串
        String P = sc.next();   //模式串

        //获取匹配结果
        List<Integer> matchRst = match(S, P);
        //输出结果
        Iterator<Integer> iterator = matchRst.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    //1、查询方法
    public static List<Integer> match(String S, String P){
        List<Integer> rst = new ArrayList<>();
        int sLen = S.length();
        int pLen = P.length();
        //1、特判
        if(null == S || null == P){
            return rst;
        }
        //2、构建模式串的next数组
        int[] next = buildNext(P);

        //3、借助next数组向右匹配
        int si = 0, pi = 0;
        while(si < sLen){
            if(S.charAt(si) == P.charAt(pi)){
                si++;
                pi++;
            }else if(pi != 0){
                pi = next[pi - 1];
            }else{
                si++;
            }

            if(pi == pLen){
                rst.add(si - pLen);  //匹配位置
                pi = next[pi - 1];
            }
        }
        return rst;
    }



    /**
     * 2、构建next数组
     *
     * @param P
     * @return
     */
    public static int[] buildNext(String P) {
        //1、特判
        if (null == P || P.length() == 0) {
            return new int[0];
        }

        int len = P.length();
        //2、递推方式构建next数组
        int[] next = new int[len];
        next[0] = 0;
        int index = 1;
        int now = next[0];   //当前元素之前，最大的公共前后缀长度

        while(index < len){
            if(P.charAt(index) == P.charAt(now)){
                now++;
                next[index++] = now;
            }else if(now != 0){
                now = next[now - 1];  //缩小公共前后缀，继续判断，直到可以延长公共前后缀
            }else{
                next[index++] = now;
            }
        }
        return next;
    }
}

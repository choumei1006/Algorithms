package LeetCode.DataStructures.String;

/**
 * @author:choumei
 * @date:2020/1/6 21:51
 * @Description:  给定两个字符串 s1 和 s2，要求判定 s2 是否能够被 s1 做循环移位得到的字符串包含。
 *      * s1 = AABCD, s2 = CDAA
 *      *  Return : true
 *      * s1 进行循环移位的结果是 s1s1 的子字符串，因此只要判断 s2 是否是 s1s1 的子字符串即可。
 */
public class StrCirculateMovedContain {
    public static void main(String[] args) {
        String str1= "AACDa";
        String str2 = "CDA";
        System.out.println(isContain(str1,str2));
    }

    public static boolean isContain(String str1,String str2){
        String strExtend = str1+str1;
        return (strExtend.indexOf(str2)>0);
    }
}

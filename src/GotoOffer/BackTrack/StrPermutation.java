package GotoOffer.BackTrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;


/**
 * @author:choumei
 * @date:2020/2/20 16:57
 * @Description: 输入一个字符串, 按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class StrPermutation {
    //private static HashSet<String> set = new HashSet<>();
    private static ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println(Permutation("abcddd"));
    }
    public static ArrayList<String> Permutation(String str) {
        //ArrayList<String> list = new ArrayList<>();
        permHelper(str,0,str.length()-1);
        /*for(String tempStr : set){
            list.add(tempStr);
        }*/
        return list;
    }
    public static void permHelper(String str,int start,int end){
        if(start == end && !list.contains(str)){
            list.add(str);
        }else {
            //StringBuilder sb = new StringBuilder(str);
            for (int i = start; i <= end; i++) {
                String tempStr = swap(str, start, i);
                permHelper(tempStr, start + 1, end);
                //swap(sb, start, i);
            }
        }
    }

    /**
     * 将str串i,j位置元素互换，并将i之后的串按照字典顺序排序后返回
     * @param str
     * @param i
     * @param j
     * @return
     */
    public static String swap(String str,int i,int j){
        StringBuilder sb = new StringBuilder(str);
        char temp = str.charAt(i);
        sb.setCharAt(i,str.charAt(j));
        sb.setCharAt(j,temp);
        return strSort(sb,i+1,sb.length()-1);
    }

    /**
     * 将str串start->end区间按照字典顺序排序，返回新串
     * @param str
     * @param start
     * @param end
     * @return
     */
    public static String strSort(StringBuilder str,int start,int end){
        ArrayList<Character> tempArr = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            tempArr.add(str.charAt(i));
        }
        Collections.sort(tempArr);
        StringBuilder tempStr = new StringBuilder();
        for(char c : tempArr){
            tempStr.append(c);
        }
        return str.substring(0,start)+tempStr.toString();
    }
}

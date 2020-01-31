package LeetCode.DataStructures.String;

import org.w3c.dom.ls.LSOutput;

/**
 * @author:choumei
 * @date:2020/1/31 19:49
 * @Description: 给你一个仅由数字 6 和 9 组成的正整数 num。
 *
 * 你最多只能翻转一位数字，将 6 变成 9，或者把 9 变成 6 。
 *
 * 请返回你可以得到的最大数字。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：num = 9669
 * 输出：9969
 * 解释：
 * 改变第一位数字可以得到 6669 。
 * 改变第二位数字可以得到 9969 。
 * 改变第三位数字可以得到 9699 。
 * 改变第四位数字可以得到 9666 。
 * 其中最大的数字是 9969 。
 * 示例 2：
 *
 * 输入：num = 9996
 * 输出：9999
 * 解释：将最后一位从 6 变到 9，其结果 9999 是最大的数。
 * 示例 3：
 *
 * 输入：num = 9999
 * 输出：9999
 * 解释：无需改变就已经是最大的数字了。
 *  
 *
 * 提示：
 *
 * 1 <= num <= 10^4
 * num 每一位上的数字都是 6 或者 9 。
 *
 */
public class Maximum69Number_1323 {
    public static void main(String[] args) {
        System.out.println(maximum69Number4(666));
    }

    /**
     * 方法一：循环判断每一位
     * @param num
     * @return
     */
    public static int maximum69Number1(int num){
        int bit = (num+"").length();   //4
        //由高到低取整数的每一位
        for (int i = bit; i >= 1 ; i--) {    // 4,3,2,1
            //获取每一位数
            int bitNum = (num % (int)(Math.pow(10,i)))/(int)(Math.pow(10,i-1));
            if(bitNum < 9){
                     //      99                    *        100            + 9*     10                +               9
                return (num/(int)(Math.pow(10,i))) * (int)(Math.pow(10,i)) + 9*(int)(Math.pow(10,i-1)) + (num%((int)(Math.pow(10,i))))%((int)(Math.pow(10,i-1)));
                //return (num/(int)(Math.pow(10,i)))*(int)(Math.pow(10,i-1))+9*(int)(Math.pow(10,i-1))+(num % (int)(Math.pow(10,i-1)));
            }
        }
        return num;
    }

    /**
     * 方法二：比较大小
     * @param num
     * @return
     */
    public static int maximum69Number2(int num){
        int bit = (num+"").length();   //4
        /*int top = (int)Math.pow(10,bit);    //10000
        if(num >= top-10){    //9990
            return top-1;     //9999
        } */
        for (int i = 1; i < bit ; i++) {   //1,2,3
            int base = ((int)(Math.pow(10,bit-i))-1)*(int)(Math.pow(10,i));    //1:9990   2:9900   3:9000
            if(num > base){
                return base + 9*(int)(Math.pow(10,i-1)) + (num%(int)(Math.pow(10,i-1)));
            }
        }
        return 9*(int)(Math.pow(10,bit-1)) + (num % (int)(Math.pow(10,bit-1)));
    }

    /**
     * 方法三：java String内置的replaceFirst()
     * 缺点：耗时
     * @param num
     * @return
     */
    public static int maximum69Number3(int num){
        String s = Integer.toString(num);
        s = s.replaceFirst("6","9");
        return Integer.parseInt(s);
    }

    /**
     * 方法四：借助StringBuilder节省空间
     * @param num
     * @return
     */
    public static int maximum69Number4(int num){
        //StringBuilder sb = new StringBuilder(Integer.toString(num));
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        for (int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) == '6'){
                sb.setCharAt(i,'9');
                break;
            }
        }
        return Integer.parseInt(sb.toString());
    }
}

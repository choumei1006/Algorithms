package leetCode.ClassicalThinking;

import java.util.Arrays;

/**
 * @author:choumei
 * @date:2020/2/23 11:55
 * @Description: 给你一个整数数组 digits，你可以通过按任意顺序连接其中某些数字来形成 3 的倍数，
 * 请你返回所能得到的最大的 3 的倍数。
 *
 * 由于答案可能不在整数数据类型范围内，请以字符串形式返回答案。
 *
 * 如果无法得到答案，请返回一个空字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：digits = [8,1,9]
 * 输出："981"
 * 示例 2：
 *
 * 输入：digits = [8,6,7,1,0]
 * 输出："8760"
 * 示例 3：
 *
 * 输入：digits = [1]
 * 输出：""
 * 示例 4：
 *
 * 输入：digits = [0,0,0,0,0,0]
 * 输出："0"
 *
 *
 * 提示：
 *
 * 1 <= digits.length <= 10^4
 * 0 <= digits[i] <= 9
 * 返回的结果不应包含不必要的前导零。
 */
public class LargestMultipleOfThree_5172 {
    public static void main(String[] args) {
        System.out.println(largestMultipleOfThree(new int[]{8,6,7,1,0}));
    }
    public static  String largestMultipleOfThree(int[] digits) {
        int[] map = new int [10];
        Arrays.fill(map,0);
        for(int i=0;i<digits.length;i++){
            map[digits[i]]++;
        }

        int t = 0;
        for(int i=0;i<10;i++){
            t += map[i]*i;
        }
        if(t==0) return"0";

        int yu = t%3;
        int minus = 0;
        int index = 1000;

        int flag = 0;
        for(int i=1;i<10;i++){
            for(int j = 0;j<=map[i];j++){
                if((yu -i*j)%3 == 0){

                    if(j<index){
                        minus = i;
                        index = j;
                    }
                    break;
                }
            }
        }

        if(yu!=0 && (minus*index)==0) return "";
        map[minus]-=index;

        StringBuffer sb =new StringBuffer();
        for(int i=9;i>=0;i--){
            for(int j=0;j<map[i];j++){
                sb.append(String.valueOf(i));
            }
        }
        return sb.toString();


    }
}

package exam.Autumn_360;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author:choumei
 * @date:2020/9/11 19:49
 * @Description:
 * 验证密码复杂性
 * 时间限制： 3000MS
 * 内存限制： 786432KB
 * 题目描述：
 * 验证密码复杂性是网站在用户输入初始密码后需要进行的一步操作。现在，小A的网站需要验证密码的复杂性，小A对一个足够复杂的密码拥有如下要求：
 *
 * 1.要有数字
 *
 * 2.要有大写字母
 *
 * 3.要有小写字母
 *
 * 4.要有特殊字符
 *
 * 5.长度不得小于8
 *
 * 现在给你密码，请你判断这个密码是否足够复杂
 *
 *
 *
 * 输入描述
 * 输入包含多组数据，对于每组数据，包含一个字符串S。
 *
 * 输出描述
 * 如果密码足够复杂，输出Ok，否则输出Irregular password。请注意输出的大小写。
 *
 *
 * 样例输入
 * 12_Aaqq12
 * Password123
 * PASSWORD_123
 * PaSS^word
 * 12_Aaqq
 * 样例输出
 * Ok
 * Irregular password
 * Irregular password
 * Irregular password
 * Irregular password
 *
 * 提示
 * 范围：|s|<=100，数据组数不会超过20
 * 样例解释：第二组密码没有特殊字符，第三组密码没有小写字母，第四组密码没有数字，第五组密码长度不够
 */
public class ValidPassword_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> pwds = new ArrayList<>();  //存放字符串

        while(true){
            String input = sc.nextLine().trim();
            pwds.add(input);
            System.out.println(isValid(input) ? "Ok" : "Irregular password");
        }

    }

    /**
     * 监测密码是否符合规范
     *
     * @param str
     * @return
     */
    public static boolean isValid(String str) {
        //特判
        if (null == str || str.length() < 8) {
            return false;
        }

        //判断类型
        int numType = 0;    //数字
        int charType = 0;   //特殊字符
        int upperType = 0;   //大写字母
        int lowerType = 0;   //小写字母


        //统计各个类型个数
        for (int i = 0; i < str.length(); i++) {
            char c  = str.charAt(i);
            if(c >= '0' && c <= '9'){
                numType++;
            }else if(c >= 'A' && c <= 'Z'){
                upperType++;
            }else if(c >= 'a' && c <= 'z'){
                lowerType++;
            }else{
                charType++;
            }
        }
        return numType > 0 && charType > 0 &&  upperType > 0 &&  lowerType > 0;
    }
}

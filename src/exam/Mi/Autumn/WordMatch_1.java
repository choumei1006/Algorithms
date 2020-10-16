package exam.Mi.Autumn;

import java.util.*;

/**
 * @author:choumei
 * @date:2020/9/8 18:28
 * @Description:
 * 密码生成器
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 注册网站时，需要使用包含不同类型（数字、符号、大写字母、小写字母）的字符，和特定长度。
 * 检查一个密码内容同时包含以上 4 种类型的字符，并且长度在8-120 个字符之间。
 * 符合要求，返回 0；长度不符合返回 1；类型不符合要求返还 2。
 *
 * 可以一次输入多组密码，以空格符间隔，空格符不作为密码。
 *
 *
 *
 * 输入描述
 * 需要验证的密码，多个密码以空格符间隔，空格符不作为密码的一部分
 *
 * 输出描述
 * 每个密码的检查结果，每个结果需要换行输出
 *
 *
 * 样例输入
 * 123 12345678 123abcABC!!!
 * 样例输出
 * 1
 * 2
 * 0
 */
public class WordMatch_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> pwds = new ArrayList<>();  //存放字符串
        List<Integer> rst = new ArrayList<>();  //存放检测结果

        String input = sc.nextLine().trim();
        String[] pwdsStr = input.split("\\s+");

        //循环接收输入
        for(int i = 0; i < pwdsStr.length; i++){
            String pwd = pwdsStr[i];   //接收字符串
            pwds.add(pwd);
            rst.add(isValid(pwd));
        }
        for(int b : rst) {
            System.out.println(b);
        }
    }

    /**
     * 监测密码是否符合规范
     *
     * @param str
     * @return
     */
    public static int isValid(String str) {
        //特判
        if (null == str || str.length() == 0) {
            return 1;
        }

        //判断长度
        if(str.length() < 8 || str.length() > 120){
            return 1;
        }
        //判断类型
        int numType = 0;
        int charType = 0;
        int upperType = 0;
        int lowerType = 0;


        //正则判断
        for (int i = 0; i < str.length(); i++) {
            char c  = str.charAt(i);
            if(c >= '0' && c <= '9'){
                numType++;
            }else if(c >= 'A' && c < 'Z'){
                upperType++;
            }else if(c >= 'a' && c < 'z'){
                lowerType++;
            }else{
                charType++;
            }
        }
        return numType > 0 && charType > 0 &&  upperType > 0 &&  lowerType > 0  ? 0 : 2;
    }

}

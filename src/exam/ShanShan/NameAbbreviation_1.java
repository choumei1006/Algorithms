package exam.ShanShan;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author:choumei
 * @date:2020/9/10 16:49
 * @Description: 【拼音首字母拼接】
 * 某公司IT系统取名规则如下，输入员工的中文拼音（拼音空格隔开），取员工的名字首字母拼接并转换为小写；
 * 如果员工的姓名是少于三个字，那么取所有拼音拼接并全部小写；
 * 如果员工姓名输入有误（非大小写字母），输出“unkown name”
 *
 * 输入描述：
 * 输入一行：员工姓名拼音（空格间隔）
 * 输出描述：
 * 输出一行：一个
 *
 * 示例1：
 * 输入：
 *     shou Jie LUN
 * 输出：
 *     zjl
 *
 */
public class NameAbbreviation_1 {
    public static void main(String[] args) {
        //1、接收输入
        Scanner sc = new Scanner(System.in);
        String namesStr = sc.nextLine().trim();

        //2、合法性判断
        if(null == namesStr || namesStr.length() == 0  ){
            System.out.println(namesStr);   //所有拼音
            return;
        }

        //3、获取首字母拼接结果
        String abbRst = abbHelper(namesStr);
        System.out.println(abbRst);
    }

    /**
     * 获取拼音名的缩写
     * @param namesStr
     * @return
     */
    public static String abbHelper(String namesStr){
        String strWithoutSpace = namesStr.replaceAll(" ", "");
        String[] nameArr = namesStr.split("\\s+");
        //1、特判
        if(null == namesStr || namesStr.length() == 0){
            return "";
        }
        //2、字母合法性判断
        Pattern p = Pattern.compile("^[A-Za-z]+$");
        Matcher m = p.matcher(strWithoutSpace);
        if(!m.matches()){
            return "unkown name";    //所有拼音
        }
        //3、长度判断
        /*if(strWithoutSpace.length() < 3){
            return strWithoutSpace;
        }*/
        if(nameArr.length < 3){
            return strWithoutSpace;
        }

        //4、首字母拼接
        StringBuilder rst = new StringBuilder();
        for (int i = 0; i < nameArr.length; i++) {
            rst.append(nameArr[i].charAt(0));
        }

        return rst.toString().toLowerCase();   //转小写
    }
}

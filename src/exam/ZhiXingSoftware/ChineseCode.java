package exam.ZhiXingSoftware;

import org.junit.Test;

import java.util.Scanner;

/**
 * @author:choumei
 * @date:2020/8/31 2:51
 * @Description:
 */
public class ChineseCode {

    static String[] chineseNum = {"一", "二", "三", "四", "五", "六", "七", "八", "九", "十"};
    static String[] shi = {"", "十", "百", "千"};
    static String[] wan = {"", "万", "亿", "万", "亿"};

    @Test
    public void test(){
        Scanner sc = new Scanner(System.in);
        //循环接收输入
        while(sc.hasNext()){
            String input = sc.nextLine().trim();
            String rst = transIntegerToChinese(input);
            System.out.println(rst);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //循环接收输入
        while(sc.hasNext()){
            String input = sc.nextLine().trim();
            String rst = transIntegerToChinese(input);
            System.out.println(rst);
        }
    }

    /**
     * 将整数转换为中文读法
     *
     * @param input
     * @return
     */
    public  static String transIntegerToChinese(String input) {
        //特判
        if ("0".equals(input)) {
            return "零";
        }

        StringBuilder sb = new StringBuilder();
        int len = input.length();
        int wanCnt = 0;    //已访问的万的个数
        int idx = len - 1;   //右边界索引

        //每四位一处理
        while(idx >= 0 && idx - 3 >= 0){
            String chinese4Str = trans4NumToChinese(input.substring(idx - 3, idx + 1));
            //int str4Len = chinese4Str.length();

            //不为零：加“万”级别的后缀
            if(!"零".equals(chinese4Str)){
                //去除末尾的零
                /*if(chinese4Str.substring(str4Len - 1, str4Len).equals("零")){
                    chinese4Str = chinese4Str.substring(0, str4Len - 1);
                }*/
                sb.insert(0, wan[wanCnt]);
                sb.insert(0, chinese4Str);
            }

            wanCnt++;
            idx = idx - 4;
        }

        //剩余不满四位
        if(idx != -1){
            String chinese4Str = trans4NumToChinese(input.substring(0, idx + 1));
            int str4Len = chinese4Str.length();

            if(!"零".equals(chinese4Str)){
                //去除末尾的零
                /*if(chinese4Str.substring(str4Len - 1, str4Len).equals("零")){
                    chinese4Str = chinese4Str.substring(0, str4Len - 1);
                }*/
                sb.insert(0, wan[wanCnt]);
                sb.insert(0, chinese4Str);
            }

        }
        return sb.toString();
    }

    /**
     * 四位内转换
     * 注意： 0010 ：十
     *       1001：一千零一
     *       1100:一千一百
     * @param input4
     * @return
     */
    public static String trans4NumToChinese(String input4){
        StringBuilder sb = new StringBuilder();
        int temp = Integer.parseInt(input4);
        if(temp == 0){
            return "零";
        }

        boolean zero = false;
        int index = 0;
        int nextNum = -1;
        //大于两位数
        while(temp / 10 != 0){
            int lastNum = temp % 10;

            //==0
            if(lastNum == 0){
                //还未遇到过0， 不是最后一位：零（注意：特例1100）
                if(!zero && index != 0 && nextNum != 0){
                    sb.insert(0, "零");
                    zero = true;
                }
            }else{
                sb.insert(0, shi[index]);
                sb.insert(0, chineseNum[lastNum - 1]);
            }

            index++;
            nextNum = lastNum;
            temp /= 10;
        }
        //temp还有一位

        //temp位于十位上，temp == 1
        if(index == 1 && temp == 1){
            sb.insert(0, shi[index]);
        }else{
            sb.insert(0, shi[index]);   //单位
            sb.insert(0, chineseNum[temp % 10 - 1]);
        }
        return sb.toString();
    }
}

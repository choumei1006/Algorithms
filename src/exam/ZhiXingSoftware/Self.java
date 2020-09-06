package exam.ZhiXingSoftware;

import java.util.Scanner;

/**
 * @author:choumei
 * @date:2020/8/31 8:44
 * @Description:
 */
public class Self {
    static String[] chinese = new String[]{"一", "二", "三", "四", "五", "六", "七", "八", "九", "十"};
    static String[] shi = new String[]{"","十","百","千"};
    static String[] wan = new String[]{"","万","亿","万亿"};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String input = sc.nextLine().trim();
            String chineseStr = transIntegerToChinese(input);
            System.out.println(chineseStr);
        }
    }

    /**
     * 将输入数字字符串转换为中文读法
     *
     * @param input
     * @return
     */
    public static String transIntegerToChinese(String input) {
        //特判
        if ("0".equals(input)) {
            return "零";
        }

        StringBuilder sb = new StringBuilder();

        int len = input.length();
        int index = len - 1;
        int wanCnt = 0;

        //每四位一处理
        while(index >= 0 && index - 3 >= 0){
            String tmp4Rst = Trans4NumToChinese(input.substring(index - 3, index + 1));

            //不为零
            if(!"零".equals(tmp4Rst)){
                sb.insert(0, wan[wanCnt]);
                sb.insert(0, tmp4Rst);
            }

            index -= 4;
            wanCnt++;
        }

        //不足4位的剩余
        if(index != -1){
            String tmp4Rst = Trans4NumToChinese(input.substring(0, index + 1));

            //不为零
            if(!"零".equals(tmp4Rst)){
                sb.insert(0, wan[wanCnt]);
                sb.insert(0, tmp4Rst);
            }
        }
        return sb.toString();
    }

    public static String Trans4NumToChinese(String input){
        return "";
    }

}

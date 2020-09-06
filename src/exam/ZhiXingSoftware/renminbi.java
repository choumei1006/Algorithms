package exam.ZhiXingSoftware;

import java.util.Scanner;
/**
 * @author:choumei
 * @date:2020/8/30 14:37
 * @Description:
 */


/**
 * @create 2020-06-28-17:11
 */
public class renminbi {
    static String[] china = {"壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    static String[] shi = {"", "拾", "佰", "仟"};
    static String[] wang = {"", "万", "亿", "万亿"};
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String input = scanner.nextLine();
            String[] arr = input.split("\\.");    //以小数点分割
            String sb_right = xiaoshu(arr[1]);
            String sb_left = zhengshu(arr[0]);
            StringBuilder sb = new StringBuilder();
            sb.insert(0, sb_right);
            if(!sb_left.equals("")){
                sb.insert(0, "元");
            }
            sb.insert(0, sb_left);
            sb.insert(0, "人民币");
            System.out.println(sb.toString());
        }
    }

    /**
     * 将整数部分转换为中文人民币格式
     * @param input
     * @return
     */
    public static String zhengshu(String input){
        if("0".equals(input)) return "";
        StringBuilder sb = new StringBuilder();
        int len = input.length();
        int index = len - 1;   //从右边开始访问，右边界下标
        int k = 0;   //万的个数

        //每四位一转换
        while(index >= 0 && index - 3 >= 0){
            //四位转换
            String temp = siweishu(input.substring(index - 3, index + 1));

            //如果这四位不全为0，后面加万的后缀
            if(!"零".equals(temp)){
                if(temp.substring(temp.length() - 1, temp.length()).equals("零")){
                    temp = temp.substring(0, temp.length() - 1);
                }
                sb.insert(0, wang[k]);     //其后添加“万”、“亿”（根据万的个数决定）
                sb.insert(0, temp);
            }
            index = index - 4;
            k++;
        }
        //不满足四位

        //整数部分不是4的倍数（例如，4，index = 3 进入上面的循环，最后index = index - 4 = -1）
        if(index != -1){
            String temp = siweishu(input.substring(0, index + 1));
            //如果这四位不全为0，后面加万的后缀
            if(!"零".equals(temp)){
                sb.insert(0, wang[k]);     //其后添加“万”、“亿”（根据万的个数决定）
                sb.insert(0, temp);
            }
        }
        return sb.toString();
    }
    public static String siweishu(String input){
        StringBuilder sb = new StringBuilder();
        int temp = Integer.valueOf(input);
        if(temp == 0) return "零";
        int index = 0;  //从右开始访问，已访问了几个数字
        boolean flag = false;

        //数字大于1位
        while(temp / 10 != 0){
            int a = temp % 10;
            if(a == 0){
                //还没遇到零 && 不是最后一位0
                if(!flag && index != 0){
                    sb.insert(0, "零");
                    flag = true;
                }
            }else{
                sb.insert(0, shi[index]);   //后缀（“”，“拾”，“佰”，“仟”）
                sb.insert(0, china[a - 1]);  //中文数字
            }

            index++;
            temp = temp / 10;
        }
        //temp只有一位

        //temp位于十位上，且temp == 1
        if(index == 1 && temp == 1){
            sb.insert(0, shi[index]);   //壹拾X  ->   拾X
        }else{
            sb.insert(0, shi[index]);
            sb.insert(0, china[temp % 10 - 1]);
        }
        return sb.toString();
    }

    public static String xiaoshu(String input){
        StringBuilder sb = new StringBuilder();
        if(input.charAt(0) == '0' && input.charAt(1) == '0'){
            sb.append("整");
        }else{
            if(input.charAt(0) != '0'){
                sb.append(china[Integer.valueOf(input.substring(0, 1)) - 1] + "角");
            }
            if(input.charAt(1) != '0'){
                sb.append(china[Integer.valueOf(input.substring(1, 2)) - 1] + "分");
            }
        }
        return sb.toString();
    }
}
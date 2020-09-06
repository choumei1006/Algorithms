package exam.ZhiXingSoftware;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author:choumei
 * @date:2020/9/1 9:32
 * @Description: 【整数转中文读音】
 * 描述：写一个算法小程序，完成下面的功能要求：
 * 输入：任意整数的字符串表达式
 * 输出：把上面输入的整数的中文读音输出出来；
 *
 * 举例：
    输入：-2
    输出：负二

    输入：0
    输出：零

    输入：10
    输出：十

    输入：100
    输出：一百

    输入：101
    输出：一百零一

    输入：10，0001
    输出：十万零一

    输入：20，3001
    输出：二十万三千零一

    输入：10，0000，0000
    输出：十亿

    输入：13，0000，6000
    输出：十三亿零六千

    输入：10，0000，0000，0000
    输出：十万亿

    输入：10，0000，0000，0010
    输出：十万亿零一十

    输入：1，3003，3213，0043，4300，3224
    输出：一万三千零三亿三千二百一十三万零四十三亿四千三百万三千二百二十四

    输入：1010，0000
    输出：一千零一十万

 * */
public class TransInteger2Chinese_3 {
    private static String[] CHINESE_NUMBER = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九", "十"};
    private static String[] UNIT_SHI = {"", "十", "百", "千"};
    private static String[] UNIT_WAN = {"", "万", "亿", "万", "亿", "万", "亿", "万", "亿"};

    public static void main(String[] args) {
        //循环接收输入
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String input = sc.nextLine().trim();

            //0、特判
            if(null == input || input.length() == 0){
                System.out.println("");
                return;
            }

            //1、暂存正负标志
            boolean isNeg = false;
            if('-' == input.charAt(0)){
                isNeg = true;
                input = input.substring(1);
            }

            //2、将输入串每4位划分，存入list
            List<String> list4 = splitInput(input);   //4位数字串集合

            //3、遍历list,分别转换每个四位数字串,存入数字、单位串
            List<String> resNumber = new ArrayList<>();     //结果数字中文集
            List<String> resUnit = new ArrayList<>();     //结果单位中文串
            int listSize = list4.size();
            boolean isLastWan = false;

            for (int i = 0; i < listSize; i++) {
                //更新lastWan标志
                if(listSize > 1 && i == listSize - 1 ){       //特：10
                    isLastWan = true;
                }
                String chnsStr4 = trans4StrToChns(list4.get(i), isLastWan);   //四位串转换

                //将数字、单位转换结果存入对应集合
                resNumber.add(chnsStr4);
                resUnit.add(UNIT_WAN[listSize - i - 1]);
            }

            //4、处理零
            StringBuilder res = zeroHelper(resNumber, resUnit);


            //5、处理负号
            if(isNeg){
                res.insert(0, "负");    //特：-2
            }
            System.out.println(res.toString());
        }
    }

    /**
     * 四位分割数字串
     *
     * @param input
     * @return
     */
    public static List<String> splitInput(String input) {
        //结果集
        List<String> list = new ArrayList<>();

        //特判
        if (null == input || input.length() == 0) {
            return list;
        }

        int len = input.length();
        int idx = len - 1;

        //四位划分
        while(idx > 0 && idx - 3 >= 0){
            list.add(0, input.substring(idx - 3, idx + 1));
            idx -= 4;
        }
        //剩余不足四位部分
        if(idx != -1){
            list.add(0, input.substring(0, idx + 1));
        }

        return list;
    }


    /**
     * 转换四位数字串 -> 中文串
     * 问题：
     * @param str
     * @param isLastWan
     * @return
     */
    public static String trans4StrToChns(String str, boolean isLastWan){
        //特判
        if(null == str || str.length() == 0){
            return "";
        }

        StringBuilder res = new StringBuilder();   //结果串

        //0、将数字串转换为数字
        int strVal = Integer.parseInt(str);

        //1、前缀零标志位
        boolean isPreZero = false;
        if(strVal < 1000){
            isPreZero = true;
        }

        //2、循环转换每一位
        int cnt = 0;    //计数器：已转换位数
        boolean hasZero = false;
        int nextNum = -1;

        //3、大于两位数
        while(strVal / 10 != 0){
            int a = strVal % 10;   //取最后一位
            //0
            if(a == 0){
                //还未遇到0  &&  不是最后一位   && 下一位不是零
                if(!hasZero && cnt != 0 && nextNum != 0){     //特： 1000   1100   1011
                    res.insert(0, "零");
                }
            }
            //非0
            else{
                res.insert(0, UNIT_SHI[cnt]);
                res.insert(0, CHINESE_NUMBER[a]);
            }

            //循环条件更新
            cnt++;
            nextNum = a;
            strVal /= 10;
        }

        //4、剩余一位
        // 非最右wan分组 && ==1  && 位于十位上   .
        if(!isLastWan && strVal == 1 && cnt == 1){     //注：
            res.insert(0, UNIT_SHI[cnt]);   //一十  -> 十    特：10 0010
        }else{
            res.insert(0, UNIT_SHI[cnt]);
            res.insert(0, CHINESE_NUMBER[strVal]);
        }

        //5、前缀零处理
        if(isPreZero && !"零".equals(res.toString())){     //反： '0'
            res.insert(0, "零");
        }
        return res.toString();
    }

    /**
     * 拼接中文串
     * 解决：中间位置多个零问题，末尾零拼接
     * 注：该方法不能解决四位中文串中前导零导致的结果串前导零问题 如 -234  负零二百三十四
     * @param number
     * @param unit
     * @return
     */
    public static StringBuilder zeroHelper(List<String> number, List<String> unit) {
        StringBuilder res = new StringBuilder();

        //特判
        if (null == number || null == unit || number.size() != unit.size()) {
            return res;
        }

        int len = number.size();

        //遍历-拼接
        for (int i = len - 1; i >= 0; i--) {
            //数字串为0
            if ("零".equals(number.get(i))) {
                //最左、最右 、零万
                if (len > 1 && (i == 0 || i == len - 1 )) {       //反：   '0'
                    continue;
                }
                //零万
                if("万".equals(unit.get(i))){
                   if(res.length() > 0 && !"零".equals(res.substring(0, 1))){   //特：10 '0000' 0011
                       res.insert(0, number.get(i));
                   }
                   continue;
                }
                //零亿
                if("亿".equals(unit.get(i))){
                    res.insert(0, unit.get(i));    //特：10 '0000' 0013 1122
                    continue;
                }
            }
            //数字串以零开头，并且即将放在开头
            /*else if(res.toString().length() == 0 && "零".equals(number.get(i).substring(0,1))){
                res.insert(0, unit.get(i));
                res.insert(0, number.get(i).substring(1));
                continue;
            }*/

            res.insert(0, unit.get(i));
            res.insert(0, number.get(i));
        }

        //处理前缀零
        if(res.length() > 1 && "零".equals(res.substring(0, 1))){      //反：'0'
            res.delete(0, 1);
        }
        return res;
    }
}

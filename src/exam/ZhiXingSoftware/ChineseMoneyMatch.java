package exam.ZhiXingSoftware;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author:choumei
 * @date:2020/8/31 0:21
 * @Description:
 */
public class ChineseMoneyMatch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            double number = scanner.nextDouble();
            String value = new DecimalFormat("#0.00").format(number);
            String[] segments = value.split("\\.");
            long integer = Long.valueOf(segments[0]);
            initUnitArray(segments[0].length());
            int decimal = Integer.valueOf(segments[1]);
            String result = "人民币" + parseInteger(integer, 0) + "元" + parseDecimal(decimal);
            result = result.replaceAll("(\\u96f6[\\u62fe\\u4f70\\u4edf])+", "零"); //移除连续的零
            result = result.replaceAll("(\\u96f6+)([\\u5143\\u4e07\\u4ebf])", "$2"); //移除某些特殊单位前面的零
            result = result.replaceAll("(\\u4ebf)(\\u4e07)", "$1"); //不存在亿万的单位，需要转换。
            result = result.replaceAll("(\\u5e01)(\\u5143)", "$1"); //不存在此单位，进行转换
            result = result.replaceAll("(\\u58f9)(\\u62fe)", "$2");//“壹拾”替换成“拾”
            System.out.println(result);
        }
    }

    private static String parseInteger(long origin, int parsedLength) {
        String formatted = parseNum((int)(origin % 10)) + getUnit(parsedLength);
        if (origin >= 10) {
            return parseInteger(origin / 10, parsedLength + 1) + formatted;
        }
        return formatted;
    }

    private static String parseDecimal(int origin) {
        if (origin == 0) {
            return "整";
        } else {
            return (origin / 10 != 0 ? parseNum(origin / 10) + "角" : "") + (origin % 10 != 0 ? parseNum(origin % 10) + "分" : "");
        }
    }

    private static String parseNum(int num) {
        String[] translate = {
                "零", "壹", "贰", "叁",
                "肆", "伍", "陆", "柒",
                "捌", "玖"
        };
        return translate[num];
    }

    private static List<String> UNITS;

    private static void initUnitArray(int numLength) {
        String[] units = {
                "", "拾", "佰", "仟",
                "万", "拾", "佰", "仟",
                "亿", "拾", "佰", "仟",
                "万", "拾", "佰", "仟"
        };
        UNITS = new ArrayList<>(numLength);
        for (String item : units) {
            UNITS.add(item);
        }
        if (numLength > units.length) {
            int offset = numLength - units.length;
            for (int index = 0; index < offset; index++) {
                switch(index % 8) {
                    case 0:
                        UNITS.add("万");
                        break;
                    case 1:
                    case 5:
                        UNITS.add("拾");
                        break;
                    case 2:
                    case 6:
                        UNITS.add("佰");
                        break;
                    case 3:
                    case 7:
                        UNITS.add("仟");
                        break;
                    case 4:
                        UNITS.add("亿");
                        break;
                }
            }
        }
    }

    private static String getUnit(int length) {
        return UNITS.get(length);
    }
}

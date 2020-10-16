package exam.CVTE.Autumn;

/**
 * @author:choumei
 * @date:2020/9/17 19:36
 * @Description:
 */
public class CardEncode_2 {
    public static void main(String[] args) {
        System.out.println(cardEncode("1A2w3e4r"));
    }

    /**
     * 返回读卡器读到的卡号
     * @param cardNo
     * @return
     */
    public static  String cardEncode(String cardNo){
        //特判
        if(null == cardNo || cardNo.length() == 0){
            return "";
        }

        //指针右移，拼接
        StringBuilder sb = new StringBuilder();
        int numCnt = 0;
        for(char c : cardNo.toCharArray()){
            //数字
            if(c >= '0' && c <= '9'){
                sb.insert(numCnt, c);
                numCnt++;
            }
            //字母
            else if((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')){
                sb.append(Integer.valueOf(c));
            }
        }
        return sb.toString();
    }
}

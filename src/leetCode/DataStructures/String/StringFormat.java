package leetCode.DataStructures.String;

import org.junit.Test;

/**
 * @author:choumei
 * @date:2020/8/6 16:49
 * @Description:
 */
public class StringFormat {
    @Test
    public void test(){
        sout("2a2abb10chh");
    }

    public void sout(String str) {
        //特判
        if (null == str || str.length() == 0) {
            return;
        }
        int l = 0, r = 0;
        while(l <= r && r < str.length()){
            if(str.charAt(r) >= 97 && str.charAt(r) <= 122){    //字符
                if(!(str.charAt(l) >= 97 && str.charAt(r) <= 122 )){   //l指向数字
                    System.out.print(str.substring(l, r) + ":");
                    l = r;

                }
                r++;
            }else{    //数字
                if(str.charAt(l) >= 97 && str.charAt(r) <= 122){   //l指向字符
                    System.out.print(str.substring(l, r) + "\r\n");
                    l = r;
                }
                r ++;
            }
        }

        System.out.println(str.substring(l, str.length()));
    }
}

package leetCode.DataStructures.String;

/**
 * @author:choumei
 * @date:2020/4/15 16:21
 * @Description:
 */
public class StringBuilderVSStringBuffer {
    public static void main(String[] args) throws InterruptedException {
        //StringBuilder sbd = new StringBuilder();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        //sbd.append("a");
                        sbf.append("a");
                    }
                }
            }).start();
        }

        Thread.sleep(1000);
        //System.out.println(sbd.length());
        System.out.println(sbf.length());
    }
}

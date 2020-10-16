package exam.QiAnXin.ShanShan;

/**
 * @author:choumei
 * @date:2020/9/12 11:23
 * @Description:
 */
public class Candy_1 {
    public static void main(String[] args) {
        System.out.println(maxCandies(new int[]{3,5,7,2,8,8,15,3}, new int[]{1,0,1,0,1,0,1,0}, 3));
    }

    /**
     *
     * @param candies
     * @param coins
     * @param n
     * @return
     */
    public static  int maxCandies(int[] candies, int[] coins, int n){
        //1、特判
        if(null == candies || null == coins
                || candies.length == 0 || coins.length == 0
                || candies.length != coins.length){
            return 0;
        }

        int pkgCnt = candies.length;
        int maxCnt = 0;

        //2、获取不使用魔法时可获得的糖果数
        int cnt1 = 0;
        for (int i = 0; i < pkgCnt; i++) {
            cnt1 += coins[i] > 0 ? candies[i] : 0;
        }

        //3、滑动窗口
        int left = 0, right = 0;
        //初始化右指针
        while(right < n - 1){
            maxCnt = Math.max(maxCnt, cnt1 + ( coins[right] < 1 ? candies[right] : 0 ));
            right++;
        }
        int tmpCnt = maxCnt;
        while(right < pkgCnt - 1){
            left++;
            right++;
            tmpCnt += coins[right] < 1 ? candies[right] : 0;
            tmpCnt -= coins[left - 1] < 1 ? candies[left - 1] : 0;
            maxCnt = Math.max(maxCnt, tmpCnt);
        }

        //4、返回
        return maxCnt;

    }
}

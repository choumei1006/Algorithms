package Demo.DP;

/**
 * @author:choumei
 * @date:2020/2/19 10:27
 * @Description: 给定数组arr，判断i下标之前是否存在任意数组之和为s;
 */
public class SumIfAbscent {
    public static void main(String[] args) {
        int[] arr = {3,34,4,12,5,2};
        System.out.println(rec_subset(arr,arr.length-1,9));
        System.out.println(dp_subset(arr,arr.length-1,9));

    }

    /**
     * 递归
     * @param arr
     * @param i
     * @param s
     * @return
     */
    public static boolean rec_subset(int[] arr,int i,int s){
        if(s == 0){
            return true;
        }
        if(i == 0){
            return arr[i] == s;
        }
        if(arr[i] > s){
            return rec_subset(arr,i-1,s);
        }
        return rec_subset(arr,i-1,s-arr[i]) || rec_subset(arr,i-1,s);
    }

    /**
     * dp
     * @param arr
     * @param i
     * @param s
     * @return
     */
    public static boolean dp_subset(int[] arr,int i,int s){
        boolean[][] tempArr = new boolean[i+1][s+1];

        for (int j = 0; j < i+1 ; j++) {
            tempArr[j][0] = true;
        }
        for (int j = 0; j < s+1 ; j++) {
            tempArr[0][j] = false;
        }
        tempArr[0][arr[0]] = true;
        for (int m = 1; m < i+1 ; m++) {
            for (int n = 1; n < s+1 ; n++) {
                if(arr[m] > n){
                    tempArr[m][n] = tempArr[m-1][n];
                }else {
                    tempArr[m][n] = tempArr[m - 1][n - arr[m]] || tempArr[m - 1][n];
                }
            }
        }
        return tempArr[i][s];
    }
}

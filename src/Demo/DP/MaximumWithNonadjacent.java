package Demo.DP;

/**
 * @author:choumei
 * @date:2020/2/19 10:05
 * @Description: 给定数组arr,在i之前的数组中取任意不相邻的元素，使其和最大；
 */
public class MaximumWithNonadjacent {
    public static void main(String[] args) {
        int[] arr = {1,2,4,1,9,3,3};
        System.out.println("最大值："+rec_opt(arr,arr.length-1));
        System.out.println("最大值："+dp_opt(arr,0));
    }

    /**
     * 递归实现
     * @param arr
     * @param i
     * @return
     */
    public static int rec_opt(int[] arr,int i){
        if(i == 0){
            return arr[0];
        }
        if(i == 1){
            return Math.max(arr[0],arr[1]);
        }
        int A = rec_opt(arr,i-1);    //不选
        int B = rec_opt(arr,i-2)+arr[i];   //选
        return Math.max(A,B);
    }

    /**
     * dp
     * @param arr
     * @param i
     * @return
     */
    public static int dp_opt(int[] arr,int i){
        int[] tempArr = new int[i+1];
        if(tempArr.length == 1){
            return arr[0];
        }
        tempArr[0] = arr[0];
        tempArr[1] = Math.max(arr[0],arr[1]);
        for (int j = 2; j <= i  ; j++) {
            int A = tempArr[j-1];     //不选
            int B = tempArr[j-2]+arr[j];  //选
            tempArr[j] = Math.max(A,B);
        }
        return tempArr[tempArr.length-1];
    }
}

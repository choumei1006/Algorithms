package exam.Baidu;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author:choumei
 * @date:2020/9/3 20:11
 * @Description:
 */
public class Card_1 {
    private static int maxInteger = -1;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();  //n
        in.nextLine();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(maxList(arr));
    }

    /**
     * 获取数组中组成的最大的能被90整除的数字
     *
     * @param arr
     * @return
     */
    public static int maxList(int[] arr) {
        //特判
        if (null == arr || arr.length == 0) {
            return -1;
        }
        boolean has0 = false;
        boolean has5 = false;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0){
                has0 = true;
            }else if(arr[i] == 5){
                has5 = true;
            }else{
                return -1;
            }
        }

        if(!has0 || !has5){
            return -1;
        }
        permute(arr);
        return maxInteger;
    }


    //排列
    public static void permute(int[] nums){
        //已访问路径
        //LinkedList<Integer> track = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        StringBuilder track = new StringBuilder();
        //访问
        backTrack(nums, track, used);
    }

    //回溯函数
    public static void backTrack(int[] nums, StringBuilder track, boolean[] used){
         //更新最大值
        int trackVal = track.length() > 0 ? Integer.parseInt(track.toString()) : 0;
        if(trackVal % 90 == 0 && trackVal > maxInteger){
            maxInteger = Math.max(maxInteger, trackVal);
        }
        for (int i = 0; i < used.length; i++) {
            if(used[i]){
                continue;
            }
            track.append(nums[i]);
            used[i] = true;
            backTrack(nums, track, used);
            track.delete(track.length() - 1, track.length());
        }
    }
}

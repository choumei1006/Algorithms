package exam.Ali;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author:choumei
 * @date:2020/8/28 19:29
 * @Description:
 */
public class Permute {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String optionStr = sc.nextLine().trim();
        String[] options = optionStr.split("\\s+");
        String n = options[0];
        int m = Integer.parseInt(options[1]);

        //获取n的全排列数字
        List<Integer> res = new LinkedList<>();
        //已访问路径
        StringBuilder track = new StringBuilder();
        int cnt = 0;
        boolean[] visited = new boolean[n.length()];
        //访问
        backTrack(n.toCharArray(), visited,track, res, m, cnt);

        System.out.println(cnt);

    }



    //回溯函数
    public static void backTrack(char[] nums, boolean[] visited, StringBuilder track, List<Integer> res, int m, int cnt){
        //是否满足一个排列
        if(track.length() == nums.length){
            Integer tmp  = Integer.parseInt(track.toString());
            if(!res.contains(tmp)){
                res.add(tmp);
                if(tmp > m){
                    cnt++;
                }
            }
            return;
        }
        for(int i = 0; i < nums.length; i++){
            int curr = nums[i];
            if(visited[i]){
                continue;
            }
            track.append(curr);
            visited[i] = true;
            backTrack(nums, visited, track, res, m, cnt);
            track.delete(track.length() - 1, track.length());
            visited[i] = false;
        }
    }
}

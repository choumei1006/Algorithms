package exam.DJI;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author:choumei
 * @date:2020/8/16 20:21
 * @Description:
 */
public class Gamer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String optionStr = sc.nextLine().trim();
        String[] options = optionStr.split("\\s+");
        int N = Integer.parseInt(options[0]);  //N ��Ϸ��
        int X = Integer.parseInt(options[1]);   //  ������

        //�洢N����Ϸ ����-�ɾ�ֵ
        int[] v = new int[N];    //��������
        int[] w = new int[N];   //��Ϸ�ɾ�ֵ
        for (int i = 0; i < N; i++) {
            String tmpP = sc.nextLine().trim();
            String[] pOptions = tmpP.split("\\s+");
            int value = Integer.parseInt(pOptions[0]);
            int weight = Integer.parseInt(pOptions[1]);

            v[i] = value;
            w[i] = weight;
        }

        //����
        if(null == v || null == w || v.length == 0 || w.length == 0){
            System.out.println(0);
            return;
        }

        int[][] temp = new int[N][X + 1];
        for (int j = 0; j < X + 1; j++) {
            temp[0][j] = 0;
        }

        for (int i = 0; i < N; i++) {
            temp[i][0] = 0;
        }

        //0-1 ����������
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < X + 1; j++) {
                if(w[i] <= j){
                    temp[i][j] = Math.max(temp[i - 1][j], temp[i - 1][j - w[i]] + v[i]);
                }else{
                    temp[i][j] = temp[i - 1][j];
                }
            }
        }

        //��������
        System.out.println(temp[N - 1][X]);
    }
}

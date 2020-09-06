package leetCode.ClassicalThinking.Mathematics;

import java.util.Scanner;

/**
 * @author:choumei
 * @date:2020/8/29 10:35
 * @Description: 给你一个4面体的6条边,要你求出该4面体的体积.
 */
public class PyramidsVolume {
    public static void main(String[] args) {
        //输入
        Scanner sc = new Scanner(System.in);
        double[] sides = new double[6];
        for (int i = 0; i < 6; i++) {
            sides[i] = sc.nextDouble();
        }

        //输出
        System.out.println(getVolume(sides));
    }

    /**
     * 获取四面体的体积
     * @param sides
     * @return
     */
    public static double getVolume(double[] sides){
        double p = sides[0];
        double q = sides[0];
        double r = sides[0];
        double n = sides[0];
        double m = sides[0];
        double l = sides[0];

        double temp1= (p*p+q*q-n*n)/2;
        double temp2= (p*p+r*r-m*m)/2;
        double temp3= (q*q+r*r-l*l)/2;

        double M11=q*q*r*r-temp3*temp3;//余子式M11
        double M12=temp1*r*r-temp2*temp3;//M12
        double M13=temp1*temp3-q*q*temp2;//M13

        //行列式的值 == a11*A11+a12*A12+a13*A13 其中A11为代数余子式
        double S = Math.sqrt( p * p * M11 - temp1 * M12 + temp2 * M13 )/6;
        return S;
    }

}

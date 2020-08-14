package demo.SparseArray;

import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author:choumei
 * @date:2020/2/5 19:25
 * @Description: 原始二维数组->稀疏数组->存盘   、   读取文件->稀疏数组->原始二维数组
 */
public class a_ChessArray2SparseArray {
    public static void main(String[] args) throws IOException {
        //1、创建原始二维数组
        int[][] chessArr = new int[11][11];
        chessArr[2][3] = 1;
        chessArr[3][4] = 2;

        //测试输出
        System.out.println("---------------------原始二维数组-------------------");
        for (int i = 0; i < chessArr.length ; i++) {
            for (int j = 0; j < chessArr[i].length ; j++) {
                System.out.print(chessArr[i][j]+"\t");
            }
            System.out.println();
        }
        //2、获取稀疏数组
        int[][] sparseArr = chessArray2SparseArray(chessArr);
        //测试输出
        System.out.println("---------------------稀疏数组-------------------");
        for (int i = 0; i < sparseArr.length ; i++) {
            for (int j = 0; j < sparseArr[i].length ; j++) {
                System.out.print(sparseArr[i][j]+"\t");
            }
            System.out.println();
        }
        //3、存档
        saveSparseArray(sparseArr,"src/outputDir/sparseArray.txt");
        //4、读取文件到稀疏数组
        int[][] sparseArrReaded = showSparseArray("src/outputDir/sparseArray.txt");
        System.out.println("---------------------转换后：稀疏数组-------------------");
        for (int i = 0; i < sparseArrReaded.length ; i++) {
            for (int j = 0; j < sparseArrReaded[i].length ; j++) {
                System.out.print(sparseArrReaded[i][j]+"\t");
            }
            System.out.println();
        }
        //5、稀疏数组转换为原始二维数组
        int[][] chessArrReaded = sparseArray2ChessArray(sparseArrReaded);
        //测试输出
        System.out.println("---------------------原始二维数组-------------------");
        for (int i = 0; i < chessArrReaded.length ; i++) {
            for (int j = 0; j < chessArrReaded[i].length ; j++) {
                System.out.print(chessArrReaded[i][j]+"\t");
            }
            System.out.println();
        }


    }

    /**
     * 原始二维数组->稀疏数组->存盘
     * @param chessArr
     */
    public static int[][] chessArray2SparseArray(int[][] chessArr){
        //1、获取原始二维数组的长、宽
        int m = chessArr.length, n = chessArr[0].length;
        //2、定义map<val,map<i,j>>
        Map<Integer, Map<Integer,Integer>> map = new HashMap<>();
        //2、遍历原始二维数组，获取棋子个数和，0-没有棋子  1-黑棋   2-蓝棋,map添加棋子
        for (int i = 0; i < chessArr.length ; i++) {
            for (int j = 0; j < chessArr[i].length ; j++) {
                if(chessArr[i][j] != 0){
                    Map<Integer,Integer> tempMap = new HashMap<>();
                    tempMap.put(i,j);
                    map.put(chessArr[i][j],tempMap);
                }
            }
        }
        //3、定义稀疏数组
        int[][] sparseArr = new int[map.size()+1][3];
        //4、遍历map,填充数组
        sparseArr[0][0] = m;
        sparseArr[0][1] = n;
        sparseArr[0][2] = map.size();

        int rowIdx = 0;

        //遍历方法一：
        /*Iterator<Map.Entry<Integer,Map<Integer,Integer>>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            rowIdx++;
            Map.Entry<Integer,Map<Integer,Integer>> entry = iterator.next();
            Iterator<Map.Entry<Integer,Integer>> tempIterator = entry.getValue().entrySet().iterator();
            while(tempIterator.hasNext()){
                Map.Entry<Integer,Integer> tempEntry = tempIterator.next();
                sparseArr[rowIdx][0] = tempEntry.getKey();
                sparseArr[rowIdx][1] = tempEntry.getValue();
            }
            sparseArr[rowIdx][2] = entry.getKey();
        }*/

        //遍历方法二：
        for(Map.Entry<Integer,Map<Integer,Integer>> entry : map.entrySet()){
            rowIdx++;
            for(Map.Entry<Integer,Integer> tempEntry : entry.getValue().entrySet()){
                sparseArr[rowIdx][0] = tempEntry.getKey();
                sparseArr[rowIdx][1] = tempEntry.getValue();
            }
            sparseArr[rowIdx][2] = entry.getKey();
        }

        //返回稀疏数组
        return sparseArr;
    }

    /**
     * 稀疏数组转换为原始二维数组
     * @param sparseArray
     * @return
     */
    public static int[][]  sparseArray2ChessArray(int[][] sparseArray){
        //1、获取原始二维数组 的长、宽，棋子数
        int m = sparseArray[0][0];
        int n = sparseArray[0][1];
        //2、创建原始二维数组
        int[][] chessArr = new int[m][n];
        //3、遍历稀疏数组，填充原始二维数组
        for (int i = 1; i < sparseArray.length ; i++) {
            chessArr[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        //4、返回原始二维数组
        return chessArr;
    }

    /**
     * 保存稀疏数组到文件中
     * @param sparseArray
     * @param outputPath
     */
    public static void saveSparseArray(int[][] sparseArray,String outputPath) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(outputPath)));
        for (int i = 0; i < sparseArray.length ; i++) {
            bw.write(arrToStr(sparseArray[i])+"\n");
            bw.flush();
        }
        bw.close();
    }

    /**
     * 获取文件中的稀疏数组
     * @param inputPath
     * @return
     */
    public static int[][] showSparseArray(String inputPath) throws IOException {
        List<int[]> sparseList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(new File(inputPath)));
        String line  = null;
        while((line = br.readLine())!= null){
            sparseList.add(strToArr(line));
        }
        int[][]  sparseArr = new int[sparseList.size()][];
        for (int i = 0; i < sparseArr.length ; i++) {
            sparseArr[i] = sparseList.get(i);
        }
        return sparseArr;
    }

    public static String arrToStr(int[] arr){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length ; i++) {
            sb.append(arr[i]+",");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public  static int[] strToArr(String str){
        String[] strArr = str.split(",");
        int[] rst = new int[strArr.length];
        for (int i = 0; i < rst.length ; i++) {
            rst[i] = Integer.parseInt(strArr[i]);
        }
        return rst;
    }
}

package gotoOffer.Tree;

/**
 * @author:choumei
 * @date:2020/2/19 14:44
 * @Description: 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class VerifyPostSequence {
    public static void main(String[] args) {
        System.out.println(VerifySquenceOfBST(new int[]{7,4,6,5}));
    }
    public static  boolean VerifySquenceOfBST(int [] sequence) {
        if(null == sequence || sequence.length == 0){
            return false;
        }
        return verifyHelper(sequence,0,sequence.length-1);
    }
    public static boolean verifyHelper(int[] arr,int start,int end){
        if(start >= end){
            return true;
        }
        int root = arr[end];
        int flag = 0;
        //找到左子树的分界点
        for (flag = 0; flag < end ; flag++) {
            if(arr[flag] > root){
                break;
            }
        }
        //遍历右子树中是否存在小于root的值
        for (int i = flag; i < end ; i++) {
            if(arr[i] < root){
                return false;
            }
        }
        return verifyHelper(arr,start,flag-1) && verifyHelper(arr,flag,end-1);
    }
}

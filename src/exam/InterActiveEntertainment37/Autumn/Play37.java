package exam.InterActiveEntertainment37.Autumn;

/**
 * @author:choumei
 * @date:2020/9/2 19:39
 * @Description:
 */
public class Play37 {
    public static void main(String[] args) {

    }

    /**
     * 对应等级的所需的一级宝石个数
     * @param level
     * @return
     */
    public int getNum(int level){
        if(level == 2){
            return 3;
        }else{
            return (int) (8 * Math.pow(2.5, level - 3));
        }
    }
}

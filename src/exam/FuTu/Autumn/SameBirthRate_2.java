package exam.FuTu.Autumn;

/**
 * @author:choumei
 * @date:2020/9/18 10:40
 * @Description:
 */
public class SameBirthRate_2 {
    public static void main(String[] args) {

    }

    /*
    select user.u_id, u_name, t_tb.cnt
    from (select tid, uid, count(tid) cnt,
       from thread
       group by uid
       ) t_tb, user
    where t_tb.uid = user.uid
    order by t_tb.cnt desc
    limit 0, 9



    */
}

package atheima.cglib;


/**
 * 一个演员
 * @author LM_Code
 * @create 2019-02-25-16:37
 */
public class Actor {
    //基本的演出
    public void basicAct(float money){
        System.out.println("CGLIB拿到钱，开始基本的表演：" + money);
    }
    //危险的演出
    public void dangerAct(float money){
        System.out.println("CGLIB拿到钱，开始危险的表演：" + money);
    }
}

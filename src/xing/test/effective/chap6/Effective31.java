package xing.test.effective.chap6;

/**
 * Created by Administrator on 2016/9/19.
 */
enum Ensemble {
    SOLO,DUET,TRIO,QUARTET,QUINTET,SEXTET,SEPTET,OCTET,NONET,DECTET;

    public int numberOfMusicians(){
        return ordinal() + 1;//不要使用ordinal来进行排序
    }
}
enum Ensemble2{
    SOLO(1),DUET(2);

    private final int numberOfMusicians;
    Ensemble2(int size){
        this.numberOfMusicians = size;
    }
    public int numberOfMusicians(){
        return numberOfMusicians;
    }
}
public class Effective31 {

}

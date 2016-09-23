package xing.test.effective.chap6;

import java.util.Arrays;
import java.util.Collection;

/**
 * 利用接口进行枚举的扩展
 *
 * 弊端就是无法直接继承现有的枚举
 *
 * Created by Administrator on 2016/9/19.
 */
interface Operation3{
    double apply(double x,double y);
}
enum BasicOperation implements Operation3 {
    PLUS("+"){
        public double apply(double x,double y){
            return x+y;
        }
    },
    MINUS("-"){
        public double apply(double x,double y){
            return x-y;
        }
    },
    TIMES("*"){
        public double apply(double x,double y){
            return x*y;
        }
    },
    DIVIDE("/"){
        public double apply(double x,double y){
            return x/y;
        }
    };
    private final String symbol;
    BasicOperation(String symbol){
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
enum ExtendedOpertion implements Operation3 {
    EXP("^"){
        public double apply(double x,double y){
            return Math.pow(x,y);
        }
    },
    REMATNDER("%"){
        public double apply(double x,double y){
            return x%y;
        }
    };
    private final String symbol;
    ExtendedOpertion(String symbol){
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
public class Effective34 {
    public static void main(String[] args) {
        double x = Double.parseDouble("6");
        double y = Double.parseDouble("2");

        test(ExtendedOpertion.class,x,y);
        test2(Arrays.asList(ExtendedOpertion.values()),x,y);
    }
    // <T extends Enum<T> & Operation3> 确保传入的即是枚举，又是Operation3的实现类
    private static <T extends Enum<T> & Operation3> void test(Class<T> opSet,double x,double y){
        // getEnumConstants可以通过Class的不同返回，如果是enum则返回枚举的值，如果是普通的类，则返回Null
        for(Operation3 op : opSet.getEnumConstants()){
            System.out.printf("%f %s %f = %f%n",x,op,y,op.apply(x,y));
        }
    }
    //这种方式简单一点
    private static void test2(Collection<? extends Operation3> opSet,double x,double y){
        for(Operation3 op : opSet){
            System.out.printf("%f %s %f = %f%n",x,op,y,op.apply(x,y));
        }
    }
}

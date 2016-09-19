package xing.test.effective.chap6;

import java.util.HashMap;
import java.util.Map;
/**
 * 枚举和注解
 *
 * Created by Administrator on 2016/9/19.
 */
enum Planet{
    MERCURY (3.302e+23,2.439e6),
    VENUS (4.869e+24,6.052e6),
    EARTH (4.869e+24,6.052e6),
    MARS(4.869e+24,6.052e6),
    JUPITER (4.869e+24,6.052e6),
    SATURN (4.869e+24,6.052e6),
    URANUS   (4.869e+24,6.052e6),
    NEPTUNE  (4.869e+24,6.052e6);
    private final double mass;
    private final double radius;
    private final double surfaceGravity;

    private static final double G = 6.67300E-11;

    Planet(double mass, double radius){
        this.mass = mass;
        this.radius = radius;
        surfaceGravity = G * mass / (radius * radius);
    }

    public double mass(){
        return mass;
    }
    public double radius(){
        return radius;
    }
    public double surfaceGravity(){
        return surfaceGravity;
    }
    public double surfaceWeight(double mass){
        return mass * surfaceGravity;
    }
}

/**
 * 通过抽象类，定义枚举类。
 */
enum Operation1 {
    PLUSH{double apply(double x, double y) {return x+y;}},
    MINUS{double apply(double x, double y) {return x-y;}},
    TIMES{double apply(double x, double y) {return x*y;}},
    DIVIDE{double apply(double x, double y) {return x/y;}};
    abstract double apply(double x,double y);
}
enum Operation{
    PLUSH("+"){double apply(double x, double y) {return x+y;}},
    MINUS("-"){double apply(double x, double y) {return x-y;}},
    TIMES("*"){double apply(double x, double y) {return x*y;}},
    DIVIDE("/"){double apply(double x, double y) {return x/y;}};

    private final String symbol;
    Operation(String symbol){
        this.symbol = symbol;
    }
    public String toString(){
        return symbol;
    }
    abstract double apply(double x,double y);
}


public class Effective30 {
    public static final Map<String,Operation> stringToEnum = new HashMap<String,Operation>();
    static {
        for(Operation op : Operation.values()){
            stringToEnum.put(op.toString(),op);
        }
    }
    public static Operation fromString(String symbol){
        return stringToEnum.get(symbol);
    }

    public static void main(String[] args) {
        double earthWeight = Double.parseDouble("3.302e+23");
        double mass = earthWeight / Planet.EARTH.surfaceGravity();
        for(Planet p : Planet.values()){
            System.out.printf("Weight on %s is %f%n",p,p.surfaceWeight(mass));
        }

        double x = Double.parseDouble("6");
        double y = Double.parseDouble("3");

        for (Operation op : Operation.values()) {
            System.out.printf("%f %s %f = %f%n",x,op,y,op.apply(x,y));
        }
    }
}

package xing.test.effective.chap8;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2016/9/19.
 */
public class Effective48 {
    public static void main(String[] args) {
        System.out.println(1.03-0.42);
        System.out.println(1.00-9*0.10);

        double funds = 1.0;
        int itemsBought = 0;
        for(double price = 0.10; funds>=price; price+=0.10){
            funds -= price;
            itemsBought++;
        }
        System.out.println(itemsBought + " items bought.");
        System.out.println("Change: $"+funds);

        final BigDecimal TEN_CENTS = new BigDecimal("0.10");
        int itemsBought1 = 0;
        BigDecimal funds1 = new BigDecimal("1.00");
        for(BigDecimal price = TEN_CENTS; funds1.compareTo(price) >=0; price=price.add(TEN_CENTS)){
            itemsBought1++;
            funds1 = funds1.subtract(price);
        }
        System.out.println(itemsBought1 + " items bought.");
        System.out.println("Money left over: $"+funds1);

//        int a = null;
        Integer b = null;
    }
}

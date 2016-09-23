package xing.test.effective.chap8;

import java.util.Random;

/**
 * Created by Administrator on 2016/9/19.
 */
public class Effective47 {
    public static final Random rnd = new Random();
    static int random(int n){
        return Math.abs(rnd.nextInt())%n;
    }

    public static void main(String[] args) {
        int n = 2* (Integer.MAX_VALUE / 3);
        int low = 0;
        for(int i=0; i<100000; i++){
            if(random(n) < n/2){
                low++;
            }
        }
        System.out.println(low);
    }
}

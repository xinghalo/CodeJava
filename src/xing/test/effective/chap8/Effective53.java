package xing.test.effective.chap8;

import java.util.Arrays;
import java.util.Set;

/**
 * Created by Administrator on 2016/9/24.
 */
public class Effective53 {
    public static void main(String[] args) {
        String className = "java.util.HashSet";
        Class<?> cl = null;
        try{
            cl = Class.forName(className);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        Set<String> s = null;
        try{
            s = (Set<String>)cl.newInstance();
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }catch(InstantiationException e){
            e.printStackTrace();
        }
        System.out.println(s);
    }
}

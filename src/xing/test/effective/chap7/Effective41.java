package xing.test.effective.chap7;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by Administrator on 2016/9/19.
 */
class Wine{
    String name(){
        return "wine";
    }
}
class SparklingWine extends Wine{
    @Override
    String name(){
        return "sparkling wine";
    }
}
class Champagne extends SparklingWine{
    @Override
    String name(){
        return "champage";
    }
}
public class Effective41 {
    public static String classify(Collection<?> c){
        return "Unknown Collection";
    }
    public static String classify(Set<?> s){
        return "Set";
    }
    public static String classify(List<?> lst){
        return "List";
    }

    public static void main(String[] args) {
        Collection<?>[] collections = {
                new HashSet<String>(),
                new ArrayList<BigInteger>(),
                new HashMap<String,String>().values()
        };
        for(Collection<?> c : collections){
            System.out.println(classify(c));
        }

        Wine[] wines = {
                new Wine(),new SparklingWine(),new Champagne()
        };
        for( Wine wine : wines){
            System.out.println(wine.name());
        }

        Set<Integer> set = new TreeSet<Integer>();
        List<Integer> list = new ArrayList<Integer>();

        for (int i = -3; i < 3; i++) {
            set.add(i);
            list.add(i);
        }
        for (int i = 0; i < 3; i++) {
            set.remove(i);
            list.remove(i);
        }
        System.out.println(set + " " + list);

        set = new TreeSet<Integer>();
        list = new ArrayList<Integer>();

        for (int i = -3; i < 3; i++) {
            set.add(i);
            list.add(i);
        }
        for (int i = 0; i < 3; i++) {
            set.remove(i);
            list.remove((Integer)i);
        }
        System.out.println(set + " " + list);
    }
}
